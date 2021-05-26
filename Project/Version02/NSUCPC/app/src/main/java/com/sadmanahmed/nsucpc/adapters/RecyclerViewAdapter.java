package com.sadmanahmed.nsucpc.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sadmanahmed.nsucpc.R;
import com.sadmanahmed.nsucpc.models.JobModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    public ArrayList<JobModel> getAllJobs;
    public Context context;

    public RecyclerViewAdapter(ArrayList<JobModel> jobModel, Context context) {
        this.getAllJobs = jobModel;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_job_post, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerViewAdapter.MyViewHolder holder, int position) {
        JobModel jobModel = getAllJobs.get(position);
        holder.companyName.setText(String.valueOf(jobModel.companyName));
        holder.vacantPosition.setText(jobModel.vacantPosition);
        holder.deadline.setText(jobModel.deadline);
        holder.location.setText(jobModel.location);
    }

    @Override
    public int getItemCount() {
        return getAllJobs.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView companyName;
        TextView vacantPosition;
        TextView deadline;
        TextView location;
        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            companyName = itemView.findViewById(R.id.companyName_textView);
            vacantPosition = itemView.findViewById(R.id.vacant_position_textView);
            deadline = itemView.findViewById(R.id.deadLine_textView);
            location = itemView.findViewById(R.id.location_textView);
        }
    }
}
