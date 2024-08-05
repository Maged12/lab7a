package edu.miu.cs.cs425.studentrecordsmgmtapp.model;

import java.util.Date;

public class Student {

    private String studentId;

    private String name;

    private Date dateOfAdmission;

    public Student(String studentId, String name, Date dateOfAdmission) {
        this.studentId = studentId;
        this.name = name;
        this.dateOfAdmission = dateOfAdmission;
    }

    public Student() {
    }

    public Student(String name, Date dateOfAdmission) {
        this.name = name;
        this.dateOfAdmission = dateOfAdmission;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfAdmission() {
        return dateOfAdmission;
    }

    public void setDateOfAdmission(Date dateOfAdmission) {
        this.dateOfAdmission = dateOfAdmission;
    }

    @Override
    public String toString() {
        return "Student [studentId = " + studentId + ", name = " + name + ", dateOfAdmission = " + dateOfAdmission
                + "]";
    }
}
