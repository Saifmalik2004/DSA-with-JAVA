
# 🚀 Subarray Sum Explorer in Java 🧮

This program is designed to **explore all possible subarrays** in an array, calculate the **sum of each subarray**, and find the **smallest** and **largest** sums! 💡

Whether you're new to subarrays or just curious about how to find the maximum and minimum sums, this program makes it simple and fun!

---

## 💻 How Does It Work?

Imagine you have an array like this:

```java
int num[] = {1, 2, 3, 4, 5, 8};
```

### What’s a Subarray? 🤔

A subarray is just a **continuous slice** of an array. For example, with the array above:

- One subarray could be `[1, 2]`
- Another subarray could be `[3, 4, 5]`
- Even a single element like `[8]` counts as a subarray!

### Objective of the Program 🎯

For every subarray, the program will:
1. **Print the elements** of the subarray.
2. **Calculate the sum** of the subarray.
3. **Track** the smallest and largest subarray sums found so far.
4. **Print the total number** of subarrays along with the **minimum** and **maximum** subarray sums!

---

## ⚙️ Example Run

Let's say we use the array:

```java
int num[] = {1, 2, 3};
```

### Output:
```bash
1  Sum: 1
1 2  Sum: 3
1 2 3  Sum: 6

2  Sum: 2
2 3  Sum: 5

3  Sum: 3

Total number of subarrays: 6
Minimum sum of subarrays: 1
Maximum sum of subarrays: 6
```

### Explanation:
- The subarray `[1]` has a sum of `1`.
- The subarray `[1, 2]` has a sum of `3`.
- The subarray `[1, 2, 3]` has a sum of `6`.
- The smallest sum is `1`, and the largest sum is `6`.

Pretty cool, right? 😎

---

## 🧐 Dry Run of the Code with an Array of 4 Elements

Let's go deeper and break down how the program works with a **4-element array**:

```java
int num[] = {2, 4, 6, 8};
```

### Subarray Breakdown & Dry Run:

1. Start at index 0:
   - Subarray: `[2]`, Sum: `2`
   - Subarray: `[2, 4]`, Sum: `6`
   - Subarray: `[2, 4, 6]`, Sum: `12`
   - Subarray: `[2, 4, 6, 8]`, Sum: `20`

2. Start at index 1:
   - Subarray: `[4]`, Sum: `4`
   - Subarray: `[4, 6]`, Sum: `10`
   - Subarray: `[4, 6, 8]`, Sum: `18`

3. Start at index 2:
   - Subarray: `[6]`, Sum: `6`
   - Subarray: `[6, 8]`, Sum: `14`

4. Start at index 3:
   - Subarray: `[8]`, Sum: `8`

### Results:
- **Total subarrays**: 10
- **Minimum sum**: 2
- **Maximum sum**: 20

So, the smallest subarray sum is `2`, and the largest subarray sum is `20`. This means the program efficiently explores every possible subarray, calculates the sum, and finds the minimum and maximum values!

---

## 📜 Code Walkthrough

```java
public class printSubArray {

    public static void printSubArray(int num[]) {
        int total = 0; // Counter for total subarrays
        int minSum = Integer.MAX_VALUE; // Initially set to a very high value
        int maxSum = Integer.MIN_VALUE; // Initially set to a very low value

        // Outer loop to define the starting point of each subarray
        for (int i = 0; i < num.length; i++) {

            // Inner loop to define the end of each subarray
            for (int j = i; j < num.length; j++) {
                int sum = 0; // Sum of the current subarray

                // Loop to calculate the sum of the subarray
                for (int k = i; k <= j; k++) {
                    System.out.print(num[k] + " ");
                    sum += num[k]; // Adding the element to sum
                }

                // Check if the current sum is smaller than minSum
                if (sum < minSum) {
                    minSum = sum; // Update minSum
                }

                // Check if the current sum is larger than maxSum
                if (sum > maxSum) {
                    maxSum = sum; // Update maxSum
                }

                total++; // Increment the total subarray counter
                System.out.print(" Sum: " + sum); // Print the sum of the current subarray
                System.out.println(); // Move to the next line
            }

            System.out.println(); // Blank line to separate subarrays
        }

        // After all subarrays are processed, print the total count and min/max sums
        System.out.println("Total number of subarrays: " + total);
        System.out.println("Minimum sum of subarrays: " + minSum);
        System.out.println("Maximum sum of subarrays: " + maxSum);
    }

    public static void main(String[] args) {
        int num[] = {2, 4, 6, 8}; // Example array for dry run
        printSubArray(num); // Calling the method
    }
}
```

---

## 💡 Key Points:
- **Subarrays** are continuous segments of the array.
- We **print** and **sum** each subarray, tracking the smallest and largest sums.
- At the end, we display the **total number of subarrays**, along with the **minimum** and **maximum** sums.

Feel free to experiment with different arrays and see how the subarrays and sums change!

Happy Coding! 😊

