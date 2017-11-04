package com.example.berylsystem;

public class DataProvider {

    private String name;
    private String rollno;

    public DataProvider(String name,String rollno)
    {
        this.name=name;
        this.rollno=rollno;
    }

    public String getName() {
        return name;
    }

    public String getRollno() {
        return rollno;
    }

    public void setRollno(String rollno) {
        this.rollno = rollno;
    }

    public void setName(String name) {
        this.name = name;
    }

}