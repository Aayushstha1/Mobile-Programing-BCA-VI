package com.example.listviewwithdatabaseexample;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity  extends AppCompatActivity {
        Button btnInsert;
        ListView pListView;
        ArrayList<Product> pList= new ArrayList<product>();
        ProductAdapter adapter;
        DbHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_layout);
    }

}
