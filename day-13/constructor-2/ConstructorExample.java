

// ConstructorExample.java

class Person {
    String name;
    int age;

    // Default Constructor
    public Person() {
        this.name = "Unknown";
        this.age = 0;
        System.out.println("Default constructor called.");
    }

    // Parameterized Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Parameterized constructor called.");
    }

    // Copy Constructor (Shallow Copy)
    public Person(Person original) {
        this.name = original.name;
        this.age = original.age;
        System.out.println("Copy constructor called (Shallow Copy).");
    }

    // Method to display person details
    public void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

// Deep Copy Example using a separate class
class Address {
    String street;
    String city;

    // Constructor to initialize Address
    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }

    // Copy Constructor for Deep Copy
    public Address(Address original) {
        this.street = new String(original.street);
        this.city = new String(original.city);
    }
}

class Employee {
    String name;
    Address address; // Composition with Address class

    // Parameterized Constructor
    public Employee(String name, Address address) {
        this.name = name;
        this.address = new Address(address); // Deep copy of address
        System.out.println("Employee parameterized constructor called (Deep Copy).");
    }

    // Method to display employee details
    public void display() {
        System.out.println("Name: " + name + ", Address: " + address.street + ", " + address.city);
    }
}

// Main class to test different constructor types
public class ConstructorExample {
    public static void main(String[] args) {
        // Default Constructor
        System.out.println("\n-- Default Constructor --");
        Person person1 = new Person();
        person1.display();

        // Parameterized Constructor
        System.out.println("\n-- Parameterized Constructor --");
        Person person2 = new Person("Alice", 25);
        person2.display();

        // Copy Constructor (Shallow Copy)
        System.out.println("\n-- Copy Constructor (Shallow Copy) --");
        Person person3 = new Person(person2);
        person3.display();

        // Deep Copy Constructor
        System.out.println("\n-- Deep Copy Constructor --");
        Address address = new Address("123 Main St", "Springfield");
        Employee employee1 = new Employee("John", address);
        employee1.display();

        // Modifying original address to check deep copy behavior
        address.street = "456 Elm St"; 
        System.out.println("Original address modified.");
        employee1.display(); // Should not reflect modified address due to deep copy
    }
}

