package service;

import dao.SalaryDAO;
import model.Salary;

import java.util.ArrayList;

public class SalaryService {

    private SalaryDAO salaryDAO;

    public SalaryService() {
        salaryDAO = new SalaryDAO();
    }

    public boolean addSalary(Salary salary) {
        return salaryDAO.addSalary(salary);
    }

    public ArrayList<Salary> getAllSalaries() {
        return salaryDAO.getAllSalaries();
    }

    public Salary searchSalaryByEmployeeId(int employeeId) {
        return salaryDAO.searchSalaryByEmployeeId(employeeId);
    }

    public boolean updateSalary(Salary salary) {
        return salaryDAO.updateSalary(salary);
    }

    public boolean deleteSalary(int salaryId) {
        return salaryDAO.deleteSalary(salaryId);
    }
}