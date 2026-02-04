package com.example.apiexample;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.PixelCopy;

import androidx.annotation.Nullable;

import org.json.JSONArray;

import java.lang.reflect.Array;

public class MyActivity extends Activity {
    @Override
    protected  void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_layout);
}
protected  void loadData(){
    Array<Friend>  list = new Array<Friend>();
    string url = "https://friendList.lunaritsolution.com/api/friiendList";
    Request queue = Volley.newRequestQueue(this);
    JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET,url,null, new Response.Listener<JSONArray>() {
        @Override
        public void onResponse(JSONArray jsonArray) {
            Log.d("Response", jsonArray.toString());
        }
        },



)) {

    }
}