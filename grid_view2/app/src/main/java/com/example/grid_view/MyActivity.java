package com.example.grid_view;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MyActivity extends AppCompatActivity {
    GridView mygridView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_activities_layout);
        mygridView=findViewById(R.id.myGridView);
        String[]list={new Student(new Student(R.mipmap.ic_launcher,"Ram), new Student(R.mipmap.ic_launcher,"shyam"), new Student(R.mipmap.ic_launcher,"Hari"), new Student(R.mipmap.ic_launcher,"Sita"), new Student(R.mipmap.ic_launcher,"Gita"),
        }
//{"Ram", "shyam","Hari", "Sita","Gita","Rita","Suman"," Jiwan","Sohan","Roshan","Mohan"};
//        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,R.layout.grid_item_layout, R.id.txtName, list);
//        mygridView.setAdapter(adapter);
        MyAdapter adapter = new MyAdapter(this,list );
    }

}