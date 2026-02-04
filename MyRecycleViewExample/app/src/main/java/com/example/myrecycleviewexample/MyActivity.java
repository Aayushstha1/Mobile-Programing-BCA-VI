package com.example.myrecylerviewexample;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyActivity extends AppCompatActivity {

    private Button btnRegister;
    private RecyclerView myRecyclerView;

    ArrayList<Student> list;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_activity_layout);

        btnRegister = findViewById(R.id.btnRegister);
        myRecyclerView = findViewById(R.id.myRecyclerView);

        list = new ArrayList<>();
        adapter = new MyAdapter(this, list);

        myRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        myRecyclerView.setAdapter(adapter);

        // Register new student
        btnRegister.setOnClickListener(v -> showEditDialog(null));
    }

    /**
     * If student == null => add new student
     * If student != null => update existing student
     */
    public void showEditDialog(Student student) {
        boolean isNew = (student == null);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(isNew ? "Register Student" : "Update Student");
        builder.setCancelable(true);

        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.student_form_layout, null, false);

        EditText editName = view.findViewById(R.id.editName);
        EditText editPhone = view.findViewById(R.id.editPhone);
        Button btnSubmit = view.findViewById(R.id.btnSubmit);

        // Pre-fill for update
        if (!isNew) {
            editName.setText(student.getName());
            editPhone.setText(student.getPhone());
        }

        builder.setView(view);

        AlertDialog dialog = builder.create();

        btnSubmit.setOnClickListener(v -> {
            String name = editName.getText().toString().trim();
            String phone = editPhone.getText().toString().trim();

            if (name.isEmpty()) {
                editName.setError("Name required");
                editName.requestFocus();
                return;
            }
            if (phone.isEmpty()) {
                editPhone.setError("Phone required");
                editPhone.requestFocus();
                return;
            }

            if (isNew) {
                Student s = new Student(name, phone);
                list.add(s);
                adapter.notifyItemInserted(list.size() - 1);
                Toast.makeText(this, "Student Registered", Toast.LENGTH_SHORT).show();
            } else {
                student.setName(name);
                student.setPhone(phone);
                int pos = list.indexOf(student);
                if (pos >= 0) adapter.notifyItemChanged(pos);
                else adapter.notifyDataSetChanged();
                Toast.makeText(this, "Student Updated", Toast.LENGTH_SHORT).show();
            }

            dialog.dismiss();
        });

        dialog.show();
    }

    public void showDeleteConfirm(int position) {
        if (position < 0 || position >= list.size()) return;

        new AlertDialog.Builder(this)
                .setTitle("Delete Student")
                .setMessage("Are you sure you want to delete this student?")
                .setCancelable(true)
                .setPositiveButton("Delete", (DialogInterface d, int which) -> {
                    list.remove(position);
                    adapter.notifyItemRemoved(position);
                    adapter.notifyItemRangeChanged(position, list.size());
                    d.dismiss();
                    Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show();
                })
                .setNegativeButton("Cancel", (d, which) -> d.dismiss())
                .show();
    }
}
