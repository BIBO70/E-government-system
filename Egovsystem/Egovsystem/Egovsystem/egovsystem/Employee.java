package com.mycompany.egovsystem;
public class Employee {
    private String employeeName;
    private String employeeId;
    private String department;

    // Constructor
    public Employee(String employeeName, String employeeId, String department) {
        setEmployeeName(employeeName);
        setEmployeeId(employeeId);
        setDepartment(department);
    }

    // Getter and Setter for Employee Name
    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        if (employeeName != null && !employeeName.trim().isEmpty()) {
            this.employeeName = employeeName;
        } else {
            throw new IllegalArgumentException("Employee name cannot be empty.");
        }
    }

    // Getter and Setter for Employee ID
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        if (employeeId != null && !employeeId.trim().isEmpty()) {
            this.employeeId = employeeId;
        } else {
            throw new IllegalArgumentException("Employee ID cannot be empty.");
        }
    }

    // Getter and Setter for Department
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        if (department != null && !department.trim().isEmpty()) {
            this.department = department;
        } else {
            throw new IllegalArgumentException("Department cannot be empty.");
        }
    }

    // ToString method for debugging or display
    @Override
    public String toString() {
        return "Employee{" +
                "employeeName='" + employeeName + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
