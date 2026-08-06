package model;

public class Department {

    private int departmentId;
    private String departmentName;

    // Default Constructor
    public Department() {
    }

    // Parameterized Constructor
    public Department(int departmentId, String departmentName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }

    // Getter
    public int getDepartmentId() {
        return departmentId;
    }

    // Setter
    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    // Getter
    public String getDepartmentName() {
        return departmentName;
    }

    // Setter
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}