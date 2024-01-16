import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class Controller {
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addEmployee(payrollSystem, scanner);
                    break;
                case 2:
                    removeEmployee(payrollSystem, scanner);
                    break;
                case 3:
                    displayEmployees(payrollSystem);
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("1. Add Employee");
        System.out.println("2. Remove Employee");
        System.out.println("3. Display Employees");
        System.out.println("4. Exit");
    }

    private static void addEmployee(PayrollSystem payrollSystem, Scanner scanner) {
        System.out.println("Enter employee details:");
        System.out.print("Name: ");
        String name = scanner.next();
        System.out.print("ID: ");
        int id = scanner.nextInt();
        System.out.print("Type (1 for Full Time, 2 for Part Time): ");
        int type = scanner.nextInt();

        if (type == 1) {
            System.out.print("Monthly Salary: ");
            double monthlySalary = scanner.nextDouble();
            FullTimeEmployee fullTimeEmployee = new FullTimeEmployee(name, id, monthlySalary);
            payrollSystem.addEmployee(fullTimeEmployee);
            System.out.println("Full-Time Employee added successfully.");
        } else if (type == 2) {
            System.out.print("Hours Worked: ");
            int hoursWorked = scanner.nextInt();
            System.out.print("Hourly Rate: ");
            double hourlyRate = scanner.nextDouble();
            PartTimeEmployee partTimeEmployee = new PartTimeEmployee(name, id, hoursWorked, hourlyRate);
            payrollSystem.addEmployee(partTimeEmployee);
            System.out.println("Part-Time Employee added successfully.");
        } else {
            System.out.println("Invalid employee type.");
        }
    }

    private static void removeEmployee(PayrollSystem payrollSystem, Scanner scanner) {
        System.out.print("Enter employee ID to remove: ");
        int id = scanner.nextInt();
        payrollSystem.removeEmployee(id);
    }

    private static void displayEmployees(PayrollSystem payrollSystem) {
        System.out.println("Employee Details:");
        payrollSystem.displayEmployees();
    }
}
