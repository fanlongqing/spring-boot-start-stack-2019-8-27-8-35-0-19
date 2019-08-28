package com.tw.apistackbase.model;

import java.security.Provider;

public class Employee {
    private int employID;
    private String name;
    private  int age;
    private  String gender;

    public Employee(int i, String s, int age, String male) {
        this.employID=i;
        this.name=s;
        this.age=age;
        this.gender=male;
    }
    public Employee(){

    }
    public int getEmployID() {
        return employID;
    }

    public void setEmployID(int employID) {
        this.employID = employID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
