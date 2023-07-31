package com.employeeapp.model;

public enum Grade {
	DIRECTOR("O","DIRECTOR"),

    MANAGER("A","MANAGER"),

    DEVELOPER("B","DEVELOPER"),

    ADMIN("C","ADMIN"),

    NETWORKING("D","NETWORKING");

 

    

    private String gradetype;

    private String gradeNAme;

    

    private Grade(String gradetype, String gradeNAme) {

        this.gradetype = gradetype;

        this.gradeNAme = gradeNAme;

    }

    public String getGradetype() {

        return gradetype;

    }

    public void setGradetype(String gradetype) {

        this.gradetype = gradetype;

    }

    public String getGradeNAme() {

        return gradeNAme;

    }

    public void setGradeNAme(String gradeNAme) {

        this.gradeNAme = gradeNAme;

    }

 

}

 