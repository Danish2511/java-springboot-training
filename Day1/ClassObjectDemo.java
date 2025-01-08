class Car {
    // Fields (properties)
    String brand;
    int year;

    // Method (behavior)
    void displayDetails() {
        System.out.println("Brand: " + brand + ", Year: " + year);
    }
}

public class ClassObjectDemo {
    public static void main(String[] args) {
        Car car1 = new Car();
        car1.brand = "Toyota";
        car1.year = 2022;
        car1.displayDetails();

        // Creating another object of class Car
        Car car2 = new Car();
        car2.brand = "Honda";
        car2.year = 2023;
        car2.displayDetails();
    }
}
