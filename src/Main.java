import manager.AttendanceManager;
import manager.DepartmentManager;
import manager.EmployeeManager;
import manager.SalaryManager;
import utility.Input;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = Input.scanner;

        EmployeeManager employeeManager = new EmployeeManager();
        DepartmentManager departmentManager = new DepartmentManager();
        AttendanceManager attendanceManager = new AttendanceManager();
        SalaryManager salaryManager = new SalaryManager();

        while (true) {

            System.out.println("\n==========================================");
            System.out.println("     EMPLOYEE MANAGEMENT SYSTEM");
            System.out.println("==========================================");
            System.out.println("1. Employee Management");
            System.out.println("2. Department Management");
            System.out.println("3. Attendance Management");
            System.out.println("4. Salary Management");
            System.out.println("5. Exit");
            System.out.print("Enter Your Choice : ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    employeeManager.employeeMenu();
                    break;

                case 2:
                    departmentManager.departmentMenu();
                    break;

                case 3:
                    attendanceManager.attendanceMenu();
                    break;

                case 4:
                    salaryManager.salaryMenu();
                    break;

                case 5:
                    System.out.println("\nThank You For Using Employee Management System.");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice.");
            }
        }
    }
}