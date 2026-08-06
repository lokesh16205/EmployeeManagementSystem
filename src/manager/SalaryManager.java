package manager;

import model.Salary;
import service.SalaryService;
import utility.Input;

import java.util.ArrayList;
import java.util.Scanner;

public class SalaryManager {

    private SalaryService salaryService;
    private Scanner scanner;

    public SalaryManager() {
        salaryService = new SalaryService();
        scanner = Input.scanner;
    }

    public void salaryMenu() {

        while (true) {

            System.out.println("\n========== Salary Menu ==========");
            System.out.println("1. Add Salary");
            System.out.println("2. View All Salaries");
            System.out.println("3. Search Salary By Employee ID");
            System.out.println("4. Update Salary");
            System.out.println("5. Delete Salary");
            System.out.println("6. Back");
            System.out.print("Enter Choice : ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    addSalary();
                    break;

                case 2:
                    viewSalaries();
                    break;

                case 3:
                    searchSalary();
                    break;

                case 4:
                    updateSalary();
                    break;

                case 5:
                    deleteSalary();
                    break;

                case 6:
                    return;

                default:
                    System.out.println("Invalid Choice.");
            }
        }
    }

    private void addSalary() {

        Salary salary = new Salary();

        System.out.print("Employee ID : ");
        salary.setEmployeeId(scanner.nextInt());

        System.out.print("Basic Salary : ");
        salary.setBasicSalary(scanner.nextDouble());

        System.out.print("Bonus : ");
        salary.setBonus(scanner.nextDouble());

        System.out.print("Deduction : ");
        salary.setDeduction(scanner.nextDouble());

        scanner.nextLine();

        salary.setNetSalary(
                salary.getBasicSalary()
                        + salary.getBonus()
                        - salary.getDeduction());

        boolean result = salaryService.addSalary(salary);

        if(result)
            System.out.println("Salary Added Successfully.");
        else
            System.out.println("Failed to Add Salary.");
    }

    private void viewSalaries() {

        ArrayList<Salary> salaryList = salaryService.getAllSalaries();

        if(salaryList.isEmpty()){

            System.out.println("No Salary Records Found.");
            return;
        }

        for(Salary salary : salaryList){

            System.out.println("----------------------------------");
            System.out.println("Salary ID      : " + salary.getSalaryId());
            System.out.println("Employee ID    : " + salary.getEmployeeId());
            System.out.println("Basic Salary   : " + salary.getBasicSalary());
            System.out.println("Bonus          : " + salary.getBonus());
            System.out.println("Deduction      : " + salary.getDeduction());
            System.out.println("Net Salary     : " + salary.getNetSalary());
        }
    }

    private void searchSalary() {

        System.out.print("Enter Employee ID : ");

        int employeeId = scanner.nextInt();
        scanner.nextLine();

        Salary salary = salaryService.searchSalaryByEmployeeId(employeeId);

        if(salary == null){

            System.out.println("Salary Record Not Found.");
            return;
        }

        System.out.println("----------------------------------");
        System.out.println("Salary ID      : " + salary.getSalaryId());
        System.out.println("Employee ID    : " + salary.getEmployeeId());
        System.out.println("Basic Salary   : " + salary.getBasicSalary());
        System.out.println("Bonus          : " + salary.getBonus());
        System.out.println("Deduction      : " + salary.getDeduction());
        System.out.println("Net Salary     : " + salary.getNetSalary());
    }

    private void updateSalary() {

        System.out.print("Enter Employee ID : ");

        int employeeId = scanner.nextInt();
        scanner.nextLine();

        Salary salary = salaryService.searchSalaryByEmployeeId(employeeId);

        if(salary == null){

            System.out.println("Salary Record Not Found.");
            return;
        }

        System.out.print("Basic Salary : ");
        salary.setBasicSalary(scanner.nextDouble());

        System.out.print("Bonus : ");
        salary.setBonus(scanner.nextDouble());

        System.out.print("Deduction : ");
        salary.setDeduction(scanner.nextDouble());

        scanner.nextLine();

        salary.setNetSalary(
                salary.getBasicSalary()
                        + salary.getBonus()
                        - salary.getDeduction());

        boolean result = salaryService.updateSalary(salary);

        if(result)
            System.out.println("Salary Updated Successfully.");
        else
            System.out.println("Failed to Update Salary.");
    }

    private void deleteSalary() {

        System.out.print("Enter Salary ID : ");

        int salaryId = scanner.nextInt();
        scanner.nextLine();

        boolean result = salaryService.deleteSalary(salaryId);

        if(result)
            System.out.println("Salary Deleted Successfully.");
        else
            System.out.println("Salary Record Not Found.");
    }

}