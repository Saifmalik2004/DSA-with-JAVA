

# 🚀 Inheritance in Java 🚀

### What is Inheritance? 🌳
Inheritance is a fundamental concept in **Object-Oriented Programming (OOP)** that allows a class (called a **child** or **subclass**) to inherit fields and methods from another class (called a **parent** or **superclass**). With inheritance, we can build on existing code rather than starting from scratch, promoting **reusability** and **extensibility**.

---

## Types of Inheritance in Java

### 1. Single Inheritance 👩‍🏫 ➡️ 👩‍🎓
In **single inheritance**, a subclass inherits directly from one superclass. 

📝 **Example:** A `Teacher` class inherits from a `Person` class.

#### Code Example
```java
// Superclass
class Person {
    String name;
    int age;

    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

// Subclass (Single Inheritance)
class Teacher extends Person {
    String subject;

    public void teach() {
        System.out.println(name + " is teaching " + subject);
    }
}

public class SingleInheritanceExample {
    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        teacher.name = "Alice";
        teacher.age = 30;
        teacher.subject = "Mathematics";
        teacher.displayInfo();
        teacher.teach();
    }
}
```

### 2. Multilevel Inheritance 🏫 ➡️ 👩‍🏫 ➡️ 👩‍🎓
**Multilevel inheritance** is when a class is derived from a class that is also derived from another class.

📝 **Example:** `Person` ➡️ `Teacher` ➡️ `MathTeacher`

#### Code Example
```java
// Base class
class Person {
    String name;
    int age;
}

// Intermediate subclass
class Teacher extends Person {
    String subject;
}

// Derived subclass (Multilevel Inheritance)
class MathTeacher extends Teacher {
    public void teachMath() {
        System.out.println(name + " is teaching " + subject);
    }
}

public class MultilevelInheritanceExample {
    public static void main(String[] args) {
        MathTeacher mathTeacher = new MathTeacher();
        mathTeacher.name = "Alice";
        mathTeacher.age = 30;
        mathTeacher.subject = "Algebra";
        mathTeacher.teachMath();
    }
}
```

### 3. Hierarchical Inheritance 🏫 ➡️ 👩‍🏫 & 👩‍🎓
**Hierarchical inheritance** is when multiple subclasses inherit from a single superclass.

📝 **Example:** Both `Teacher` and `Student` inherit from `Person`.

#### Code Example
```java
// Superclass
class Person {
    String name;
    int age;
}

// Subclass 1
class Teacher extends Person {
    public void teach() {
        System.out.println(name + " is teaching.");
    }
}

// Subclass 2
class Student extends Person {
    public void study() {
        System.out.println(name + " is studying.");
    }
}

public class HierarchicalInheritanceExample {
    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        teacher.name = "Alice";
        teacher.teach();

        Student student = new Student();
        student.name = "Bob";
        student.study();
    }
}
```

### 4. Hybrid Inheritance 🚀👩‍🏫👩‍🎓 ➕ Interfaces
Java doesn’t support **multiple inheritance** directly to avoid ambiguity, but **Hybrid Inheritance** can be achieved using **interfaces**.

📝 **Example:** `Teacher` and `Student` inherit from `Person`, and both implement an interface called `Responsibilities`.

#### Code Example
```java
// Superclass
class Person {
    String name;
    int age;
}

// Interface
interface Responsibilities {
    void showResponsibilities();
}

// Subclass 1
class Teacher extends Person implements Responsibilities {
    public void teach() {
        System.out.println(name + " is teaching.");
    }

    @Override
    public void showResponsibilities() {
        System.out.println(name + " has responsibilities of grading.");
    }
}

// Subclass 2
class Student extends Person implements Responsibilities {
    public void study() {
        System.out.println(name + " is studying.");
    }

    @Override
    public void showResponsibilities() {
        System.out.println(name + " has responsibilities of completing assignments.");
    }
}

public class HybridInheritanceExample {
    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        teacher.name = "Alice";
        teacher.teach();
        teacher.showResponsibilities();

        Student student = new Student();
        student.name = "Bob";
        student.study();
        student.showResponsibilities();
    }
}
```

---

## 📚 Real-Life Applications of Inheritance: Solving Problems with Code

Inheritance is commonly used in software development to organize code for applications with similar characteristics across entities, enabling **reusability** and **clean code structure**. Here are some real-world scenarios where inheritance helps solve complex problems:

### 1. **Library System** 📖
In a library system, different types of users like `Librarian`, `Member`, and `Guest` inherit common properties like `name` and `ID` from a base `User` class, with unique methods for each type.

### 2. **Banking System** 💳
In a banking app, accounts like `SavingsAccount`, `CheckingAccount`, and `LoanAccount` inherit fields like `accountNumber` and `balance` from a `BankAccount` class but implement specific rules for deposits, withdrawals, and fees.

### 3. **E-commerce Product Management** 🛒
For an e-commerce platform, different product types (`Electronics`, `Clothing`, `Furniture`) share basic fields like `price` and `brand` inherited from a `Product` class, allowing unique attributes like `batteryLife` for electronics or `size` for clothing.

### 4. **Vehicle Management System** 🚗
In a vehicle management system, various vehicles (`Car`, `Bike`, `Truck`) inherit common attributes like `licensePlate` and `speed` from a `Vehicle` class, allowing each subclass to add specific attributes or behaviors, such as `cargoCapacity` for trucks.

---

### 📈 Why Use Inheritance?
Inheritance enhances code by:
- **Reducing Code Duplication**: Shared properties and methods are defined once in the parent class.
- **Improving Organization**: Each subclass inherits core functionality and is specialized as needed.
- **Simplifying Maintenance**: Changes to the parent class automatically apply to all subclasses.

By modeling real-world hierarchies, inheritance provides an elegant solution for structuring software, making code more manageable and scalable.