package com.example.codingassignment;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class StudentModel {
    @PrimaryKey (autoGenerate = true)
    int id;
    String fullname;
    int nsuID;
    String nsuMail;
    int phoneNumber;
    String password;
    String schoolName;
    String departmentName;
    String dateOfBirth;
    int nid;
    String gender;
    String presentAddress;
    String permanentAddress;


    public StudentModel(int id, String fullname, int nsuID, String nsuMail, int phoneNumber, String password, String schoolName, String departmentName, String dateOfBirth, int nid, String gender, String presentAddress, String permanentAddress) {
        this.id = id;
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

    @Override
    public String toString() {
        return "StudentModel{" +
                "id=" + id +
                ", fullname='" + fullname + '\'' +
                ", nsuID=" + nsuID +
                ", nsuMail='" + nsuMail + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", password='" + password + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", nid=" + nid +
                ", gender='" + gender + '\'' +
                ", presentAddress='" + presentAddress + '\'' +
                ", permanentAddress='" + permanentAddress + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getNid() {
        return nid;
    }

    public void setNid(int nid) {
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
