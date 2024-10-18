
# Day 4: Conditional Statements in Java

## 1. `if-else` Statement

The `if-else` statement is a basic decision-making tool in Java. It helps your code make choices based on conditions. If a condition is `true`, a block of code runs. If it’s `false`, another block can run.

### Syntax:
```java
if (condition) {
    // code to execute if the condition is true
} else {
    // code to execute if the condition is false
}
```

### Example: Pizza Decision
```java
int pizzaSlices = 5;

if (pizzaSlices > 0) {
    System.out.println("Yay! Let's have some pizza.");
} else {
    System.out.println("Oops! No pizza left.");
}
```

Here, if `pizzaSlices` is more than 0, it prints "Yay! Let's have some pizza." Otherwise, it prints "Oops! No pizza left." 🍕 

---

## 2. `else if` Statement

What if you have more than two possibilities? That’s where `else if` comes in. You can chain multiple conditions, each with its own block of code.

### Syntax:
```java
if (condition1) {
    // code to execute if condition1 is true
} else if (condition2) {
    // code to execute if condition2 is true
} else {
    // code to execute if all conditions are false
}
```

### Example: Weather Plan 🌦️
```java
int temperature = 25;

if (temperature > 30) {
    System.out.println("It's too hot! Let's stay indoors.");
} else if (temperature > 20) {
    System.out.println("Perfect weather! Let's go for a walk.");
} else if (temperature > 10) {
    System.out.println("It's a bit chilly. Better grab a jacket.");
} else {
    System.out.println("Brrr! It's freezing! Stay warm inside.");
}
```

Here, based on the `temperature`, the program gives you different plans. If it's over 30°C, you get to chill indoors, and if it’s freezing, you better bundle up!

---

## 3. Ternary Operator

The ternary operator is a cool one-liner for simple `if-else` conditions. It’s a shorthand, like giving your code an espresso shot for quick decisions.

### Syntax:
```java
variable = (condition) ? expressionIfTrue : expressionIfFalse;
```

### Example: Hunger Check 🍔
```java
int hungerLevel = 8;
String action = (hungerLevel > 5) ? "Order some food!" : "You're not that hungry.";

System.out.println(action);
```

In this example, if `hungerLevel` is greater than 5, the output will be "Order some food!" Otherwise, "You're not that hungry." Simple and fast!

---

## 4. `switch` Statement

The `switch` statement is great for when you have multiple options based on a single value. It's like having a menu to choose from, rather than a bunch of `if-else` statements.

### Syntax:
```java
switch (expression) {
    case value1:
        // code block for value1
        break;
    case value2:
        // code block for value2
        break;
    // more cases...
    default:
        // code block if no cases match
}
```

### Example: Day of the Week 🗓️
```java
int day = 5;

switch (day) {
    case 1 -> System.out.println("Monday - Time to hustle!");
    case 2 -> System.out.println("Tuesday - Keep going!");
    case 3 -> System.out.println("Wednesday - Halfway there!");
    case 4 -> System.out.println("Thursday - Almost Friday!");
    case 5 -> System.out.println("Friday - The weekend is near!");
    case 6 -> System.out.println("Saturday - Time to relax!");
    case 7 -> System.out.println("Sunday - Get ready for the new week.");
    default -> System.out.println("Invalid day.");
}
```

In this example, depending on the value of `day`, it prints a message. If the `day` is 5, it says "Friday - The weekend is near!" If the value doesn’t match any case, it defaults to "Invalid day."

---

### Key Takeaways:

- **Use `if-else`** for basic true/false checks.
- **Use `else if`** when there are more conditions to check.
- **Use the ternary operator** for simple decisions in one line.
- **Use `switch`** when you have multiple possible outcomes based on a single value.

These conditional statements are the decision-makers in your code, helping it adapt and react based on input or conditions. Happy coding!
```

This version includes the enhanced (rule) switch syntax, which makes the code more concise and readable! Let me know if you need any further adjustments!