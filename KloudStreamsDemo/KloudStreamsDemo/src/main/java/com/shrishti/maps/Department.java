package com.shrishti.maps;

public class Department {
    int deptId;
    String deptName;
    String deptHead;
    public Department(int studentId, String studentName, String deptHead) {
        super();
        this.deptId = studentId;
        this.deptName = studentName;
        this.deptHead = deptHead;
    }
   public Department() {
        super();
    }
    @Override
    public String toString() {
        return "Department [deptId=" + deptId + ", deptName=" + deptName + ", deptHead=" + deptHead + "]";
    }
}