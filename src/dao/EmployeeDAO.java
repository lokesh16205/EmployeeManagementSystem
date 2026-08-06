package dao;

import database.DBConnection;
import model.Employee;

import java.sql.*;
import java.util.ArrayList;

public class EmployeeDAO {

    private Connection connection;

    public EmployeeDAO() {
        connection = DBConnection.getConnection();
    }

    public boolean addEmployee(Employee employee) {

        String query = "INSERT INTO employee(first_name,last_name,gender,age,phone,email,department_id,designation,hire_date) VALUES(?,?,?,?,?,?,?,?,?)";

        try {

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, employee.getFirstName());
            ps.setString(2, employee.getLastName());
            ps.setString(3, employee.getGender());
            ps.setInt(4, employee.getAge());
            ps.setString(5, employee.getPhone());
            ps.setString(6, employee.getEmail());
            ps.setInt(7, employee.getDepartmentId());
            ps.setString(8, employee.getDesignation());
            ps.setDate(9, employee.getHireDate());

            int rows = ps.executeUpdate();

            return rows > 0;

        }catch (SQLException e) {

            if (e.getErrorCode() == 1452) {

                System.out.println("Invalid Department ID. Please select an existing department.");

            } else {

                e.printStackTrace();
            }
        }

        return false;
    }

    public ArrayList<Employee> getAllEmployees() {

        ArrayList<Employee> employeeList = new ArrayList<>();

        String query = "SELECT * FROM employee";

        try {

            PreparedStatement ps = connection.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Employee employee = new Employee();

                employee.setEmployeeId(rs.getInt("employee_id"));
                employee.setFirstName(rs.getString("first_name"));
                employee.setLastName(rs.getString("last_name"));
                employee.setGender(rs.getString("gender"));
                employee.setAge(rs.getInt("age"));
                employee.setPhone(rs.getString("phone"));
                employee.setEmail(rs.getString("email"));
                employee.setDepartmentId(rs.getInt("department_id"));
                employee.setDesignation(rs.getString("designation"));
                employee.setHireDate(rs.getDate("hire_date"));

                employeeList.add(employee);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employeeList;
    }

    public Employee searchEmployeeById(int employeeId) {

        String query = "SELECT * FROM employee WHERE employee_id = ?";

        try {

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setInt(1, employeeId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Employee employee = new Employee();

                employee.setEmployeeId(rs.getInt("employee_id"));
                employee.setFirstName(rs.getString("first_name"));
                employee.setLastName(rs.getString("last_name"));
                employee.setGender(rs.getString("gender"));
                employee.setAge(rs.getInt("age"));
                employee.setPhone(rs.getString("phone"));
                employee.setEmail(rs.getString("email"));
                employee.setDepartmentId(rs.getInt("department_id"));
                employee.setDesignation(rs.getString("designation"));
                employee.setHireDate(rs.getDate("hire_date"));

                return employee;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean updateEmployee(Employee employee) {

        String query = "UPDATE employee SET first_name=?, last_name=?, gender=?, age=?, phone=?, email=?, department_id=?, designation=?, hire_date=? WHERE employee_id=?";

        try {

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, employee.getFirstName());
            ps.setString(2, employee.getLastName());
            ps.setString(3, employee.getGender());
            ps.setInt(4, employee.getAge());
            ps.setString(5, employee.getPhone());
            ps.setString(6, employee.getEmail());
            ps.setInt(7, employee.getDepartmentId());
            ps.setString(8, employee.getDesignation());
            ps.setDate(9, employee.getHireDate());
            ps.setInt(10, employee.getEmployeeId());

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean deleteEmployee(int employeeId) {

        String query = "DELETE FROM employee WHERE employee_id = ?";

        try {

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setInt(1, employeeId);

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }



}