public class Contribution implements ITaxable {
    private double employeeSalary;
    private String employeeName;// Add this field

    public Contribution(String employeeName, double employeeSalary) {
        this.employeeName = employeeName;
        this.employeeSalary = employeeSalary;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeeName() { // Getter for employeeName
        return employeeName;
    }

    public void setEmployeeName(String employeeName) { // Setter for employeeName
        this.employeeName = employeeName;
    }

    // Calculate 20% of the employee's salary as a deduction
    @Override
    public double calculateSalesTax() {
        double deductionRate = 0.20; // 20% deduction
        return employeeSalary * deductionRate;
    }

    public interface ITaxable {
        double calculateSalesTax();
    }

    // Display the basic contribution details
    public void displayBasicContributionDetails() {
        double deduction = calculateSalesTax();
        System.out.println("Employee: " + employeeName); // Display the employee's name
        System.out.println("Employee Salary: $" + getEmployeeSalary());
        System.out.println("Deduction (20%): $" + deduction);
    }

    // Display the salary after deduction
    public void displaySalaryAfterDeduction() {
        double deduction = calculateSalesTax();
        double salaryAfterDeduction = employeeSalary - deduction;
        System.out.println("Employee: " + employeeName); // Display the employee's name
        System.out.println("Employee Gross Salary Before Deduction: $" + employeeSalary);
        System.out.println("Deduction (20%): $" + deduction);
        System.out.println("Employee Net Salary After Deduction: $" + salaryAfterDeduction);
    }

}
