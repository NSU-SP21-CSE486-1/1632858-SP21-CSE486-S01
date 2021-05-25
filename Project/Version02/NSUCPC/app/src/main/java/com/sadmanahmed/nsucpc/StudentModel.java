package com.sadmanahmed.nsucpc;

public class StudentModel {
    String fullname;
    int nsuID;
    String nsuMail;
    int phoneNumber;
    String password;
    String schoolName;
    String departmentName;
    String dateOfBirth;
    String  nid;
    String gender;
    String presentAddress;
    String permanentAddress;

    public StudentModel(String fullname, int nsuID, String nsuMail, int phoneNumber, String password, String schoolName, String departmentName, String dateOfBirth, String nid, String gender, String presentAddress, String permanentAddress) {
        this.fullname = fullname;
        this.nsuID = nsuID;
        this.nsuMail = nsuMail;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.schoolName = schoolName;
        this.departmentName = departmentName;
        this.dateOfBirth = dateOfBirth;
        this.nid = nid;
        this.gender = gender;
        this.presentAddress = presentAddress;
        this.permanentAddress = permanentAddress;
    }

    public StudentModel() {
    }


    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getNsuID() {
        return nsuID;
    }

    public void setNsuID(int nsuID) {
        this.nsuID = nsuID;
    }

    public String getNsuMail() {
        return nsuMail;
    }

    public void setNsuMail(String nsuMail) {
        this.nsuMail = nsuMail;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPresentAddress() {
        return presentAddress;
    }

    public void setPresentAddress(String presentAddress) {
        this.presentAddress = presentAddress;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }
}
