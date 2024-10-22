

# Reverse Array in Java

## Introduction

Reversing an array means switching the order of elements, where the first element becomes the last and the last becomes the first. This README explains **how to reverse an array in Java** using two approaches:
1. **With a temporary variable**.
2. **Without a temporary variable** (using arithmetic operations).

Let’s dive into it and understand how swapping works in an array with a step-by-step explanation!

## Code Overview

### 1. Reversing with a Temporary Variable

We use a **temporary variable** to swap the values of two elements. Here’s the step-by-step breakdown:

```java
public static void reverseArray(int number[]) {
    int first = 0; // Points to the first element
    int end = number.length - 1; // Points to the last element

    // Loop until the 'first' index crosses the 'end' index
    while (first < end) {
        // Step 1: Store the first element in a temporary variable
        int temp = number[first];

        // Step 2: Assign the last element to the first position
        number[first] = number[end];

        // Step 3: Assign the temporary (original first) value to the last position
        number[end] = temp;

        // Move the first pointer to the right and end pointer to the left
        first++;
        end--;
    }
}
```

### 2. Reversing Without a Temporary Variable

In this approach, we swap elements **without using a temporary variable** by using basic arithmetic (addition and subtraction or multiplication and division). This can be tricky, but it's an excellent exercise to understand how variables work at a low level.

#### Swapping Using Addition/Subtraction:

```java
number[first] = number[first] + number[end]; // Add the first and last
number[end] = number[first] - number[end];   // Subtract the new value of 'first' by 'end' to get the original 'first'
number[first] = number[first] - number[end]; // Subtract the new 'end' from 'first' to get the original 'last'
```

#### Swapping Using Multiplication/Division:

```java
number[first] = number[first] * number[end]; // Multiply the two numbers
number[end] = number[first] / number[end];   // Divide to get the original 'first' value
number[first] = number[first] / number[end]; // Divide again to retrieve the original 'last' value
```

**Note:** Multiplication/division should be avoided when numbers may include zero.

## Full Example Code

Here’s the full code that uses both the temporary variable method and shows how swapping works without one.

```java
import java.util.Arrays;

public class ReverseArray {

    public static void reverseArray(int number[]) {
        int first = 0; // Pointer to the first element
        int end = number.length - 1; // Pointer to the last element
        
        // Using a temporary variable to reverse the array
        while (first < end) {
            int temp = number[first];
            number[first] = number[end];
            number[end] = temp;

            // Move pointers
            first++;
            end--;
        }
    }

    // Method to reverse without using a temporary variable (for demonstration)
    public static void reverseWithoutTemp(int number[]) {
        int first = 0;
        int end = number.length - 1;

        while (first < end) {
            // Swap without a temporary variable using addition/subtraction
            number[first] = number[first] + number[end];
            number[end] = number[first] - number[end];
            number[first] = number[first] - number[end];

            first++;
            end--;
        }
    }

    public static void main(String[] args) {
        int number[] = {1, 2, 3, 4, 5, 6};  // Example array

        reverseArray(number);  // Call to reverse using a temporary variable
        System.out.println("Reversed with temp: " + Arrays.toString(number));

        reverseWithoutTemp(number);  // Call to reverse without a temporary variable
        System.out.println("Reversed without temp: " + Arrays.toString(number));
    }
}
```

## Dry Run (Step-by-Step Execution)

Let’s dry-run the program for an array with **4 elements**: `{1, 2, 3, 4}`.

### Initial Array:
```
[1, 2, 3, 4]
```

### Iteration 1:
1. **First = 0**, **End = 3**
2. Swap `number[first]` (1) with `number[end]` (4):
   - Array after swap: `[4, 2, 3, 1]`
3. Move pointers:
   - `First = 1`, `End = 2`

### Iteration 2:
1. **First = 1**, **End = 2**
2. Swap `number[first]` (2) with `number[end]` (3):
   - Array after swap: `[4, 3, 2, 1]`
3. Move pointers:
   - `First = 2`, `End = 1`

Since `first` is no longer less than `end`, the loop stops, and the array is reversed.

### Final Reversed Array:
```
[4, 3, 2, 1]
```

## Summary

- **Reversing with a temporary variable**: We store one element temporarily, swap the two elements, and then place them in their new positions.
- **Reversing without a temporary variable**: We use arithmetic operations to swap elements in-place.

Both methods work efficiently, but the arithmetic method avoids the need for extra memory!

