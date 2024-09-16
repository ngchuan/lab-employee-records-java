import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Employee> employeeList = new ArrayList<>();
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        do {
            int choice = displayMenu();
            if (choice == 1) {
                addNewEmployee();
            } else if (choice == 2) {
                listAllEmployees();
            } else if (choice == 3) {
                deductContributions();
            } else if (choice == 4) {
                displaySalaryAfterDeduction(); // This method is now uncommented
            } else if (choice == 5) {
                break;
            }
        } while (true);
    }

    private static int displayMenu() {
        int choice = 0;

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add a New Employee Record ");
            System.out.println("2. List all Employees Records ");
            System.out.println("3. Deduction of Employee Contributions 20% ");
            System.out.println("4. Display Employee Salary After 20% Deductions ");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            // consume the newline character
            scanner.nextLine(); // Consume the newline character after scanner.nextInt()
            if (choice >= 1 && choice <= 5) {
                break;
            }
        }
        return choice;
    }

    private static void addNewEmployee() {
        System.out.println("Enter the Name of the New Employee: ");
        String name = scanner.nextLine();
        System.out.println("Enter the Department of the New Employee: ");
        String department = scanner.nextLine();

        while (true) {
            System.out.println("Choose the Type of Employee (FullTime / PartTime: ");
            System.out.println("1. FullTime Employee");
            System.out.println("2. PartTime Employee");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character remaining in the buffer

            if (choice == 1) {
                System.out.println("Enter the Salary of the FullTime Employee: ");
                double monthlySalary = scanner.nextDouble();
                scanner.nextLine(); // consume the newline character remaining in the buffer

                FullTimeEmployee fullTimeEmployee = new FullTimeEmployee(name, department, monthlySalary);
                employeeList.add(fullTimeEmployee);
                System.out.println("New Employee FullTime added successfully!");
                break;

            } else if (choice == 2) {
                System.out.println("Enter the Hourly Rate of the PartTime Employee: ");
                double hourlyRate = scanner.nextDouble();
                scanner.nextLine(); // consume the newline character remaining in the buffer

                System.out.println("Enter the Number of Hours Work for the PartTime Employee: ");
                double hoursWorked = scanner.nextDouble();
                scanner.nextLine(); // consume the newline character remaining in the buffer

                PartTimeEmployee partTimeEmployee = new PartTimeEmployee(name, department, hourlyRate, hoursWorked) {
                    @Override
                    public double calculateSalesTax() {
                        return 0.0;
                    }
                };
                employeeList.add(partTimeEmployee);
                System.out.println("New Employee PartTime added successfully!");
                break;

            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void listAllEmployees() {
        for (int i = 0; i < employeeList.size(); i++) {
            Employee e = employeeList.get(i);
            // print out the index
            System.out.println("Employee #" + i);
            e.displayDetails();
            System.out.println();
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose an option:");
        System.out.println("1. Exit");
        System.out.println("2. Edit An Employee Record");
        System.out.println("3. Delete An Employee Record");
        int option = scanner.nextInt();

        if (option == 2) {
            System.out.print("Enter the index of the Employee Record You want to Edit: ");
            int index = scanner.nextInt();
            if (index >= 0 && index < employeeList.size()) {
                Employee employeeToEdit = employeeList.get(index);
                editEmployee(employeeToEdit);
            } else {
                System.out.println("Invalid index.");
            }
        } else if (option == 3) {
            System.out.print("Enter the index of the Employee Record You want to Delete: ");
            int index = scanner.nextInt();
            if (index >= 0 && index < employeeList.size()) {
                employeeList.remove(index);
                System.out.println("Employee Record deleted.");
            } else {
                System.out.println("Invalid Employee Record index.");
            }
        }
    }

    public static void editEmployee(Employee e) {
        e.editDetails();
    }

    private static void deductContributions() {
        System.out.println("Employee Contributions Deductions: ");

        for (Employee employee : employeeList) {
            double employeeSalary;
            String employeeName = employee.getName(); // Assuming you have a getName() method in Employee class

            if (employee instanceof FullTimeEmployee) {
                employeeSalary = ((FullTimeEmployee) employee).getMonthlySalary();
            } else if (employee instanceof PartTimeEmployee) {
                employeeSalary = ((PartTimeEmployee) employee).calculateMonthlySalary();
            } else {
                continue;
            }

            // Create a Contribution instance for the employee's name and salary
            Contribution contribution = new Contribution(employeeName, employeeSalary);
            contribution.displayBasicContributionDetails(); // Ensure only one method matches
            System.out.println("--------------------------------------------");
        }
    }

    private static void displaySalaryAfterDeduction() {
        System.out.println("Employee Salary After 20% Deduction:");
        for (Employee employee : employeeList) {
            double employeeSalary = employee.getSalary();
            String employeeName = employee.getName(); // Assuming you have a getName() method in Employee class

            Contribution contribution = new Contribution(employeeName, employeeSalary);
            contribution.displaySalaryAfterDeduction(); //Ensure only one method matches
            System.out.println("--------------------------------------------");
        }
    }



}