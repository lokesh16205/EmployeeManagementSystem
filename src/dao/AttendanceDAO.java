package dao;

import database.DBConnection;
import model.Attendance;

import java.sql.*;
import java.util.ArrayList;

public class AttendanceDAO {

    private Connection connection;

    public AttendanceDAO() {
        connection = DBConnection.getConnection();
    }

    // Mark Attendance
    public boolean markAttendance(Attendance attendance) {

        String query = "INSERT INTO attendance(employee_id, attendance_date, status) VALUES(?,?,?)";

        try {

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setInt(1, attendance.getEmployeeId());
            ps.setDate(2, attendance.getAttendanceDate());
            ps.setString(3, attendance.getStatus());

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // View All Attendance
    public ArrayList<Attendance> getAllAttendance() {

        ArrayList<Attendance> attendanceList = new ArrayList<>();

        String query = "SELECT * FROM attendance";

        try {

            PreparedStatement ps = connection.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Attendance attendance = new Attendance();

                attendance.setAttendanceId(rs.getInt("attendance_id"));
                attendance.setEmployeeId(rs.getInt("employee_id"));
                attendance.setAttendanceDate(rs.getDate("attendance_date"));
                attendance.setStatus(rs.getString("status"));

                attendanceList.add(attendance);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return attendanceList;
    }

    // Search Attendance By Employee ID
    public ArrayList<Attendance> searchAttendanceByEmployeeId(int employeeId) {

        ArrayList<Attendance> attendanceList = new ArrayList<>();

        String query = "SELECT * FROM attendance WHERE employee_id=?";

        try {

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setInt(1, employeeId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Attendance attendance = new Attendance();

                attendance.setAttendanceId(rs.getInt("attendance_id"));
                attendance.setEmployeeId(rs.getInt("employee_id"));
                attendance.setAttendanceDate(rs.getDate("attendance_date"));
                attendance.setStatus(rs.getString("status"));

                attendanceList.add(attendance);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return attendanceList;
    }

    // Delete Attendance
    public boolean deleteAttendance(int attendanceId) {

        String query = "DELETE FROM attendance WHERE attendance_id=?";

        try {

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setInt(1, attendanceId);

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}