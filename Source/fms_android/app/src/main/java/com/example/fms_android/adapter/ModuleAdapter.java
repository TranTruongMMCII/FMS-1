package com.example.fms_android.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fms_android.R;
import com.example.fms_android.model.Module;

import java.util.ArrayList;

public class ModuleAdapter extends RecyclerView.Adapter<ModuleAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<Module> modules;

    public ModuleAdapter(Context context, ArrayList<Module> modules) {
        this.context = context;
        this.modules = modules;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.module_item, parent, false);
        return new MyViewHolder(view);
    }

    @NonNull
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Module module = modules.get(position);

        holder.txtAdminID.setText(module.getAdminID());
        holder.txtModuleID.setText(module.getModuleID());
        holder.txtEndDate.setText(module.getEndTime().toString());
        holder.txtStartDate.setText(module.getStartTime().toString());
        holder.txtFeedbackEndTime.setText(module.getFeedbackEndTime().toString());
        holder.txtFeedbackStartTime.setText(module.getFeedbackStartTime().toString());
        holder.txtFeedbackTitle.setText("Feedback title");
        holder.txtModuleName.setText(module.getModuleName());

    }

    @Override
    public int getItemCount() {
        if (modules != null){
            return modules.size();
        }
        return 0;
    }

    public ArrayList<Module> getModules() {
        return modules;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imgEdit, imgDelete;
        TextView txtModuleID, txtModuleName, txtAdminID, txtStartDate,
                txtEndDate, txtFeedbackTitle, txtFeedbackStartTime, txtFeedbackEndTime;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtAdminID = itemView.findViewById(R.id.txtAdminID);
            txtModuleID = itemView.findViewById(R.id.txtModuleID);
            txtModuleName = itemView.findViewById(R.id.txtModuleName);
            txtStartDate = itemView.findViewById(R.id.txtStartDate);
            txtEndDate = itemView.findViewById(R.id.txtEndDate);
            txtFeedbackTitle = itemView.findViewById(R.id.txtFeedbackTitle);
            txtFeedbackStartTime = itemView.findViewById(R.id.txtFeedbackStartTime);
            txtFeedbackEndTime = itemView.findViewById(R.id.txtFeedbackEndTime);
            imgEdit = itemView.findViewById(R.id.imgEdit);
            imgDelete = itemView.findViewById(R.id.imgDelete);
        }
    }
}
