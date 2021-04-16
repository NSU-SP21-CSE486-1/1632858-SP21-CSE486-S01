package com.example.codingassignment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter  extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    List<StudentModel> getAllStudentInfo;
    Context context;

    public RecyclerViewAdapter(List<StudentModel> getAllStudentInfo, Context context) {
        this.getAllStudentInfo = getAllStudentInfo;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_view_recyclerview, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.sNsuID.setText(String.valueOf(getAllStudentInfo.get(position).getNsuID()));
    }

    @Override
    public int getItemCount() {
        return getAllStudentInfo.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder  {
        TextView sNsuID;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            sNsuID = itemView.findViewById(R.id.show_ID);
        }
    }
}
