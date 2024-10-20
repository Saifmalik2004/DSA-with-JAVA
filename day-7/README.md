
# Day 7 - Advanced Pattern Questions for Logic Building 🧠💡

Welcome to Day 7! Today, we're diving deep into **pattern-based problems**, which are not only fun to solve but are great for improving your **logic-building** skills. These problems help you think critically about loops, conditions, and how to break down problems into smaller parts.

We'll cover advanced patterns, explain how to solve them, and give you tricks to crack even the most complex ones!

---

## 🦋 Butterfly Pattern - Dry Run & Approach

Let's start with an exciting pattern: the **Butterfly Pattern**. Here’s the pattern for a given number `n = 4`:

```
*      *
**    **
***  ***
********
********
***  ***
**    **
*      *
```

### Approach to Solve:

When you look at this pattern, the first thing to notice is the symmetry! The pattern is **mirrored horizontally** and vertically, which gives it a butterfly-like shape. 

### Step-by-Step Breakdown:

1. **Divide the pattern** into two halves:
   - **Upper half**: The first `n` rows.
   - **Lower half**: The next `n` rows.

2. **Upper Half**:
   - The first row has 1 star, the second has 2, and so on until the `n-th` row, which has `n` stars on both sides.
   - Between the two star sections, there are **spaces** that decrease as the stars increase.

3. **Lower Half**:
   - The lower half is just a **mirror image** of the upper half.

### Trick to Solve Patterns Like This:

- **Visualize the pattern** before jumping into coding. Analyze how the number of stars and spaces changes as you move from one row to the next.
- **Break down the pattern**: Start with one half (e.g., the upper half) and see how you can mirror it for the lower half.
- **Use nested loops**: The outer loop controls the rows, and the inner loops control stars and spaces.

### Dry Run of the Butterfly Pattern:

For `n = 4`, let’s dry run the pattern:

#### Upper Half (First 4 Rows):
1. **Row 1**: 
   - Stars: 1 on the left, 1 on the right.
   - Spaces: `2 * (n - 1) = 6` spaces between the stars.
   - Output: `*      *`

2. **Row 2**: 
   - Stars: 2 on the left, 2 on the right.
   - Spaces: `2 * (n - 2) = 4` spaces between the stars.
   - Output: `**    **`

3. **Row 3**:
   - Stars: 3 on the left, 3 on the right.
   - Spaces: `2 * (n - 3) = 2` spaces between the stars.
   - Output: `***  ***`

4. **Row 4**:
   - Stars: 4 on the left, 4 on the right.
   - Spaces: `2 * (n - 4) = 0` spaces between the stars.
   - Output: `********`

#### Lower Half (Next 4 Rows):
- The lower half mirrors the upper half, so just reverse the order:
   - Row 5: `********`
   - Row 6: `***  ***`
   - Row 7: `**    **`
   - Row 8: `*      *`

### Butterfly Pattern Code Explanation (Java):

```java
import java.util.Scanner;

public class ButterflyPattern {
    public static void printButterfly(int n) {
        // Upper half
        for (int i = 1; i <= n; i++) {
            // Print left stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            // Print spaces
            for (int j = 1; j <= 2 * (n - i); j++) {
                System.out.print(" ");
            }
            // Print right stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        
        // Lower half
        for (int i = n; i >= 1; i--) {
            // Print left stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            // Print spaces
            for (int j = 1; j <= 2 * (n - i); j++) {
                System.out.print(" ");
            }
            // Print right stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows for the butterfly pattern:");
        int n = scanner.nextInt();
        printButterfly(n);
    }
}
```

### Key Takeaways:

- We used two nested loops: the outer loop for the number of rows and two inner loops for stars and spaces.
- Spaces are calculated based on the formula `2 * (n - i)` for both upper and lower halves.
- The lower half is simply the reverse of the upper half.

---

## More Advanced Patterns to Practice 🔥

Now that you’ve understood the **butterfly pattern**, try solving these other advanced patterns using a similar approach!

1. **Hollow Rectange **:
   ```
   *   *   *   *   *
   *               *
   *               *
   *   *   *   *   *
   ```

2. **Hourglass Pattern**:
   ```
   *********
    ******* 
     *****  
      ***   
       *    
      ***   
     *****  
    ******* 
   *********
   ```

3. **Pascal's Triangle**:
   ```
       1
      1 1
     1 2 1
    1 3 3 1
   1 4 6 4 1
   ```

4. **Diamond Shape**:
   ```
       *    
      ***   
     *****  
    ******* 
     *****  
      ***   
       *    
   ```

---

### Tricks to Solve Patterns Like a Pro 🌟:

- **Visualize the pattern** first: Try drawing it on paper before jumping into code.
- **Look for symmetry**: Many patterns are symmetric. This can help you avoid redundant code.
- **Find relations** between stars and spaces: Count the stars and spaces for each row and see if you can find a formula.
- **Master loops**: Practice using `for` loops in nested form, as they’re key to solving pattern problems.
- **Try reverse engineering**: Start from the middle or the bottom row and try building the pattern backward.

---

## Conclusion

Patterns are an excellent way to improve your coding and logical thinking skills. The **butterfly pattern** is just the start of your journey into more complex designs! Try to solve the provided patterns, and remember the key steps: visualize, break down, and build!

Keep practicing and exploring new patterns—once you master these, you’ll be ready for anything!

Happy coding! 😊