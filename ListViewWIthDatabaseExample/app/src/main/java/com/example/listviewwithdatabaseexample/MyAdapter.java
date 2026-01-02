package com.example.listviewwithdatabaseexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter<Product> {
    public MyAdapter(@NonNull Context context, ArrayList<Product> pList) {
        super(context, R.layout.list_item_layout, pList);
        this.context = context;
        this.pList = pList;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_layout, parent, false)

        }
        TextView txtCode = convertView.findViewById(R.id.txtCode);
        TextView txtName = convertView.findViewById(R.id.txtName);
        TextView txtQuantity = convertView.findViewById(R.id.txtQuantity);
        txtCode.setText(String.valueOf(pList.get(position).getpCode()));




    }
}