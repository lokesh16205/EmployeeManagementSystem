package service;

import dao.AttendanceDAO;
import model.Attendance;

import java.util.ArrayList;

public class AttendanceService {

    private AttendanceDAO attendanceDAO;

    public AttendanceService() {
        attendanceDAO = new AttendanceDAO();
    }

    public boolean markAttendance(Attendance attendance) {
        return attendanceDAO.markAttendance(attendance);
    }

    public ArrayList<Attendance> getAllAttendance() {
        return attendanceDAO.getAllAttendance();
    }

    public ArrayList<Attendance> searchAttendanceByEmployeeId(int employeeId) {
        return attendanceDAO.searchAttendanceByEmployeeId(employeeId);
    }

    public boolean deleteAttendance(int attendanceId) {
        return attendanceDAO.deleteAttendance(attendanceId);
    }
}