# Valid Parentheses — README

**Problem (plain English)**
Given a string `s` containing just the characters `'('`, `')'`, `'{'`, `'}'`, `'['` and `']'`, determine if the input string is **valid**.

A string is valid if:

* Open brackets must be closed by the same type of brackets.
* Open brackets must be closed in the correct order.
* An empty string is valid.

This is a classic stack problem (LeetCode #20).

---

# Examples

```
Input: "()[]{}"      -> Output: true
Input: "([{}])"      -> Output: true
Input: "(]"          -> Output: false   // wrong closing type
Input: "((()))"      -> Output: true
Input: "{[()]()}"    -> Output: true
Input: "({[})"       -> Output: false   // order mismatch
Input: ""            -> Output: true
```

---

# Constraints & Observations

* Only bracket characters are present (per problem statement).
* If string length is odd → cannot be valid (early rejection).
* Key property: every time we see a closing bracket it must match the most recent unmatched opening bracket — **LIFO** behavior → stack fits perfectly.

---

# Intuition

Process the string left-to-right:

* When we see an **opening** bracket, we *remember* what closing bracket would match it (push that expected closing bracket onto a stack).
* When we see a **closing** bracket, we check the top of the stack:

  * If stack is empty → there's no matching opening bracket → invalid.
  * If the top (expected closing) equals the current closing → pop and continue.
  * Otherwise → mismatch → invalid.
* At the end, stack must be empty — every opening had a matching closing in the right order.

Why push expected closing bracket instead of opening? It simplifies comparison: when encountering a closing bracket we just compare equality with the top element.

---

# Approaches

## Approach 1 — Brute-force removal (string replacement)

Repeatedly remove occurrences of `()`, `[]`, `{}` from the string until no more removals possible. If final string empty → valid.

**Idea:** replace `s = s.replace("()", "");` and similarly for `[]` and `{}` in a loop.

**Complexity:** O(n²) in worst-case due to repeated string copying (strings are immutable). Not recommended for large inputs.

**When it fails / drawbacks:** worst-case string like `"((((...))))"` causes many replacements; each replacement may traverse the whole string.

---

## Approach 2 — Stack (recommended)

Use a stack (LIFO). Push the expected closing bracket for every opening bracket. For each char:

* If opening → push expected closing.
* Else (closing) → if stack empty or top != char → invalid. Else pop.

**Time complexity:** O(n) — single pass.
**Space complexity:** O(n) — in worst case all are openings.

This is optimal and straightforward.

---

## Approach 3 — Using `Deque` (ArrayDeque) or a char-array as stack (optimized)

* `java.util.Stack` is synchronized and slightly slower. Use `ArrayDeque<Character>` or maintain a `char[]` as a manual stack for best performance.
* Manual `char[]` avoids boxing (`Character`) and gives best memory & speed.

**Time:** O(n)
**Space:** O(n) or O(n) char array

---

# Pseudocode (stack approach)

```
function isValid(s):
    if s.length is odd:
        return false

    create empty stack st

    for each char c in s:
        if c == '(':
            st.push(')')
        else if c == '[':
            st.push(']')
        else if c == '{':
            st.push('}')
        else:
            if st.isEmpty() or st.pop() != c:
                return false

    return st.isEmpty()
```

---

# Java Implementations

Below are multiple Java implementations: the original simple version, an improved `ArrayDeque` version, and a high-performance manual `char[]` stack version.

---

## 1) Simple (the one you provided)

```java
import java.util.Stack;

public class Solution {
    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') st.push(')');
            else if (c == '[') st.push(']');
            else if (c == '{') st.push('}');
            else if (st.isEmpty() || st.pop() != c) return false;
        }

        return st.isEmpty();
    }

    public static void main(String[] args) {
        String[] tests = {
            "()[]{}", "([{}])", "(]", "((()))", "{[()]()}", "({[})", ""
        };

        for (String t : tests) {
            System.out.println(t + " -> " + isValid(t));
        }
    }
}
```

**Notes:** `java.util.Stack` works but it's synchronized and boxed (`Character`). For performance use `ArrayDeque` or `char[]`.

---

## 2) Better: `ArrayDeque<Character>` (fast, idiomatic)

```java
import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionDeque {
    public static boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) return false;

        Deque<Character> st = new ArrayDeque<>(n);
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') st.push(')');
            else if (c == '[') st.push(']');
            else if (c == '{') st.push('}');
            else {
                if (st.isEmpty() || st.pop() != c) return false;
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));   // true
        System.out.println(isValid("([{}])"));   // true
        System.out.println(isValid("(]"));       // false
    }
}
```

`ArrayDeque` is usually faster than `Stack` for stack-like operations.

---

## 3) High-performance: manual `char[]` stack (no boxing)

```java
public class SolutionCharStack {
    public static boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) return false;

        char[] stack = new char[n]; // worst-case every char is an opening
        int top = 0; // points to next free position

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') stack[top++] = ')';
            else if (c == '[') stack[top++] = ']';
            else if (c == '{') stack[top++] = '}';
            else {
                if (top == 0 || stack[--top] != c) return false;
            }
        }
        return top == 0;
    }

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));   // true
        System.out.println(isValid("([{}])"));   // true
        System.out.println(isValid("(]"));       // false
    }
}
```

This avoids boxing/unboxing overhead and tends to be the fastest in microbenchmarks.

---

# Step-by-step example (visual)

Consider `s = "{[()]()}"`.

Process characters:

1. `{` → push expected `}` → stack: `}`
2. `[` → push expected `]` → stack (top first): `], }`
3. `(` → push expected `)` → stack: `), ], }`
4. `)` → compare with top `)` → matches → pop → stack: `], }`
5. `]` → compare with top `]` → matches → pop → stack: `}`
6. `(` → push expected `)` → stack: `), }`
7. `)` → compare with top `)` → matches → pop → stack: `}`
8. `}` → compare with top `}` → matches → pop → stack: *empty*

End: stack empty → valid.

---

# Correctness (why it works)

Invariant: At any index `i`, the stack contains the expected closing brackets for the unmatched opening brackets that appeared before `i`, in reverse order (most recent on top). When a closing bracket `c` is encountered, it must equal the expected closing bracket on top of the stack — otherwise either the types don't match or the order is wrong. At the end, all openings must have been matched → stack empty.

Formal idea: The algorithm enforces matching and ordering simultaneously, which exactly captures the validity definition.

---

# Complexity Analysis

* Let `n = |s|`.

**Time complexity**

* Stack/deque/char\[] solution: O(n) — each character is processed once and each push/pop is O(1).
* Replacement approach: worst-case O(n²) due to repeated string operations.

**Space complexity**

* Stack solution: O(n) in worst case (string of all openings).
* Replacement approach: O(n) for intermediate strings (and extra copies).

---

# Edge cases & gotchas

* Empty string `""` → valid (`true`).
* Odd length string → immediately `false`.
* Input begins with a closing bracket `")"` → `false` (stack empty when encountering closing).
* Mixed types but wrong order `"([)]"` → `false`.
* Using `java.util.Stack` is fine for correctness but slightly slower. Prefer `ArrayDeque` or `char[]` for performance.
* If input may contain non-bracket characters, decide policy: either ignore them or treat them as invalid. (Problem definition usually guarantees only brackets.)

---

# Why some naive approaches fail

* **Counting each type separately** (e.g., count '(' and ')'): fails because counts don't enforce ordering. Example `"([)]"` has matching counts but wrong order.
* **Using regex / global replacement**: works for many strings but can be slow and has worst-case O(n²) time.
* **Using `StringBuilder` replace repeatedly**: same caveat as replacement approach.

---

# Tests & Sample runs

Using the simple `Solution` class above:

```
()[]{} -> true
([{}]) -> true
(] -> false
((())) -> true
{[()]()} -> true
({[}) -> false
 -> true
```

You can compile & run:

```bash
javac Solution.java
java Solution
```

---
