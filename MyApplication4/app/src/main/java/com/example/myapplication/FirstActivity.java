package com.example.myapplication;
import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

public class FirstActivity  extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.first_activity);
    }
}
