package Day2;
// Base class Employee
class Employee {
    protected String name;
    protected String id;
    protected String designation;
    protected double basicSalary;

    // Constructor
    public Employee(String name, String id, String designation, double basicSalary) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        this.basicSalary = basicSalary;
    }

    // Method to calculate salary (to be overridden in subclasses)
    public double calculateSalary() {
        return basicSalary;
    }

    // Getter methods for employee details
    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getDesignation() {
        return designation;
    }

    public double getBasicSalary() {
        return basicSalary;
    }
}

// Subclass FullTimeEmployee
class FullTimeEmployee extends Employee {
    private double hra; // House Rent Allowance
    private double da;  // Dearness Allowance

    // Constructor
    public FullTimeEmployee(String name, String id, String designation, double basicSalary, double hra, double da) {
        super(name, id, designation, basicSalary);
        this.hra = hra;
        this.da = da;
    }

    // Method to calculate salary for FullTimeEmployee
    @Override
    public double calculateSalary() {
        // Full-time employee salary includes basic salary + HRA + DA
        return basicSalary + hra + da;
    }

    // Getter methods for HRA and DA
    public double getHra() {
        return hra;
    }

    public double getDa() {
        return da;
    }
}

// Subclass PartTimeEmployee
class PartTimeEmployee extends Employee {
    private double hourlyWage;
    private int hoursWorked;

    // Constructor
    public PartTimeEmployee(String name, String id, String designation, double hourlyWage, int hoursWorked) {
        super(name, id, designation, 0); // No basic salary for part-time employees
        this.hourlyWage = hourlyWage;
        this.hoursWorked = hoursWorked;
    }

    // Method to calculate salary for PartTimeEmployee
    @Override
    public double calculateSalary() {
        // Part-time employee salary is calculated by hourly wage * hours worked
        return hourlyWage * hoursWorked;
    }

    // Getter methods for hourly wage and hours worked
    public double getHourlyWage() {
        return hourlyWage;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }
}

// Main class to test the Payroll System
public class EmployeePayrollSystem {
    public static void main(String[] args) {
        // Create objects for FullTimeEmployee and PartTimeEmployee
        FullTimeEmployee fullTimeEmployee = new FullTimeEmployee("John Doe", "FT123", "Software Engineer", 50000, 10000, 5000);
        PartTimeEmployee partTimeEmployee = new PartTimeEmployee("Jane Smith", "PT456", "Intern", 20, 120);

        // Calculate and display salaries
        double fullTimeSalary = fullTimeEmployee.calculateSalary();
        double partTimeSalary = partTimeEmployee.calculateSalary();

        // Display details of FullTimeEmployee
        System.out.println("Full-Time Employee: " + fullTimeEmployee.getName());
        System.out.println("ID: " + fullTimeEmployee.getId());
        System.out.println("Designation: " + fullTimeEmployee.getDesignation());
        System.out.println("Basic Salary: $" + fullTimeEmployee.getBasicSalary());
        System.out.println("HRA: $" + fullTimeEmployee.getHra());
        System.out.println("DA: $" + fullTimeEmployee.getDa());
        System.out.println("Total Salary: $" + fullTimeSalary);
        System.out.println();

        // Display details of PartTimeEmployee
        System.out.println("Part-Time Employee: " + partTimeEmployee.getName());
        System.out.println("ID: " + partTimeEmployee.getId());
        System.out.println("Designation: " + partTimeEmployee.getDesignation());
        System.out.println("Hourly Wage: $" + partTimeEmployee.getHourlyWage());
        System.out.println("Hours Worked: " + partTimeEmployee.getHoursWorked());
        System.out.println("Total Salary: $" + partTimeSalary);
    }
}
