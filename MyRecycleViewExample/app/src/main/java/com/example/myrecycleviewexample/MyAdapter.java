package com.example.myrecylerviewexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private final Context context;
    private final ArrayList<Student> list;

    public MyAdapter(Context context, ArrayList<Student> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context)
                .inflate(R.layout.recycler_item_layout, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Student s = list.get(position);

        holder.txtName.setText(s.getName());
        holder.txtPhone.setText(s.getPhone());

        holder.btnEdit.setOnClickListener(v -> {
            if (context instanceof MyActivity) {
                ((MyActivity) context).showEditDialog(s);
            }
        });

        holder.btnDelete.setOnClickListener(v -> {
            if (context instanceof MyActivity) {
                ((MyActivity) context).showDeleteConfirm(holder.getAdapterPosition());
            } else {
                // fallback delete (no confirm)
                int pos = holder.getAdapterPosition();
                if (pos != RecyclerView.NO_POSITION) {
                    list.remove(pos);
                    notifyItemRemoved(pos);
                    notifyItemRangeChanged(pos, list.size());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtPhone;
        Button btnEdit, btnDelete;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtPhone = itemView.findViewById(R.id.txtPhone);
            btnEdit = itemView.findViewById(R.id.btnEdit);
            btnDelete = itemView.findViewById(R.id.btnDelete);
        }
    }
}
