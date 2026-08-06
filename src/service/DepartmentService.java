package service;

import dao.DepartmentDAO;
import model.Department;

import java.util.ArrayList;

public class DepartmentService {

    private DepartmentDAO departmentDAO;

    public DepartmentService() {
        departmentDAO = new DepartmentDAO();
    }

    public boolean addDepartment(Department department) {
        return departmentDAO.addDepartment(department);
    }

    public ArrayList<Department> getAllDepartments() {
        return departmentDAO.getAllDepartments();
    }

    public boolean deleteDepartment(int departmentId) {
        return departmentDAO.deleteDepartment(departmentId);
    }
}