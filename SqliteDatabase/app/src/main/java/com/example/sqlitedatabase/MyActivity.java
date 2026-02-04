package com.example.sqlitedatabase;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MyActivity  extends AppCompatActivity {

    EditText editTextText, editTextText2;
        TextView txtResult;
        Button button, button2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_activity_layout);
        editTextText findByIded(R.id.editTextText);
        editTextText2 = findViewById(R.id.editTextText2);
        txtResult = findViewById(R.id.textResult);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button.setOnClickListener(e->{

        });

        button2.setOnClickListener(e->{

        });

    }
}
