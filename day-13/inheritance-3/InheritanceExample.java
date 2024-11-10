// Base class
class Vehicle {
    String licensePlate;
    int speed;

    // Constructor
    public Vehicle(String licensePlate, int speed) {
        this.licensePlate = licensePlate;
        this.speed = speed;
    }

    // Method to display basic vehicle info
    public void displayInfo() {
        System.out.println("License Plate: " + licensePlate);
        System.out.println("Speed: " + speed + " km/h");
    }

    // Method to simulate starting the vehicle
    public void start() {
        System.out.println("Vehicle with license plate " + licensePlate + " is starting.");
    }
}

// Subclass for Car
class Car extends Vehicle {
    String fuelType;

    // Constructor for Car
    public Car(String licensePlate, int speed, String fuelType) {
        super(licensePlate, speed);
        this.fuelType = fuelType;
    }

    // Method to display Car-specific information
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Fuel Type: " + fuelType);
    }

    // Car-specific method
    public void honk() {
        System.out.println("Car with license plate " + licensePlate + " is honking!");
    }
}

// Subclass for Truck
class Truck extends Vehicle {
    int cargoCapacity;

    // Constructor for Truck
    public Truck(String licensePlate, int speed, int cargoCapacity) {
        super(licensePlate, speed);
        this.cargoCapacity = cargoCapacity;
    }

    // Method to display Truck-specific information
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Cargo Capacity: " + cargoCapacity + " tons");
    }

    // Truck-specific method
    public void loadCargo() {
        System.out.println("Truck with license plate " + licensePlate + " is loading cargo.");
    }
}

// Subclass for Bike
class Bike extends Vehicle {
    boolean hasPedals;

    // Constructor for Bike
    public Bike(String licensePlate, int speed, boolean hasPedals) {
        super(licensePlate, speed);
        this.hasPedals = hasPedals;
    }

    // Method to display Bike-specific information
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Has Pedals: " + (hasPedals ? "Yes" : "No"));
    }

    // Bike-specific method
    public void ringBell() {
        System.out.println("Bike with license plate " + licensePlate + " is ringing its bell!");
    }
}

// Main class to test the inheritance example
public class InheritanceExample {
    public static void main(String[] args) {
        // Creating Car object and calling methods
        Car myCar = new Car("ABC123", 120, "Gasoline");
        System.out.println("Car Details:");
        myCar.displayInfo();
        myCar.start();
        myCar.honk();
        System.out.println();

        // Creating Truck object and calling methods
        Truck myTruck = new Truck("TRK456", 80, 15);
        System.out.println("Truck Details:");
        myTruck.displayInfo();
        myTruck.start();
        myTruck.loadCargo();
        System.out.println();

        // Creating Bike object and calling methods
        Bike myBike = new Bike("BIK789", 25, true);
        System.out.println("Bike Details:");
        myBike.displayInfo();
        myBike.start();
        myBike.ringBell();
    }
}
