import java.util.Scanner;

public class FullTimeEmployee extends Employee {
    private double monthlySalary;

    public FullTimeEmployee() {
        // calls the parent constructor
        super();
        this.monthlySalary = 0.0;
    }

        public FullTimeEmployee(String name, String department, double monthlySalary) {
        // calls the parent constructor
        super(name, department);
        this.monthlySalary = monthlySalary;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    // Implement getSalary method to return the monthly salary
    @Override
    public double getSalary() {
        return getMonthlySalary();
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("FullTime Employee Salary: $" + getMonthlySalary());
    }

    @Override
    public void editDetails() {
        super.editDetails();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter The New FullTime Employee Monthly Salary: ");
        double newMonthlySalary= scanner.nextDouble();
        this.setMonthlySalary(newMonthlySalary);

    }

    @Override
    public double calculateSalesTax() {
        return 0;
    }
}
