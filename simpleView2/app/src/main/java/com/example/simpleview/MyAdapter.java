

    import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

    public class MyAdapter extends ArrayAdapter<Student> {
        Context context;
        ArrayList<Student> stdList;

        public MyAdapter(@NonNull Context context,ArrayList<Student> stdList){
            super(context,R.layout.lidt_item_layout, stdList);
            this.context=context;
            this.stdList=stdList;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            Student s= getItem(position);
            if(convertView==null){
                convertView= LayoutInflater.from(context).inflate((R.layout.lidt_item_layout), parent,false);
            }
            TextView txtName=convertView.findViewById(R.id.txtName);
            TextView txtAddress= convertView.findViewById(R.id.txtAddress);
            TextView txtRoll= convertView.findViewById(R.id.txtRoll);
            txtName.setText(s.getName());
            txtAddress.setText(s.getAddress());
            txtRoll.setText(String.valueOf(s.getRoll()));
            return convertView;
        }
    }



}
