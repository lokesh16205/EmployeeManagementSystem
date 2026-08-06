package manager;

import model.Attendance;
import service.AttendanceService;
import utility.Input;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

public class AttendanceManager {

    private AttendanceService attendanceService;
    private Scanner scanner;

    public AttendanceManager() {
        attendanceService = new AttendanceService();
        scanner = Input.scanner;
    }

    public void attendanceMenu() {

        while (true) {

            System.out.println("\n========== Attendance Menu ==========");
            System.out.println("1. Mark Attendance");
            System.out.println("2. View All Attendance");
            System.out.println("3. Search Attendance By Employee ID");
            System.out.println("4. Delete Attendance");
            System.out.println("5. Back");
            System.out.print("Enter Choice : ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    markAttendance();
                    break;

                case 2:
                    viewAttendance();
                    break;

                case 3:
                    searchAttendance();
                    break;

                case 4:
                    deleteAttendance();
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid Choice.");
            }
        }
    }

    private void markAttendance() {

        Attendance attendance = new Attendance();

        System.out.print("Employee ID : ");
        attendance.setEmployeeId(scanner.nextInt());
        scanner.nextLine();

        System.out.print("Attendance Date (yyyy-mm-dd) : ");
        attendance.setAttendanceDate(Date.valueOf(scanner.nextLine()));

        System.out.print("Status (Present/Absent) : ");
        attendance.setStatus(scanner.nextLine());

        boolean result = attendanceService.markAttendance(attendance);

        if(result)
            System.out.println("Attendance Marked Successfully.");
        else
            System.out.println("Failed to Mark Attendance.");
    }

    private void viewAttendance() {

        ArrayList<Attendance> attendanceList = attendanceService.getAllAttendance();

        if(attendanceList.isEmpty()){

            System.out.println("No Attendance Found.");
            return;
        }

        for(Attendance attendance : attendanceList){

            System.out.println("----------------------------------");
            System.out.println("Attendance ID : " + attendance.getAttendanceId());
            System.out.println("Employee ID   : " + attendance.getEmployeeId());
            System.out.println("Date          : " + attendance.getAttendanceDate());
            System.out.println("Status        : " + attendance.getStatus());
        }
    }

    private void searchAttendance() {

        System.out.print("Enter Employee ID : ");

        int employeeId = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Attendance> attendanceList =
                attendanceService.searchAttendanceByEmployeeId(employeeId);

        if(attendanceList.isEmpty()){

            System.out.println("No Attendance Record Found.");
            return;
        }

        for(Attendance attendance : attendanceList){

            System.out.println("----------------------------------");
            System.out.println("Attendance ID : " + attendance.getAttendanceId());
            System.out.println("Employee ID   : " + attendance.getEmployeeId());
            System.out.println("Date          : " + attendance.getAttendanceDate());
            System.out.println("Status        : " + attendance.getStatus());
        }
    }

    private void deleteAttendance() {

        System.out.print("Enter Attendance ID : ");

        int attendanceId = scanner.nextInt();
        scanner.nextLine();

        boolean result = attendanceService.deleteAttendance(attendanceId);

        if(result)
            System.out.println("Attendance Deleted Successfully.");
        else
            System.out.println("Attendance Not Found.");
    }

}