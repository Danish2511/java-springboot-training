package Day2;
class Vehicle {
    protected String vehicleType;
    protected String numberPlate;
    protected double rentalPricePerDay;

    // Constructor
    public Vehicle(String vehicleType, String numberPlate, double rentalPricePerDay) {
        this.vehicleType = vehicleType;
        this.numberPlate = numberPlate;
        this.rentalPricePerDay = rentalPricePerDay;
    }

    // Method to calculate rental cost
    public double calculateRentalCost(int daysRented) {
        return rentalPricePerDay * daysRented;
    }

    // Getter method for vehicleType
    public String getVehicleType() {
        return vehicleType;
    }

    // Getter method for numberPlate
    public String getNumberPlate() {
        return numberPlate;
    }

    // Getter method for rentalPricePerDay
    public double getRentalPricePerDay() {
        return rentalPricePerDay;
    }
}

// Subclass Car
class Car extends Vehicle {
    private int numberOfDoors;

    // Constructor
    public Car(String numberPlate, double rentalPricePerDay, int numberOfDoors) {
        super("Car", numberPlate, rentalPricePerDay);
        this.numberOfDoors = numberOfDoors;
    }

    // Getter for numberOfDoors
    public int getNumberOfDoors() {
        return numberOfDoors;
    }
}

// Subclass Bike
class Bike extends Vehicle {
    private boolean isElectric;

    // Constructor
    public Bike(String numberPlate, double rentalPricePerDay, boolean isElectric) {
        super("Bike", numberPlate, rentalPricePerDay);
        this.isElectric = isElectric;
    }

    // Getter for isElectric
    public boolean isElectric() {
        return isElectric;
    }
}

// Subclass Truck
class Truck extends Vehicle {
    private double loadCapacity;

    // Constructor
    public Truck(String numberPlate, double rentalPricePerDay, double loadCapacity) {
        super("Truck", numberPlate, rentalPricePerDay);
        this.loadCapacity = loadCapacity;
    }

    // Getter for loadCapacity
    public double getLoadCapacity() {
        return loadCapacity;
    }
}
public class VehicleRentalSystem {
    public static void main(String[] args) {
        // Create objects for each vehicle type
        Car car = new Car("ABC123", 50.0, 4); // Rental price $50/day, 4 doors
        Bike bike = new Bike("XYZ789", 20.0, true); // Rental price $20/day, Electric bike
        Truck truck = new Truck("LMN456", 100.0, 2000.0); // Rental price $100/day, 2000kg capacity

        // Assume rental days
        int carRentalDays = 5;
        int bikeRentalDays = 3;
        int truckRentalDays = 7;

        // Calculate total rental costs
        double carRentalCost = car.calculateRentalCost(carRentalDays);
        double bikeRentalCost = bike.calculateRentalCost(bikeRentalDays);
        double truckRentalCost = truck.calculateRentalCost(truckRentalDays);

        // Display the rental costs
        System.out.println("Rental Cost for " + car.getVehicleType() + " (Plate: " + car.getNumberPlate() + "): $" + carRentalCost);
        System.out.println("Rental Cost for " + bike.getVehicleType() + " (Plate: " + bike.getNumberPlate() + "): $" + bikeRentalCost);
        System.out.println("Rental Cost for " + truck.getVehicleType() + " (Plate: " + truck.getNumberPlate() + "): $" + truckRentalCost);
    }
}
