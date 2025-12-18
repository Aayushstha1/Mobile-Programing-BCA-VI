package com.example.grid_view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class MyAdapter extends ArrayAdapter<Student> {

    private Context context;
    private List<Student> list;

    public MyAdapter(@NonNull Context context, @NonNull List<Student> list) {
        super(context, R.layout.grid_item_layout, list);
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.grid_item_layout, parent, false);
        }

        // Get student
        Student s = list.get(position);

        // UI elements
        ImageView img = convertView.findViewById(R.id.img);
        TextView textView = convertView.findViewById(R.id.txtView);

        // Set data
        textView.setText(s.getName());
        img.setImageResource(s.getImageId());

        return convertView;
    }
}