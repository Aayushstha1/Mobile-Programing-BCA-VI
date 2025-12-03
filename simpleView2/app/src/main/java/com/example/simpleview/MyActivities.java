package com.example.simpleview;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MyActivities extends AppCompatActivity {
    ListView myListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_activity_layout);
        myListView = findViewById(R.id.myListView);
        ArrayList<Student> stdList = new ArrayList<Student>();
        stdList.add(new Student("hari", "Damak", 1));
        stdList.add(new Student("Hem", "Itahari", 3));
        stdList.add(new Student("Ram", "Dang", 2));

        // Assuming you have a custom MyAdapter class
        // MyAdapter adapter = new MyAdapter(this, stdList);
        // myListView.setAdapter(adapter);
    }
} // This is the correct closing brace for the MyActivities class.
// The extra brace that was here has been removed.
