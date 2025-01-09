

# Encapsulation in Java

Encapsulation is a core principle of Object-Oriented Programming (OOP) that helps us keep data secure and organized by bundling related data and methods within a single unit called a **class**. It also restricts direct access to data, only allowing it to be modified through controlled methods. This ensures data integrity and security in your applications.

---

## 🧐 Why Use Encapsulation?

Encapsulation allows us to:
- **Control** who can access or modify the data.
- **Protect** the integrity of the data by using methods to validate changes.
- **Simplify** code management by grouping related data and behavior in one class.

Think of encapsulation like a **capsule**: everything inside is protected and only accessible in specific ways.

---

## 🔒 How Encapsulation Works in Java

In Java, we achieve encapsulation by:
1. Declaring variables as **private** to restrict direct access.
2. Providing **public getter and setter methods** to access and modify the private data securely.

---

## 📘 Example of Encapsulation in Java

Let’s create a simple example to see encapsulation in action. We’ll build a `BankAccount` class where the account balance is private, and we’ll use methods to access and modify it in a controlled way.

```java
public class BankAccount {
    // Private variable to restrict direct access
    private double balance;

    // Constructor to initialize the account balance
    public BankAccount(double initialBalance) {
        if (initialBalance > 0) {
            this.balance = initialBalance;
        } else {
            System.out.println("Initial balance must be positive.");
        }
    }

    // Getter method to access the balance
    public double getBalance() {
        return balance;
    }

    // Setter method to deposit money with validation
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Method to withdraw money with validation
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount);
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }
}
```

### Explanation of Code

- **Private Variable (`balance`)**: Declared as `private` to prevent unauthorized access.
- **Constructor**: Sets an initial balance with validation.
- **Getter Method (`getBalance`)**: Allows controlled access to check the balance.
- **Setter Methods (`deposit` and `withdraw`)**: Allows adding or removing money with validation to ensure correct usage.

---

## 🛠️ Using the `BankAccount` Class

Let’s see how encapsulation keeps our `balance` safe and ensures only valid transactions.

```java
public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(500.0);

        // Accessing the balance through the getter method
        System.out.println("Initial Balance: " + account.getBalance());

        // Valid deposit
        account.deposit(150.0);
        System.out.println("New Balance after deposit: " + account.getBalance());

        // Invalid deposit
        account.deposit(-50.0); // Will display an error message

        // Valid withdrawal
        account.withdraw(100.0);
        System.out.println("Balance after withdrawal: " + account.getBalance());

        // Invalid withdrawal
        account.withdraw(600.0); // Will display an error message
    }
}
```

### Expected Output:

```
Initial Balance: 500.0
Deposited: 150.0
New Balance after deposit: 650.0
Deposit amount must be positive.
Withdrew: 100.0
Balance after withdrawal: 550.0
Invalid withdrawal amount.
```

---

## 📝 Key Takeaways

- **Encapsulation** ensures that data (like `balance`) is protected and only accessible through controlled methods.
- By restricting direct access, we can add **validation** to maintain data integrity.
- This helps prevent misuse, errors, and inconsistencies in our data.

Encapsulation not only protects your data but also makes your code **more modular, easier to understand, and maintain**!

--- 

Encapsulation helps you build robust applications by promoting secure and controlled interactions with data. With this foundation, you’re one step closer to mastering Object-Oriented Programming!