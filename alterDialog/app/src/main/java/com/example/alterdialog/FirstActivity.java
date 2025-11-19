package com.example.alterdialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity {
    Button btnExit , btnCalculator ;

    @Override
    protected  void onCreate(@Nullable Bundle saveInstanceState){
        super.OnCreate(saveInstanceState);
        setContentView(R.id.btnExit);
        btnExit.setOnClickListener(e->){
          //  finishAffinity();
        showDialBox();


        });

         btnCalculator.setOnClickListener(e-> {

             showCalculator();

         });
    }
    protected void showCalculator(){
        AlterDialog.Builder builder= new AlterDialog.Builder(this);
        builder.setTitle("Dialog Messege!");
        builder.setMessege("Application is going to sleep.");
        builder.setCancelable(true);
        builder.setPoaitiveButton("ok", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i ){
                dialogInterface.dismiss();
            }
                }
        );
        builder.setNegativeButton("NO " new DialogInterface.OnClickListener( ){
            @Override
        public void OnClick (DialogInterface dialogInterface, int i ){
                dialogInterface.dismiss();
            }
        });
        AlterDialog dialog = builder.create();
    }
}
