
# Day 3: Operators, Type Conversion, and Code Execution Flow

Welcome to Day 3! In this chapter, we will explore various types of operators in Java, understand type conversion and casting, and learn about the execution process of Java code. Let's dive in!

## Operators in Java

Operators are special symbols that perform operations on variables and values. In Java, operators can be categorized into several types:

### 1. Unary Operators
Unary operators operate on a single operand.

| Operator | Description                           | Example      |
|----------|---------------------------------------|--------------|
| `+`      | Unary plus (indicates positive value)| `+x`         |
| `-`      | Unary minus (negates value)         | `-x`         |
| `++`     | Increment operator                   | `x++` or `++x` |
| `--`     | Decrement operator                   | `x--` or `--x` |
| `!`      | Logical NOT                          | `!true`      |

### 2. Binary Operators
Binary operators operate on two operands.

| Operator | Description                           | Example      |
|----------|---------------------------------------|--------------|
| `+`      | Addition                             | `x + y`      |
| `-`      | Subtraction                          | `x - y`      |
| `*`      | Multiplication                       | `x * y`      |
| `/`      | Division                             | `x / y`      |
| `%`      | Modulus (remainder)                 | `x % y`      |

### 3. Relational Operators
Relational operators compare two values.

| Operator | Description                            | Example      |
|----------|----------------------------------------|--------------|
| `==`     | Equal to                               | `x == y`     |
| `!=`     | Not equal to                           | `x != y`     |
| `>`      | Greater than                           | `x > y`      |
| `<`      | Less than                              | `x < y`      |
| `>=`     | Greater than or equal to               | `x >= y`     |
| `<=`     | Less than or equal to                  | `x <= y`     |

### 4. Logical Operators
Logical operators are used to combine multiple boolean expressions.

| Operator | Description                           | Example          |
|----------|---------------------------------------|------------------|
| `&&`     | Logical AND                          | `x > y && x < z` |
| `||`     | Logical OR                           | `x > y || x < z` |
| `!`      | Logical NOT                          | `!x`             |

### 5. Assignment Operators
Assignment operators assign values to variables.

| Operator | Description                           | Example      |
|----------|---------------------------------------|--------------|
| `=`      | Assigns value                        | `x = 10`     |
| `+=`     | Add and assign                      | `x += 5`     |
| `-=`     | Subtract and assign                 | `x -= 5`     |
| `*=`     | Multiply and assign                 | `x *= 5`     |
| `/=`     | Divide and assign                   | `x /= 5`     |
| `%=`     | Modulus and assign                  | `x %= 5`     |

### 6. Bitwise Operators
Bitwise operators operate on bits and perform bit-level operations.

| Operator | Description                           | Example      |
|----------|---------------------------------------|--------------|
| `&`      | Bitwise AND                          | `x & y`      |
| `|`      | Bitwise OR                           | `x | y`      |
| `^`      | Bitwise XOR                          | `x ^ y`      |
| `~`      | Bitwise NOT                          | `~x`         |
| `<<`     | Left shift                           | `x << 2`     |
| `>>`     | Right shift                          | `x >> 2`     |
| `>>>`    | Unsigned right shift                 | `x >>> 2`    |

Bitwise operators perform operations on the individual bits of integer types. We will cover bitwise operators in detail in a later chapter.


# Operator Precedence

Operator precedence determines the order in which the operators in an expression are evaluated. 

For example:
```java
int x = 3 * 4 - 1;
```

In the above example, the value of `x` will be `11`, not `9`. This happens because the precedence of the `*` operator is higher than that of the `-` operator. That is why the expression is evaluated as `(3 * 4) - 1` and not `3 * (4 - 1)`.





## Type Conversion and Type Casting

### Type Conversion
Type conversion is the process of converting one data type to another. Java provides two types of conversion:

1. **Implicit Conversion (Widening)**: Automatically done by the Java compiler when converting a smaller data type to a larger data type. For example, `int` to `double`.
   
   **Example**: 
   ```java
   int num = 10;
   double dNum = num; // Implicit conversion
   ```

2. **Explicit Conversion (Narrowing)**: Manually converting a larger data type to a smaller data type, which may lead to data loss. It requires casting.

   **Example**:
   ```java
   double dNum = 10.5;
   int num = (int) dNum; // Explicit conversion (casting)
   ```

### Type Casting
Type casting is used to convert one data type into another explicitly. It can lead to loss of data if not done carefully.

- **Example of Casting**:
```java
double dNum = 9.78;
int num = (int) dNum; // num will be 9
```

### Type Promotion
Type promotion occurs when operands of different data types are used in an expression. Java promotes smaller types to larger types to perform operations. For instance, if an `int` and a `float` are added together, the `int` will be promoted to a `float`.

**Example**:
```java
int num1 = 10;
float num2 = 5.5f;
float result = num1 + num2; // num1 is promoted to float
```

## How Java Code Works

Java code undergoes several stages before it is executed. Here’s a simplified flow:

1. **Source Code**: You write your Java code in a `.java` file.
2. **Compiler**: The Java compiler (`javac`) compiles the source code into bytecode (`.class` file).
3. **Java Virtual Machine (JVM)**: The JVM executes the bytecode. It translates bytecode into machine code that your operating system can understand.
4. **Execution**: The compiled machine code is executed by the CPU.

### Diagram of Java Code Execution Flow

```
[Java Source Code] 
        |
        V
    [Compiler]
        |
        V
 [Bytecode (.class)]
        |
        V
  [Java Virtual Machine]
        |
        V
  [Machine Code Execution]
```

---

This concludes Day 3! We covered operators, type conversion, type casting, type promotion, and the execution flow of Java code. Understanding these concepts is crucial for effective Java programming. Keep practicing these concepts to reinforce your learning!