
# Day 2: Understanding Variables and Data Types

Welcome to Day 2! Today, we’re diving into **variables** and **data types**. These are foundational concepts in Java programming, helping you define and work with different types of data. Java has two main categories of data types: **primitive** and **non-primitive**. In this chapter, we’ll cover **primitive data types** only.

## Types of Data Types
1. **Primitive Data Types**: These are the basic data types provided by Java for handling simple values directly. They include:
   - `byte`
   - `short`
   - `int`
   - `long`
   - `float`
   - `double`
   - `char`
   - `boolean`

2. **Non-Primitive Data Types**: These include more complex types like **arrays**, **classes**, and **interfaces**. Non-primitive data types are created by programmers and will be covered in future chapters.

## Primitive Data Types Explained
Let’s go over each primitive data type and discuss its characteristics:

### 1. `byte`
- **Description**: The smallest integer data type in Java. Used for small numbers, especially when memory efficiency is important.
- **Range**: -128 to 127.
- **Memory**: 1 byte.

### 2. `short`
- **Description**: Larger than `byte` but smaller than `int`. Used for slightly larger whole numbers.
- **Range**: -32,768 to 32,767.
- **Memory**: 2 bytes.

### 3. `int`
- **Description**: The most commonly used integer type for general-purpose whole numbers.
- **Range**: -2,147,483,648 to 2,147,483,647.
- **Memory**: 4 bytes.

### 4. `long`
- **Description**: Used for very large integers beyond the range of `int`. Helpful for large datasets or calculations.
- **Range**: -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807.
- **Memory**: 8 bytes.

### 5. `float`
- **Description**: A single-precision decimal type. Used for numbers with fractional parts but with less precision than `double`.
- **Range**: Approximately ±3.4e38.
- **Memory**: 4 bytes.

### 6. `double`
- **Description**: The default type for decimal numbers in Java. Offers more precision than `float`.
- **Range**: Approximately ±1.7e308.
- **Memory**: 8 bytes.

### 7. `char`
- **Description**: Holds a single character (e.g., a letter or symbol) and uses single quotes.
- **Range**: Any character in Unicode, from `\u0000` to `\uFFFF`.
- **Memory**: 2 bytes.

### 8. `boolean`
- **Description**: Represents true/false values. Commonly used in conditional statements.
- **Values**: `true` or `false`.
- **Memory**: 1 bit.

## Taking User Input for Each Data Type
Java’s `Scanner` class makes it easy to gather input from users. For each data type, there’s a specific method you can use with `Scanner`:
- **byte**: `nextByte()`
- **short**: `nextShort()`
- **int**: `nextInt()`
- **long**: `nextLong()`
- **float**: `nextFloat()`
- **double**: `nextDouble()`
- **char**: Java does not directly support `nextChar()`, so you can use `next().charAt(0)` to get a character.
- **boolean**: `nextBoolean()`

These methods ensure that user input matches the data type you expect.

## Summary: Primitive Data Types
| Data Type | Description                          | Range                                      | Memory |
|-----------|--------------------------------------|--------------------------------------------|--------|
| `byte`    | Small integer                        | -128 to 127                                | 1 byte |
| `short`   | Medium integer                       | -32,768 to 32,767                          | 2 bytes|
| `int`     | Standard integer                     | -2,147,483,648 to 2,147,483,647            | 4 bytes|
| `long`    | Large integer                        | -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807 | 8 bytes|
| `float`   | Single-precision decimal             | ±3.4e38                                    | 4 bytes|
| `double`  | Double-precision decimal             | ±1.7e308                                   | 8 bytes|
| `char`    | Single character                     | Unicode characters                         | 2 bytes|
| `boolean` | True/false value                     | `true` or `false`                          | 1 bit  |

In this chapter, we focused on **primitive data types**, which are the foundation of Java programming. Non-primitive types, such as arrays and objects, build on these basics and will be covered in future chapters.

--- 

Now you have a solid understanding of Java's primitive data types and how to handle user input for each. For code examples, refer to the separate file on using `Scanner` for user input!