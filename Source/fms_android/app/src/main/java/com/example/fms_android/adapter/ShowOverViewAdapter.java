package com.example.fms_android.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fms_android.model.QuestionOfTruong;

import java.util.ArrayList;

public class ShowOverViewAdapter extends RecyclerView.Adapter<ShowOverViewAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<QuestionOfTruong> questionOfTruongs;


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
            public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
