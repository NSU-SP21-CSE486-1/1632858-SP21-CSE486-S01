package com.sadmanahmed.nsucpc.models;

public class JobModel {
    public String companyName;
    public String isNameHidden;
    public String vacantPosition;
    public String location;
    public int employeeNeeded;
    public String deadline;
    public String depName;
    public String jobType;
    public String recruiterEmail;
    public int minSalary;
    public int maxSalary;
    public String isSalaryNegotiable;
    public String name;
    public String uri;

    public JobModel(String companyName, String isNameHidden, String vacantPosition, String location, int employeeNeeded, String deadline, String depName, String jobType, String recruiterEmail, int minSalary, int maxSalary, String isSalaryNegotiable, String name, String uri) {
        this.companyName = companyName;
        this.isNameHidden = isNameHidden;
        this.vacantPosition = vacantPosition;
        this.location = location;
        this.employeeNeeded = employeeNeeded;
        this.deadline = deadline;
        this.depName = depName;
        this.jobType = jobType;
        this.recruiterEmail = recruiterEmail;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.isSalaryNegotiable = isSalaryNegotiable;
        this.name = name;
        this.uri = uri;
    }

    public JobModel() {
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getIsNameHidden() {
        return isNameHidden;
    }

    public void setIsNameHidden(String isNameHidden) {
        this.isNameHidden = isNameHidden;
    }

    public String getVacantPosition() {
        return vacantPosition;
    }

    public void setVacantPosition(String vacantPosition) {
        this.vacantPosition = vacantPosition;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getEmployeeNeeded() {
        return employeeNeeded;
    }

    public void setEmployeeNeeded(int employeeNeeded) {
        this.employeeNeeded = employeeNeeded;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getRecruiterEmail() {
        return recruiterEmail;
    }

    public void setRecruiterEmail(String recruiterEmail) {
        this.recruiterEmail = recruiterEmail;
    }

    public int getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(int minSalary) {
        this.minSalary = minSalary;
    }

    public int getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(int maxSalary) {
        this.maxSalary = maxSalary;
    }

    public String getIsSalaryNegotiable() {
        return isSalaryNegotiable;
    }

    public void setIsSalaryNegotiable(String isSalaryNegotiable) {
        this.isSalaryNegotiable = isSalaryNegotiable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
