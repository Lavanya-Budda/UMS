package com.university.responce;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


public class StudentDetails {

    private long studId;
    private String sName;
    private String email;
    private String phoneNumber;
    private String university;
    private String branch;

    public StudentDetails() {
    }

    public StudentDetails(long studId, String sName, String email, String phoneNumber, String university, String branch) {
        this.studId = studId;
        this.sName = sName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.university = university;
        this.branch = branch;
    }

    public long getStudId() {
        return studId;
    }

    public void setStudId(long studId) {
        this.studId = studId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
}
