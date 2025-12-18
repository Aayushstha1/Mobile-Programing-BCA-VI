package com.example.myrecylerviewexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.DialogInterface;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myrecycleviewexample.Student;

import java.util.ArrayList;

public class MyActivity extends AppCompatActivity {
    Button btnRegister;
    RecyclerView myRecyclerView;
    ArrayList<Student> list=new ArrayList<>();
    MyAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_activity_layout);
        btnRegister = findViewById(R.id.btnRegister);
        myRecyclerView = findViewById(R.id.myRecyclerView);
        layoutManager = new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(layoutManager);
        list.add(new Student("Ram", "9807654321"));
//        list.add(new Student("Hem", "97088843244"));
        adapter = new MyAdapter(this, list);
        myRecyclerView.setAdapter(adapter);
        btnRegister.setOnClickListener(e -> {
            shoeEditDialog(new Student("", ""));
        });
    }
    public void shoeEditDialog(Student s){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater=LayoutInflater.from(this);
        View v=inflater.inflate(R.layout.student_form_layout,null,false);
        EditText editName=v.findViewById(R.id.editName);
        EditText editPhone=v.findViewById(R.id.editPhone);
        editName.setText(s.getName());
        editPhone.setText(s.getPhone());
        Button btnSubmit=v.findViewById(R.id.btnSubmit);

        if(s.getName().equals("")) {
            builder.setTitle("Register Student");

        }else {
            builder.setTitle("Update Student");

        }
        builder.setCancelable(true);
        builder.setView(v);
        AlertDialog dialog=builder.create();
        btnSubmit.setOnClickListener(e->{
            if (s.getName().equals(""))
            {
                s.setName(editName.getText().toString());
                s.setPhone(editPhone.getText().toString());
                list.add(s);
                Toast.makeText(MyActivity.this,"Student registered successfully",Toast.LENGTH_LONG).show();
                dialog.dismiss();
            }else {
                s.setName(editName.getText().toString());
                s.setPhone(editPhone.getText().toString());
                Toast.makeText(MyActivity.this, "Student update successfully", Toast.LENGTH_LONG).show();
                dialog.dismiss();
            }
            adapter.notifyDataSetChanged();
        });
        dialog.show();
    }
    public void showRemoveDialog(Student s){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Remove Student");
        builder.setCancelable(false);
        builder.setMessage("Are you sure to remove this student?");
        AlertDialog dialog=builder.create();
        builder.setPositiveButton("Yes", (dialog1, which) -> {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                list.remove(position);
                adapter.notifyDataSetChanged();
                dialog.dismiss();

            }


        });
        dialog.show();
    }


}