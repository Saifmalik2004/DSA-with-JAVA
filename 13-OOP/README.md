

# Lecture 13: Introduction to Object-Oriented Programming (OOP) in Java

Welcome to Lecture 13! Today, we dive into the world of **Object-Oriented Programming (OOP)**, an essential concept for structuring code in a modular, efficient, and scalable way. We’ll introduce you to the foundational ideas behind OOP, starting with **classes** and **objects**. Let's get started!

---

## 🚀 What is Object-Oriented Programming (OOP)?

Object-Oriented Programming, or **OOP**, is a paradigm that structures code using **objects**. An object is simply a collection of properties (data) and methods (behavior) that represent real-world entities. With OOP, you can build applications that are easier to understand, manage, and expand.

---

## 🌟 Understanding Classes and Objects

In Java, everything revolves around **classes** and **objects**. A **class** is like a blueprint that defines the attributes and behaviors of an entity, while an **object** is an instance of that class.

### 📘 Real-Life Example

Think of a class as a blueprint for a car. Every car shares common features, like wheels, an engine, and doors, but each car can be unique in terms of color, brand, or engine type. 

For instance:

```java
public class Car {
    String color;
    String brand;

    public void drive() {
        System.out.println("The car is driving.");
    }
}
```

Here, `Car` is the **class**, and we can create different **objects** (like `myCar` and `yourCar`) with distinct properties.

---

## 🔐 Access Modifiers: Controlling Access

Access modifiers in Java help control the visibility of classes, methods, and variables. They’re essential in encapsulating data and ensuring that only the right parts of the code can access specific properties or methods.

### Access Modifier Types:

1. **Public**: Accessible from anywhere.
2. **Private**: Only accessible within the class.
3. **Protected**: Accessible within the package and by subclasses.
4. **Default** (no modifier): Accessible within the package.

**Example**:
```java
public class Car {
    private String color; // Only accessible within Car class
    public String brand;  // Accessible from anywhere

    // Getter and Setter for color
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
```

---

## 📥 Getters and Setters: Accessing Private Data

**Getters** and **setters** provide controlled access to private data. They are methods used to retrieve (get) and modify (set) private fields.

### Why Use Getters and Setters?
1. **Control**: You can add validation in the setter to control the data assigned.
2. **Security**: Encapsulation of data improves security.

**Example**:
```java
public class Car {
    private int speed;

    // Getter method
    public int getSpeed() {
        return speed;
    }

    // Setter method with validation
    public void setSpeed(int speed) {
        if (speed > 0) {
            this.speed = speed;
        }
    }
}
```

---

## 🏛️ The Four Pillars of OOP

Java’s OOP principles are built around **four main pillars**. Here’s a quick overview of each:

1. **Encapsulation**: Wrapping up data and methods in a single unit (class) and controlling access to it.
2. **Abstraction**: Hiding complex details and showing only the essential parts.
3. **Inheritance**: Creating new classes based on existing ones to promote code reuse.
4. **Polymorphism**: Allowing methods to take on multiple forms, often by method overriding or overloading.

> In the upcoming sections of this project, we’ll explore each of these pillars in detail, diving deeper into their principles and applications.

---

## 🌐 Summary

Today, we’ve taken the first steps in understanding **Object-Oriented Programming** with Java. We covered:

- The basics of **Classes** and **Objects**.
- How **Access Modifiers** control visibility.
- The role of **Getters and Setters** in managing private data.
- A quick overview of **Encapsulation**, **Abstraction**, **Inheritance**, and **Polymorphism**—the four pillars of OOP.

Stay tuned as we explore each of these concepts in detail in the coming days. With OOP, you’ll be able to create more organized and reusable code, making complex applications easier to develop and maintain. 

---

Happy Coding! 😊