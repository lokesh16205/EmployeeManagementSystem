
package manager;

import model.Employee;
import service.EmployeeService;
import utility.Input;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManager {

    private EmployeeService employeeService;
    private Scanner scanner;

    public EmployeeManager() {
        employeeService = new EmployeeService();
        scanner = Input.scanner;
    }

    public void employeeMenu() {

        while (true) {

            System.out.println("\n========== Employee Menu ==========");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Back");
            System.out.print("Enter Choice : ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    addEmployee();
                    break;

                case 2:
                    viewEmployees();
                    break;

                case 3:
                    searchEmployee();
                    break;

                case 4:
                    updateEmployee();
                    break;

                case 5:
                    deleteEmployee();
                    break;

                case 6:
                    return;

                default:
                    System.out.println("Invalid Choice.");
            }

        }

    }

    private void addEmployee() {

        Employee employee = new Employee();

        System.out.print("First Name : ");
        employee.setFirstName(scanner.nextLine());

        System.out.print("Last Name : ");
        employee.setLastName(scanner.nextLine());

        System.out.print("Gender : ");
        employee.setGender(scanner.nextLine());

        System.out.print("Age : ");
        employee.setAge(scanner.nextInt());
        scanner.nextLine();

        System.out.print("Phone : ");
        employee.setPhone(scanner.nextLine());

        System.out.print("Email : ");
        employee.setEmail(scanner.nextLine());

        System.out.print("Department ID : ");
        employee.setDepartmentId(scanner.nextInt());
        scanner.nextLine();

        System.out.print("Designation : ");
        employee.setDesignation(scanner.nextLine());

        System.out.print("Hire Date (yyyy-mm-dd) : ");
        employee.setHireDate(Date.valueOf(scanner.nextLine()));

        boolean result = employeeService.addEmployee(employee);

        if (result)
            System.out.println("Employee Added Successfully.");
        else
            System.out.println("Failed to Add Employee.");
    }

    private void viewEmployees() {

        ArrayList<Employee> employeeList = employeeService.getAllEmployees();

        if (employeeList.isEmpty()) {

            System.out.println("No Employees Found.");
            return;
        }

        System.out.println("\n================ Employee List ================");

        for (Employee employee : employeeList) {

            System.out.println("--------------------------------------------");
            System.out.println("Employee ID   : " + employee.getEmployeeId());
            System.out.println("First Name    : " + employee.getFirstName());
            System.out.println("Last Name     : " + employee.getLastName());
            System.out.println("Gender        : " + employee.getGender());
            System.out.println("Age           : " + employee.getAge());
            System.out.println("Phone         : " + employee.getPhone());
            System.out.println("Email         : " + employee.getEmail());
            System.out.println("Department ID : " + employee.getDepartmentId());
            System.out.println("Designation   : " + employee.getDesignation());
            System.out.println("Hire Date     : " + employee.getHireDate());

        }

        System.out.println("--------------------------------------------");
    }

    private void searchEmployee() {

        System.out.print("Enter Employee ID : ");

        int employeeId = scanner.nextInt();
        scanner.nextLine();

        Employee employee = employeeService.searchEmployeeById(employeeId);

        if (employee == null) {

            System.out.println("Employee Not Found.");
            return;
        }

        System.out.println("\n========= Employee Details =========");

        System.out.println("Employee ID   : " + employee.getEmployeeId());
        System.out.println("First Name    : " + employee.getFirstName());
        System.out.println("Last Name     : " + employee.getLastName());
        System.out.println("Gender        : " + employee.getGender());
        System.out.println("Age           : " + employee.getAge());
        System.out.println("Phone         : " + employee.getPhone());
        System.out.println("Email         : " + employee.getEmail());
        System.out.println("Department ID : " + employee.getDepartmentId());
        System.out.println("Designation   : " + employee.getDesignation());
        System.out.println("Hire Date     : " + employee.getHireDate());

    }

    private void updateEmployee() {

        System.out.print("Enter Employee ID to Update : ");

        int employeeId = scanner.nextInt();
        scanner.nextLine();

        Employee employee = employeeService.searchEmployeeById(employeeId);

        if (employee == null) {

            System.out.println("Employee Not Found.");
            return;
        }

        System.out.println("\nEnter New Details");

        System.out.print("First Name : ");
        employee.setFirstName(scanner.nextLine());

        System.out.print("Last Name : ");
        employee.setLastName(scanner.nextLine());

        System.out.print("Gender : ");
        employee.setGender(scanner.nextLine());

        System.out.print("Age : ");
        employee.setAge(scanner.nextInt());
        scanner.nextLine();

        System.out.print("Phone : ");
        employee.setPhone(scanner.nextLine());

        System.out.print("Email : ");
        employee.setEmail(scanner.nextLine());

        System.out.print("Department ID : ");
        employee.setDepartmentId(scanner.nextInt());
        scanner.nextLine();

        System.out.print("Designation : ");
        employee.setDesignation(scanner.nextLine());

        System.out.print("Hire Date (yyyy-mm-dd) : ");
        employee.setHireDate(Date.valueOf(scanner.nextLine()));

        boolean result = employeeService.updateEmployee(employee);

        if (result)
            System.out.println("Employee Updated Successfully.");
        else
            System.out.println("Failed to Update Employee.");
    }

    private void deleteEmployee() {

        System.out.print("Enter Employee ID : ");

        int employeeId = scanner.nextInt();
        scanner.nextLine();

        boolean result = employeeService.deleteEmployee(employeeId);

        if (result)
            System.out.println("Employee Deleted Successfully.");
        else
            System.out.println("Employee Not Found.");
    }
}