Here’s the updated `README.md` without the **Usage** section:

---

# AddBinary Program

This Java program, `AddBinary`, adds two binary numbers represented as strings and returns their sum as a binary string. Binary addition operates in base 2, where only `0` and `1` are valid digits.

## Table of Contents
- [How It Works](#how-it-works)
- [Code Explanation](#code-explanation)
- [Examples](#examples)
- [Key Points](#key-points)

## How It Works
The program simulates binary addition by processing the two input strings `a` and `b` from the rightmost digit (least significant bit) to the leftmost digit, similar to manual addition. It uses a `carry` variable to store any overflow when two binary digits add up to `2` (binary `10`). The result is built by appending each calculated bit to a `StringBuilder`, and then reversed to get the correct binary result.

## Code Explanation

### `AddBinary` Class
The `AddBinary` class contains:
- A static method, `addBinary`, that takes two binary strings `a` and `b` and returns their sum as a binary string.
- A `main` method that demonstrates adding two sample binary strings.

### `addBinary` Method
1. **Initialization**: 
   - `carry` is initialized to `0` for tracking any overflow in binary addition.
   - `aLen` and `bLen` are initialized to the last indices of strings `a` and `b`, respectively, to start processing from the least significant bit.
   - `StringBuilder ans` is used to build the resulting binary sum.
   
2. **Looping Through Digits**:
   - The loop continues as long as there are bits to process in either `a` or `b`, or there's a `carry`.
   
3. **Adding Bits**:
   - **Bit Extraction**: If `aLen` is valid (not `-1`), the character at `a[aLen]` is added to `carry`, and `aLen` is decremented to move left. The same is done for `bLen`.
   - **Calculating Result Bit**: The result for the current bit is `carry % 2`, which is appended to `ans`. 
   - **Updating Carry**: Carry is updated by dividing `carry` by 2.

4. **Reversing Result**:
   - After completing the addition, the result is reversed using `ans.reverse()` to correct the order since the calculation started from the least significant bit.

### Example Code
```java
public class AddBinary {
    public static String addBinary(String a, String b) {
        int carry = 0;
        int aLen = a.length() - 1;  // Starting from the last character of string a
        int bLen = b.length() - 1;  // Starting from the last character of string b
       
        StringBuilder ans = new StringBuilder();
        
        // Process each bit starting from the least significant bit
        while (aLen >= 0 || bLen >= 0 || carry == 1) {
            if (aLen >= 0) {
                carry += a.charAt(aLen--) - '0'; // Convert char to int by subtracting '0'
            }
            if (bLen >= 0) {
                carry += b.charAt(bLen--) - '0'; // Convert char to int by subtracting '0'
            }
            
            ans.append(carry % 2); // Append the result of current bit
            carry = carry / 2;     // Update carry for the next iteration
        }
        
        // Reverse the result to get the correct binary representation
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("11", "1")); // Expected output: "100"
    }
}
```

## Examples
| Input     | Output |
|-----------|--------|
| `"11", "1"`   | `"100"` |
| `"1010", "1011"` | `"10101"` |
| `"0", "0"` | `"0"` |
| `"111", "111"` | `"1110"` |

## Key Points
- This approach allows binary addition without using built-in libraries for handling binary operations.
- The `carry` mechanism handles overflow in each bit position, simulating manual binary addition.
- Using `StringBuilder` and reversing it at the end ensures that our binary sum is correctly oriented.
- This method works for arbitrarily large binary strings.