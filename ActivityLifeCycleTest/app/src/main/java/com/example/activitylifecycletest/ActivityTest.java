package com.example.activitylifecycletest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

public class ActivityTest extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_activity);
        btnFirst=findViewById(R.id.btnFirst);
        Log.d("test" , "Activity created ");
        txtResult = findViewById(R.id.txtResult);
        btnFirst.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View view){
                Intent i= new Intent(ActivityTest.this.SecondActivity.class);
                i.putExtra("name" , "Aayush");
                i.putExtra("address", "Dharan");
               // startActivity(i);
                startActivityForResult( i, 1001);

            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode , int resultCode , Intent data){

        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==1001)
        {

            txtResult.setText("Hello "+ data.getStringExtra("name").toString()+", you live in ")+ data.getStringExtra("addr").toString());
        }
    }


    @Override
    protected void onResume(){
        super.onResume();
        Log.d("Test", "Activity Created.");
    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.d("Test", "Activity Stop.");
    }

    @Override
    protected void onPaused(){
        super.onPause();
        Log.d("Test", "Activity Paused.");
    }


}
