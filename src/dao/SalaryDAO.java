package dao;

import database.DBConnection;
import model.Salary;

import java.sql.*;
import java.util.ArrayList;

public class SalaryDAO {

    private Connection connection;

    public SalaryDAO() {
        connection = DBConnection.getConnection();
    }

    // Add Salary
    public boolean addSalary(Salary salary) {

        String query = "INSERT INTO salary(employee_id, basic_salary, bonus, deduction, net_salary) VALUES(?,?,?,?,?)";

        try {

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setInt(1, salary.getEmployeeId());
            ps.setDouble(2, salary.getBasicSalary());
            ps.setDouble(3, salary.getBonus());
            ps.setDouble(4, salary.getDeduction());
            ps.setDouble(5, salary.getNetSalary());

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // View All Salaries
    public ArrayList<Salary> getAllSalaries() {

        ArrayList<Salary> salaryList = new ArrayList<>();

        String query = "SELECT * FROM salary";

        try {

            PreparedStatement ps = connection.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Salary salary = new Salary();

                salary.setSalaryId(rs.getInt("salary_id"));
                salary.setEmployeeId(rs.getInt("employee_id"));
                salary.setBasicSalary(rs.getDouble("basic_salary"));
                salary.setBonus(rs.getDouble("bonus"));
                salary.setDeduction(rs.getDouble("deduction"));
                salary.setNetSalary(rs.getDouble("net_salary"));

                salaryList.add(salary);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return salaryList;
    }

    // Search Salary By Employee ID
    public Salary searchSalaryByEmployeeId(int employeeId) {

        String query = "SELECT * FROM salary WHERE employee_id=?";

        try {

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setInt(1, employeeId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Salary salary = new Salary();

                salary.setSalaryId(rs.getInt("salary_id"));
                salary.setEmployeeId(rs.getInt("employee_id"));
                salary.setBasicSalary(rs.getDouble("basic_salary"));
                salary.setBonus(rs.getDouble("bonus"));
                salary.setDeduction(rs.getDouble("deduction"));
                salary.setNetSalary(rs.getDouble("net_salary"));

                return salary;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // Update Salary
    public boolean updateSalary(Salary salary) {

        String query = "UPDATE salary SET basic_salary=?, bonus=?, deduction=?, net_salary=? WHERE employee_id=?";

        try {

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setDouble(1, salary.getBasicSalary());
            ps.setDouble(2, salary.getBonus());
            ps.setDouble(3, salary.getDeduction());
            ps.setDouble(4, salary.getNetSalary());
            ps.setInt(5, salary.getEmployeeId());

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // Delete Salary
    public boolean deleteSalary(int salaryId) {

        String query = "DELETE FROM salary WHERE salary_id=?";

        try {

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setInt(1, salaryId);

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}