import java.util.Scanner;

public abstract class Employee implements ITaxable {
    private String name;
    private String department;

    // Abstract method to get salary, must be implemented by subclasses
    public abstract double getSalary();

    public Employee() {
        // Default constructor
        this.name = "N/A";
        this.department = "N/A";
    }

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        if (department != null && !department.isEmpty()) {
            this.department = department;
        } else {
            throw new IllegalArgumentException("Invalid Department. Please provide a non-empty string.");
        }
    }

    public void displayDetails() {
        System.out.println("Employee Name: " + getName());
        System.out.println("Employee Department: " + getDepartment());
    }

    public void editDetails() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the New Employee Name: ");
        String newName = scanner.nextLine();
        this.setName(newName);

        System.out.print("Enter the new Employee Department: ");
        // scanner.nextLine();
        String newDepartment = scanner.nextLine();
        this.setDepartment(newDepartment);
    }
}



