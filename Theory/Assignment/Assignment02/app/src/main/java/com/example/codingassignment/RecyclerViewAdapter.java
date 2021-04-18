package com.example.codingassignment;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class    RecyclerViewAdapter  extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    List<StudentModel> getAllStudentInfo;
    Context context;
    List<StudentModel> getSearchItem;

    public RecyclerViewAdapter(List<StudentModel> getAllStudentInfo, Context context) {
        this.getAllStudentInfo = getAllStudentInfo;
        this.context = context;
        this.getSearchItem = getAllStudentInfo;
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
        holder.sNsuID.setText(String.valueOf(getSearchItem.get(position).getNsuID()));

        Dialog myDialog = new Dialog(context);
        myDialog.setContentView(R.layout.popup_screen);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));



        holder.sNsuID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView dialog_Name = myDialog.findViewById(R.id.show_Name);
                TextView dialog_depName = myDialog.findViewById(R.id.show_dep);

                dialog_Name.setText(getSearchItem.get(holder.getAdapterPosition()).getFullname());
                dialog_depName.setText(getSearchItem.get(holder.getAdapterPosition()).getDepartmentName());

                myDialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return getSearchItem.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder  {
        TextView sNsuID;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            sNsuID = itemView.findViewById(R.id.show_ID);
        }
    }

    public Filter getSearchFilter(){

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence  charSequence ) {
                String key = charSequence.toString();
                if(key.isEmpty()){
                    getSearchItem = getAllStudentInfo;
                }
                else{
                    List<StudentModel> searchInput = new ArrayList<>();
                    for(StudentModel row: getAllStudentInfo){
                        if(String.valueOf(row.getNsuID()).toLowerCase().contains(key.toLowerCase())){
                            searchInput.add(row);
                        }
                    }
                    getSearchItem = searchInput;
                }
                FilterResults searchResult = new FilterResults();
                searchResult.values = getSearchItem;
                return searchResult;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults searchResults) {

                getSearchItem = (List<StudentModel>) searchResults.values;
                notifyDataSetChanged();

            }
        };
    }
}
