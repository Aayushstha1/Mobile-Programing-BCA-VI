package com.example.myrecylerviewexample;

public class Student {
    private String name;
    private  String phone;
    public Student(String n, String p){
        name=n;
        phone=p;
    }
    public void setName(String n){name=n;}
    public String getName(){return name;}
    public void setPhone(String p){phone=p;}
    public  String getPhone(){return  phone;}

}