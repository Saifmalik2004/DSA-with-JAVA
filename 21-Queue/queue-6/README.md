

# 🚀 Non-Repeating Character Finder

This program finds and prints the **first non-repeating character** at each position in a string as you iterate through it. If no non-repeating character exists, it prints `-1`.  

---

## 🌟 Features

- 🏗️ **Uses a queue** to maintain the order of characters.  
- 📊 Tracks character frequencies efficiently with an array.  
- 💡 Provides results in **real-time** for each character in the input string.  

---

## 🛠️ How It Works  

The program:
1. Iterates through the string.
2. Adds each character to a queue and updates its frequency.
3. Continuously removes characters from the front of the queue if they are repeated.
4. Outputs the first non-repeating character in the queue or `-1` if the queue is empty.

---

## 📋 Algorithm (Pseudo Code)  

```
INPUT: A string, str
OUTPUT: First non-repeating character at each position

1. Initialize:
   - freq[26] → An array to store frequency of characters.
   - q → An empty queue to store characters in order of appearance.

2. For each character, ch, in the string:
   a. Add ch to the queue.
   b. Increment freq[ch - 'a'].

   c. While the queue is not empty AND freq[q.peek() - 'a'] > 1:
      - Remove the front character from the queue.

   d. If the queue is empty:
      - Print -1.
      Else:
      - Print q.peek().

3. End.
```

---

## 📘 Example Walkthrough  

**Input**: `"aabcddxdbcc"`  
**Output**: `a -1 b b b b b b c x x`  

### Step-by-Step Execution:  

| Character | Queue (`q`)       | Frequency (`freq`)      | Output |
|-----------|--------------------|-------------------------|--------|
| `a`       | `a`               | `a:1`                  | `a`    |
| `a`       | Empty             | `a:2`                  | `-1`   |
| `b`       | `b`               | `a:2, b:1`             | `b`    |
| `c`       | `b, c`            | `a:2, b:1, c:1`        | `b`    |
| `d`       | `b, c, d`         | `a:2, b:1, c:1, d:1`   | `b`    |
| `d`       | `b, c`            | `a:2, b:1, c:1, d:2`   | `b`    |
| `x`       | `b, c, x`         | `a:2, b:1, c:1, x:1`   | `b`    |
| `d`       | `b, c, x`         | `a:2, b:1, c:1, x:1, d:3` | `b` |
| `b`       | `c, x`            | `a:2, b:2, c:1, x:1`   | `c`    |
| `c`       | `x`               | `a:2, b:2, c:2, x:1`   | `x`    |
| `c`       | Empty             | `a:2, b:2, c:3, x:1`   | `-1`   |

---

## 🕰️ Complexity Analysis  

| Operation                     | Time Complexity | Space Complexity |
|-------------------------------|-----------------|------------------|
| Frequency Update (`freq`)     | O(1)            | O(26)            |
| Queue Operations (`add`, `remove`) | O(1) per op   | O(n)             |
| Total                         | O(n)            | O(n)             |

---

## 📂 Code Explanation  

```java
import java.util.LinkedList;
import java.util.Queue;

public class QueueSol {

    // Function to print the first non-repeating character at each step
    public static void printNonRepeating(String str) {
        int freq[] = new int[26]; // Stores frequency of each character
        Queue<Character> q = new LinkedList<>(); // Queue to maintain the order of characters

        // Loop through each character in the string
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i); // Get the current character

            q.add(ch); // Add the character to the queue
            freq[ch - 'a']++; // Update its frequency

            // Remove characters from the queue if their frequency > 1
            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.remove();
            }

            // If the queue is empty, print -1; otherwise, print the front of the queue
            if (q.isEmpty()) {
                System.out.print(-1 + " ");
            } else {
                System.out.print(q.peek() + " ");
            }
        }
        System.out.println();
    }

    // Main method to test the function
    public static void main(String[] args) {
        String str = "aabcddxdbcc"; // Input string
        printNonRepeating(str); // Function call
    }
}
```

---

## 📈 Output Example  

```
Input: aabcddxdbcc
Output: a -1 b b b b b b c x x 
```

---

## ✍️ Key Points  

- **Queue** ensures FIFO order.  
- **Frequency Array** keeps track of character counts efficiently.  
- Handles edge cases like an empty string or repeated characters gracefully.

Happy coding! 🎉