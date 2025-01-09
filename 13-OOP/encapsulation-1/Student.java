// StudentExample.java

public class Student {
    // Private variables to restrict direct access
    private String name;
    private int age;
    private double gpa;

    // Constructor to initialize the student's data with validation
    public Student(String name, int age, double gpa) {
        this.name = name;

        if (age > 0) {
            this.age = age;
        } else {
            System.out.println("Age must be a positive integer.");
            this.age = 0; // default if invalid age is provided
        }

        if (gpa >= 0.0 && gpa <= 4.0) {
            this.gpa = gpa;
        } else {
            System.out.println("GPA must be between 0.0 and 4.0.");
            this.gpa = 0.0; // default if invalid GPA is provided
        }
    }

    // Getter method for name
    public String getName() {
        return name;
    }

    // Setter method for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter method for age
    public int getAge() {
        return age;
    }

    // Setter method for age with validation
    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            System.out.println("Age must be a positive integer.");
        }
    }

    // Getter method for GPA
    public double getGpa() {
        return gpa;
    }

    // Setter method for GPA with validation
    public void setGpa(double gpa) {
        if (gpa >= 0.0 && gpa <= 4.0) {
            this.gpa = gpa;
        } else {
            System.out.println("GPA must be between 0.0 and 4.0.");
        }
    }

    // Method to display student details
    public void displayInfo() {
        System.out.println("Student Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("GPA: " + gpa);
    }
}

// Main class to test the Student class
class Main {
    public static void main(String[] args) {
        // Creating a new Student instance
        Student student = new Student("Alice", 20, 3.8);

        // Displaying initial details
        System.out.println("Initial Student Details:");
        student.displayInfo();

        // Trying to set an invalid age
        student.setAge(-5); // Should display an error message

        // Trying to set a valid GPA
        student.setGpa(3.9);
        System.out.println("\nUpdated Student Details after valid GPA change:");
        student.displayInfo();

        // Trying to set an invalid GPA
        student.setGpa(4.5); // Should display an error message

        // Displaying final details
        System.out.println("\nFinal Student Details:");
        student.displayInfo();
    }
}
