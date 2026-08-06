package manager;

import model.Department;
import service.DepartmentService;
import utility.Input;

import java.util.ArrayList;
import java.util.Scanner;

public class DepartmentManager {

    private DepartmentService departmentService;
    private Scanner scanner;

    public DepartmentManager() {
        departmentService = new DepartmentService();
        scanner = Input.scanner;
    }

    public void departmentMenu() {

        while (true) {

            System.out.println("\n========== Department Menu ==========");
            System.out.println("1. Add Department");
            System.out.println("2. View Departments");
            System.out.println("3. Delete Department");
            System.out.println("4. Back");
            System.out.print("Enter Choice : ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    addDepartment();
                    break;

                case 2:
                    viewDepartments();
                    break;

                case 3:
                    deleteDepartment();
                    break;

                case 4:
                    return;

                default:
                    System.out.println("Invalid Choice.");
            }

        }
    }

    private void addDepartment() {

        Department department = new Department();

        System.out.print("Department Name : ");
        department.setDepartmentName(scanner.nextLine());

        boolean result = departmentService.addDepartment(department);

        if (result)
            System.out.println("Department Added Successfully.");
        else
            System.out.println("Failed to Add Department.");
    }

    private void viewDepartments() {

        ArrayList<Department> departmentList = departmentService.getAllDepartments();

        if (departmentList.isEmpty()) {

            System.out.println("No Department Found.");
            return;
        }

        System.out.println("\n========== Department List ==========");

        for (Department department : departmentList) {

            System.out.println("---------------------------");
            System.out.println("Department ID   : " + department.getDepartmentId());
            System.out.println("Department Name : " + department.getDepartmentName());
        }
    }

    private void deleteDepartment() {

        System.out.print("Enter Department ID : ");

        int departmentId = scanner.nextInt();
        scanner.nextLine();

        boolean result = departmentService.deleteDepartment(departmentId);

        if (result)
            System.out.println("Department Deleted Successfully.");
        else
            System.out.println("Department Not Found.");
    }
}