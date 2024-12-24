# Stock Span Problem Explained 🌟

## Problem Statement ❓
The **Stock Span Problem** is a popular coding challenge that involves finding the number of consecutive days (including the current day) the stock price has been less than or equal to the current day’s stock price. 

For example, given a list of stock prices: 
`[100, 80, 60, 70, 60, 85, 100]`, the output span array will be:
`[1, 1, 1, 2, 1, 5, 7]`. 

Here’s how it works:
- On the **1st day**, the span is `1` (no previous higher prices).
- On the **4th day** (price 70), it includes the previous day (price 60), so span = `2`.
- On the **6th day** (price 85), all previous prices (100, 80, 60, 70, 60) are less than or equal to 85, so span = `5`.

This problem is crucial in understanding **stacks**, as it allows efficient computation of spans for stock prices.

---

## Approach 🛠️
We use a **stack** to store indices of stock prices for efficient computation. The key insight is that the **span for a given day can be determined by finding the nearest previous day with a higher price**. 

Steps:
1. Start with an empty stack and initialize the span of the first day as `1`.
2. For each subsequent day, pop elements from the stack until:
   - The stack becomes empty, or
   - The price at the index at the top of the stack is greater than the current day’s price.
3. Use the stack’s top index to calculate the span for the current day.
4. Push the current day’s index onto the stack.

---

## Algorithm (Pseudocode) 📃
```text
Function stockSpan(stock[], span[]):
    Initialize stack = empty
    span[0] = 1
    Push 0 (first index) to stack

    For i = 1 to stock.length - 1:
        While stack is not empty AND stock[i] > stock[stack.top()]:
            Pop from stack

        If stack is empty:
            span[i] = i + 1
        Else:
            span[i] = i - stack.top()

        Push i to stack
```

---

## Java Implementation 💻
```java
import java.util.Stack;

public class StackJFC {

    public static void stockSpan(int stock[], int span[]) {
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);

        for (int i = 1; i < stock.length; i++) {
            int currPrice = stock[i];

            while (!s.isEmpty() && currPrice > stock[s.peek()]) {
                s.pop();
            }

            if (s.isEmpty()) {
                span[i] = i + 1;
            } else {
                int prevHigh = s.peek();
                span[i] = i - prevHigh;
            }

            s.push(i);
        }
    }

    public static void main(String[] args) {
        int stock[] = {100, 80, 60, 70, 60, 85, 100};
        int span[] = new int[stock.length];
        stockSpan(stock, span);

        for (int i = 0; i < span.length; i++) {
            System.out.println(span[i]);
        }
    }
}
```

---

## Dry Run Example 🔍
Let’s take the stock prices `[100, 80, 60, 70, 60, 85, 100]` and compute spans step-by-step:

### Step-by-Step Calculation:
- **Day 1 (100):** Span = `1` (no previous days with higher prices).
- **Day 2 (80):** Span = `1` (80 < 100).
- **Day 3 (60):** Span = `1` (60 < 80).
- **Day 4 (70):** Span = `2` (70 > 60 but < 80).
- **Day 5 (60):** Span = `1` (60 < 70).
- **Day 6 (85):** Span = `5` (85 > all previous prices).
- **Day 7 (100):** Span = `7` (100 > all previous prices).

Final Span Array: `[1, 1, 1, 2, 1, 5, 7]`

---

## Complexity Analysis 📊

### Time Complexity:
- Each element is pushed and popped from the stack at most once.
- Total time complexity = **O(n)**.

### Space Complexity:
- The stack requires **O(n)** space in the worst case.

---

## Key Takeaways 🎉
- The Stock Span Problem demonstrates the power of stacks for solving array-based problems efficiently.
- By leveraging indices instead of actual values, we reduce unnecessary computations.
- The approach is efficient, scalable, and elegant, making it a favorite for coding interviews. 

Happy coding! ✨

