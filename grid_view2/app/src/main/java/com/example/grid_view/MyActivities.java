package com.example.grid_view;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MyActivities extends AppCompatActivity {
    GridView myGridView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_activities_layout);
        myGridView = findViewById(R.id.myGridView);

        ArrayList<Student> list = new ArrayList<Student>();
        list.add(new Student(R.mipmap.ic_launcher, "Shyam"));
        list.add(new Student(R.mipmap.ic_launcher, "Manish"));
        list.add(new Student(R.mipmap.ic_launcher, "Parvat"));
        list.add(new Student(R.mipmap.ic_launcher, "Hari"));
        list.add(new Student(R.mipmap.ic_launcher, "Rohan"));
        list.add(new Student(R.mipmap.ic_launcher, "Navin"));
        list.add(new Student(R.mipmap.ic_launcher, "Ram"));
        list.add(new Student(R.mipmap.ic_launcher, "HomaNath"));

//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.grid_item_layout, R.id.txtName);
        MyAdapter adapter = new MyAdapter(this, list);
        myGridView.setAdapter(adapter);

    }
}
