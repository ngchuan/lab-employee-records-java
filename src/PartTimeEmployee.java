import java.util.Scanner;

public abstract class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private double hoursWorked;

    public PartTimeEmployee() {
        // calls the parent constructor
        super();
        this.hourlyRate = 0.0;
        this.hoursWorked = 0.0;
    }

    public PartTimeEmployee(String name, String department, double hourlyRate, double hoursWorked) {
        // calls the parent constructor
        super(name, department);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    // Calculate the monthly salary for part-time employees
    public double calculateMonthlySalary() {
        return hourlyRate * hoursWorked;
    }

    // Implement getSalary method to return the calculated monthly salary
    @Override
    public double getSalary() {
        return calculateMonthlySalary();
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("PartTime Employee Hourly Rate: " + getHourlyRate());
        System.out.println("PartTime Employee No of Hours Work: " + getHoursWorked());
        System.out.println("PartTime Employee Total Monthly Salary: " + calculateMonthlySalary());
    }

    @Override
    public void editDetails() {
        super.editDetails();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the New PartTime Employee Hourly Rate: ");
        double newHourlyRate = scanner.nextDouble();
        this.setHourlyRate(newHourlyRate);

        System.out.print("Enter the New PartTime Employee No of Hours Work: ");
        double newHoursWorked = scanner.nextDouble();
        this.setHoursWorked(newHoursWorked);
    }

//public double calculateMonthlySalary() {
//    return hourlyRate * hoursWorked;
//}

    @Override
    public double calculateSalesTax() {
        return 0;
    }

}

