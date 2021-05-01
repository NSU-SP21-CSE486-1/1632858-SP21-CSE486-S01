package com.example.firebasetest;

public class UserModel {
    String name;
    Integer age;

    public UserModel(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public UserModel() {
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
