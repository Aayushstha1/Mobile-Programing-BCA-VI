package com.example.simpleview;

public class Student {
    private String name;
    private String address;
    private int roll;
    public Student(String name,String addr, int r){
        this.name=name;
        this.address=addr;
        roll=r;
    }
    public String getName(){return name;}
    public void setName(String name){this.name=name;}
    public String getAddress(){return address;}
    public void setAddress(String addr){address=addr;}
    public int getRoll(){return roll;}
    public  void setRoll(int roll){this.roll=roll;}
}