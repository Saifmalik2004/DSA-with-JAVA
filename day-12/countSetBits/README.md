

# Count Set Bits

Welcome! This little program helps you count how many **1's** are in the binary version of a number. Think of binary as a special way computers talk using only 1's and 0's.

Imagine we have a number, and we want to know how many times the number says "1" when we look at it in binary. Let’s learn how this code does that in a fun way!

## How It Works

1. **Counting the 1's**: The program goes through each bit (each 1 or 0 in binary) of the number you give it. If it finds a **1**, it counts it.
  
2. **Moving to the Next Bit**: After checking each bit, the program shifts the number one step to the right. This lets it keep checking until it has counted every single bit.

3. **Returning the Total Count**: Finally, it tells us how many 1's it found!

### Example

If we give it **15**, the binary of 15 is **1111** (which has four **1's**). So, the program will count four 1's and tell us the answer is **4**.

## Code Explanation

- `public class CountSetBits`: This line gives a name to our program. We call it `CountSetBits`.
- `public static int Count(int n)`: This is a **method** (think of it like a special helper) called `Count`. It takes a number and counts its 1's.
- `int count = 0;`: We start with zero 1's counted.
- `while (n > 0)`: As long as our number isn’t zero, we keep counting!
- `(n & 1) != 0`: This checks if the last bit (1 or 0) is a **1**.
- `count++;`: If it’s a **1**, we add 1 to our count.
- `n = n >> 1;`: This shifts the number to the right so we can check the next bit.
- `return count;`: After counting all bits, it gives us the total number of 1's.
- `System.out.println(Count(15));`: This line prints out how many 1's we counted when we checked **15**!

## Try It Out

You can try other numbers, too!