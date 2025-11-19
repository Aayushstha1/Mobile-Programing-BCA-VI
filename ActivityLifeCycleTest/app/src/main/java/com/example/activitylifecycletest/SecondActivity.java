package com.example.activitylifecycletest;
import static android.content.Intent.getIntent;

import  android .app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class SecondActivity  extends Activity {
    EditText editName , editAddress;
    Button btnSubmit;

    @Override
    protected void onCreated(@Nullable Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.second_layout);
        editName= findViewById(R.editName);
        editAddress= findById(R.id.editAddress);
        btnSubmit = findViewById(R.id.btnSubmit );
        Intent i =getIntent();
        editName.setText(i.getStringExtra("name"));
        editAddress.setText(i.getStringExtra("address"));
        btnSubmit.setOnClickListener(e-> {
           Intent newIntent = new Intent();
           newIntent.putExtra("name" , editName.getText().toString());
            newIntent.putExtra("addr" , editAddress.getText().toString());
            setResult(1001 , );
            finish();

        });

    }


}

