# Array Pair Generator 🔢✨

Welcome to the **Array Pair Generator**! This program takes an array of numbers and generates **all possible pairs** from that array. 

In this file, we will walk you through:
1. **How the code works** 🤔
2. A **fun dry run** with an example array of 4 elements 🌟

---

## How It Works 💻

The `pairArray` method does the magic:
1. It **loops** through every element of the array.
2. It **pairs** each element with every other element that comes after it.
3. It prints each pair and **counts** the total number of pairs generated.

Simple, right? Let's take it for a spin with an example!

---

## Example: Dry Run with Array [1, 2, 3, 4] 🔍

Imagine we have an array `num[] = {1, 2, 3, 4}`. Here's how the magic happens step by step:

### Step 1: First Loop (`i = 0`, `num[0] = 1`)
We start with the number **1**.

- **Pair** 1 with **2**: `(1, 2)`
- **Pair** 1 with **3**: `(1, 3)`
- **Pair** 1 with **4**: `(1, 4)`

At the end of this step, we have the pairs:
`(1, 2)`, `(1, 3)`, `(1, 4)`

---

### Step 2: Second Loop (`i = 1`, `num[1] = 2`)
Now, we move to the number **2**.

- **Pair** 2 with **3**: `(2, 3)`
- **Pair** 2 with **4**: `(2, 4)`

At the end of this step, we have new pairs:
`(2, 3)`, `(2, 4)`

---

### Step 3: Third Loop (`i = 2`, `num[2] = 3`)
Next, we move to the number **3**.

- **Pair** 3 with **4**: `(3, 4)`

Now, we only have one pair:
`(3, 4)`

---

### Step 4: Fourth Loop (`i = 3`, `num[3] = 4`)
Finally, we move to the last number **4**. But wait! There's no number left after **4** to pair it with! So, we skip this loop.

---

## Total Pairs 🤝
We generated all the possible pairs:
- `(1, 2)`
- `(1, 3)`
- `(1, 4)`
- `(2, 3)`
- `(2, 4)`
- `(3, 4)`

In total, we made **6 pairs**. 🎉

---

## What's Happening Behind the Scenes? 🛠️
- The **outer loop** picks the first number (`i`).
- The **inner loop** picks every number after the first number (`j`) and creates a pair.
- The program keeps **counting** each pair until all possible combinations are made.

---

## Try it Yourself! 🧑‍💻

Feel free to modify the array and see how the number of pairs changes! Happy coding, and keep experimenting! 🚀
