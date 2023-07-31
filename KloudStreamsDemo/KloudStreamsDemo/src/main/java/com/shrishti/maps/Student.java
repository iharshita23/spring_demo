package com.shrishti.maps;
public class Student {
    int studentId;
    String studentName;
    String city;
    public Student(int studentId, String studentName, String city) {
        super();
        this.studentId = studentId;
        this.studentName = studentName;
        this.city = city;
    }
   public Student() {
        super();
    }
   @Override
   public String toString() {
        return "Student [studentId=" + studentId + ", studentName=" + studentName + ", city=" + city + "]";
    }
}

