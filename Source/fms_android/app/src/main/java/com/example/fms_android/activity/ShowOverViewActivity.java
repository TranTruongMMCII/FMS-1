package com.example.fms_android.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fms_android.R;
import com.example.fms_android.model.QuestionOfTruong;

import java.util.ArrayList;

public class ShowOverViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private View view;
    private Button button;
    private ArrayList<QuestionOfTruong> questionOfTruongs;

    public static final ShowOverViewActivity getInstance(){
        return new ShowOverViewActivity();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showoverview);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.recyclerViewOverview);
        button = findViewById(R.id.btnShowOverview);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }
}
