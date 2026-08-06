package dao;

import database.DBConnection;
import model.Department;

import java.sql.*;
import java.util.ArrayList;

public class DepartmentDAO {

    private Connection connection;

    public DepartmentDAO() {
        connection = DBConnection.getConnection();
    }

    // Add Department
    public boolean addDepartment(Department department) {

        String query = "INSERT INTO department(department_name) VALUES(?)";

        try {

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, department.getDepartmentName());

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // View All Departments
    public ArrayList<Department> getAllDepartments() {

        ArrayList<Department> departmentList = new ArrayList<>();

        String query = "SELECT * FROM department";

        try {

            PreparedStatement ps = connection.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Department department = new Department();

                department.setDepartmentId(rs.getInt("department_id"));
                department.setDepartmentName(rs.getString("department_name"));

                departmentList.add(department);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return departmentList;
    }

    // Delete Department
    public boolean deleteDepartment(int departmentId) {

        String query = "DELETE FROM department WHERE department_id=?";

        try {

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setInt(1, departmentId);

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}