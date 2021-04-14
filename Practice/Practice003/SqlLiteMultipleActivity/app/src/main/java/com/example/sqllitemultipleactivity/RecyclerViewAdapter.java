package com.example.sqllitemultipleactivity;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    List<StudentModel> getNames;
    Context context;

    public RecyclerViewAdapter(List<StudentModel> getNames, Context context) {
        this.getNames = getNames;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.mName.setText(getNames.get(position).getName());

        Dialog myDialog = new Dialog(context);
        myDialog.setContentView(R.layout.popup_screen);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));



        holder.mName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView dialog_Address = myDialog.findViewById(R.id.show_Address);
                TextView dialog_Number = myDialog.findViewById(R.id.show_phone);

                dialog_Address.setText(getNames.get(holder.getAdapterPosition()).getAddress());
                dialog_Number.setText(String.valueOf(getNames.get(holder.getAdapterPosition()).getPhoneNumber()));

//                Toast.makeText(context, "Test Click"+String.valueOf(holder.getAdapterPosition()), Toast.LENGTH_SHORT).show();
                myDialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return getNames.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mName = itemView.findViewById(R.id.show_name);
        }
    }

}
