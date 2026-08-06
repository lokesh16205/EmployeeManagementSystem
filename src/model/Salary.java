package model;

public class Salary {

    private int salaryId;
    private int employeeId;
    private double basicSalary;
    private double bonus;
    private double deduction;
    private double netSalary;

    // Default Constructor
    public Salary() {
    }

    // Parameterized Constructor
    public Salary(int salaryId, int employeeId, double basicSalary,
                  double bonus, double deduction, double netSalary) {

        this.salaryId = salaryId;
        this.employeeId = employeeId;
        this.basicSalary = basicSalary;
        this.bonus = bonus;
        this.deduction = deduction;
        this.netSalary = netSalary;
    }

    public int getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(int salaryId) {
        this.salaryId = salaryId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getDeduction() {
        return deduction;
    }

    public void setDeduction(double deduction) {
        this.deduction = deduction;
    }

    public double getNetSalary() {
        return netSalary;
    }

    public void setNetSalary(double netSalary) {
        this.netSalary = netSalary;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "salaryId=" + salaryId +
                ", employeeId=" + employeeId +
                ", basicSalary=" + basicSalary +
                ", bonus=" + bonus +
                ", deduction=" + deduction +
                ", netSalary=" + netSalary +
                '}';
    }
}