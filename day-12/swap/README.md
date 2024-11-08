

# 🔄 SwapTwoNum Program

This Java program swaps two numbers without using a temporary variable. It uses the XOR bitwise operator (`^`) to perform the swap in a clever and efficient way.

## 🌟 How It Works
The XOR swap method works by manipulating the bits of the numbers. Using XOR, we can swap two variables without needing an additional variable. This approach is often used for efficient swapping in programming challenges and optimized code.

### 📜 Code Explanation

Here's the code with detailed comments:

```java
public class SwapTwoNum {

    // Method to swap two integers a and b without using a temporary variable
    public static void swap(int a, int b) {
        // Print the initial values of a and b
        System.out.println("Before Swap - a = " + a + ", b = " + b);

        // Step 1: Set a = a XOR b
        a = a ^ b; // a now holds the combined XOR of a and b

        // Step 2: Set b = a XOR b, which effectively sets b to the original value of a
        b = a ^ b; // b now holds the original value of a

        // Step 3: Set a = a XOR b, which effectively sets a to the original value of b
        a = a ^ b; // a now holds the original value of b

        // Print the swapped values of a and b
        System.out.println("After Swap - a = " + a + ", b = " + b);
    }

    public static void main(String[] args) {
        // Call the swap method with initial values of a = 2 and b = 4
        swap(2, 4);
    }
}
```

### 🔍 Dry Run of the XOR Swap

Let's go through the program step-by-step, using `a = 2` and `b = 4`.

**Initial Values**  
- `a = 2` (binary: `10`)
- `b = 4` (binary: `100`)

#### Step-by-Step Execution

1. **Print Initial Values:**  
   ```
   Before Swap - a = 2, b = 4
   ```

2. **First XOR Operation:**  
   `a = a ^ b`  
   - `a = 2 ^ 4`
   - Binary calculation: `010 ^ 100 = 110` (decimal `6`)
   - Now, `a = 6`, `b = 4`

3. **Second XOR Operation:**  
   `b = a ^ b`
   - `b = 6 ^ 4`
   - Binary calculation: `110 ^ 100 = 010` (decimal `2`)
   - Now, `a = 6`, `b = 2` (b now holds the original value of `a`)

4. **Third XOR Operation:**  
   `a = a ^ b`
   - `a = 6 ^ 2`
   - Binary calculation: `110 ^ 010 = 100` (decimal `4`)
   - Now, `a = 4`, `b = 2` (a now holds the original value of `b`)

5. **Print Swapped Values:**  
   ```
   After Swap - a = 4, b = 2
   ```

### 📝 Explanation of XOR Operations

The XOR operation (`^`) works because:
- XORing a number with itself yields `0` (e.g., `x ^ x = 0`).
- XORing any number with `0` gives the number itself (e.g., `x ^ 0 = x`).
- XORing two numbers twice with one of them will "cancel out" the original number, allowing us to swap without extra storage.

### 📈 Output

The program output will look like this:
```
Before Swap - a = 2, b = 4
After Swap - a = 4, b = 2
```

This shows that the values of `a` and `b` have been successfully swapped using the XOR technique.