package com.assmob201.poly.assignment.model;

public class Course {
    String ID,name,des;

    public Course(String ID, String name, String des) {
        this.ID = ID;
        this.name = name;
        this.des = des;
    }

    public Course() {

    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
