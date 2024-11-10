// Abstract Class Example
abstract class Vehicle {
    String brand;

    // Constructor to initialize the brand of vehicle
    public Vehicle(String brand) {
        this.brand = brand;
    }

    // Concrete method
    public void start() {
        System.out.println(brand + " is starting 🚗");
    }

    // Abstract method
    public abstract void fuelType(); // This method must be implemented by subclasses
}

class Car extends Vehicle {
    // Constructor for Car class
    public Car(String brand) {
        super(brand);
    }

    // Implementing abstract method from Vehicle class
    @Override
    public void fuelType() {
        System.out.println(brand + " runs on Petrol ⛽");
    }
}

class ElectricCar extends Vehicle {
    // Constructor for ElectricCar class
    public ElectricCar(String brand) {
        super(brand);
    }

    // Implementing abstract method from Vehicle class
    @Override
    public void fuelType() {
        System.out.println(brand + " runs on Electricity ⚡");
    }
}

public class AbstractExample {
    public static void main(String[] args) {
        // Abstract Class Demonstration
        System.out.println("Abstract Class Example:");
        Vehicle car = new Car("Toyota");
        Vehicle electricCar = new ElectricCar("Tesla");

        car.start();       // Output: Toyota is starting
        car.fuelType();    // Output: Toyota runs on Petrol

        electricCar.start();   // Output: Tesla is starting
        electricCar.fuelType();  // Output: Tesla runs on Electricity
    }
}
