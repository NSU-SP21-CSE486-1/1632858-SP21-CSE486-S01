package com.example.firebasetest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{
    ArrayList<UserModel> getNames;
    Context context;

    public RecyclerViewAdapter(ArrayList<UserModel> getNames, Context context) {
        this.getNames = getNames;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_row, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        UserModel userModel = getNames.get(position);
        holder.mNames.setText(userModel.getName());
    }

    @Override
    public int getItemCount() {
        return getNames.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mNames;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mNames = itemView.findViewById(R.id.show_name_textview);
        }
    }
}
