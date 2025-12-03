package com.example.grid_view;

public class Student {
    int imageId;
    String name ;
    public Student(int imageId, String n) {
        imageId=imageId;
        name=n;

    }
    public int getImageId() {return imageId;}

    public void setImageId(int imageId) {
        imageId=imgid ;
        }
    public String getName() {
        return name;
    }
    public void setName(String n) {
        name=n;
    }
}
