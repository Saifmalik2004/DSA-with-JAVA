

# Lecture 1: Getting Started with Java

Welcome to your first day of learning Java! In programming, we often start with a simple task: printing "Hello, World!" to the screen. This is a great way to make sure everything is set up and working correctly. If you can successfully run this code, you're on the right path to mastering Java!

## What You'll Learn
- Setting up your Java environment
- Writing your first Java program
- Running Java code in the terminal

## Step 1: Set Up Your Java Environment
To run Java code, you’ll need to have the **Java Development Kit (JDK)** installed on your computer. 

### Installing the JDK
1. Download the JDK from the [Oracle website](https://www.oracle.com/java/technologies/javase-downloads.html) or use a package manager like `brew` for Mac, `choco` for Windows, or `apt` for Linux.
2. Follow the installation instructions, and once installed, open your terminal and type:
   ```bash
   java -version
   ```
   This command will display the version of Java installed on your machine, confirming the setup.

## Step 2: Write Your First Java Program
1. Open a text editor or an IDE (such as IntelliJ IDEA, Eclipse, or VSCode).
2. Create a new file and name it `HelloWorld.java`.
3. Type the following code into the file:
   ```java
   public class HelloWorld {
       public static void main(String[] args) {
           System.out.println("Hello, World!");
       }
   }
   ```

## Step 3: Run the Program
1. Save the file and open your terminal.
2. Navigate to the directory where you saved `HelloWorld.java`.
3. Compile the code by typing:
   ```bash
   javac HelloWorld.java
   ```
   This command compiles your code and generates a file named `HelloWorld.class`.

4. Now, run the compiled code with this command:
   ```bash
   java HelloWorld
   ```
   You should see the output:
   ```
   Hello, World!
   ```

## Why "Hello, World!"?
In programming, starting with "Hello, World!" is a tradition. It’s a simple way to get familiar with the syntax and see results immediately. By successfully printing "Hello, World!" in Java, you’ve taken your first step into the world of programming!

---

Congratulations on completing Day 1! 🎉 Now that you've got Java set up and running, you're ready to dive deeper.