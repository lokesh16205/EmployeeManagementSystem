package service;

import dao.EmployeeDAO;
import model.Employee;

import java.util.ArrayList;

public class EmployeeService {

    private EmployeeDAO employeeDAO;

    public EmployeeService() {
        employeeDAO = new EmployeeDAO();
    }

    // Add Employee
    public boolean addEmployee(Employee employee) {
        return employeeDAO.addEmployee(employee);
    }

    // View All Employees
    public ArrayList<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    // Search Employee
    public Employee searchEmployeeById(int employeeId) {
        return employeeDAO.searchEmployeeById(employeeId);
    }

    // Update Employee
    public boolean updateEmployee(Employee employee) {
        return employeeDAO.updateEmployee(employee);
    }

    // Delete Employee
    public boolean deleteEmployee(int employeeId) {
        return employeeDAO.deleteEmployee(employeeId);
    }
}