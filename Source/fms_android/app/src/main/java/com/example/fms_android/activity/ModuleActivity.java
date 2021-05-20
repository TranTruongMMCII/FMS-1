package com.example.fms_android.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fms_android.R;
import com.example.fms_android.service.ModuleService;
import com.example.fms_android.utility.APIUtility;

public class ModuleActivity extends AppCompatActivity {
    private EditText txtModuleName;
    private TextView txtStartDate, txtEndDate, txtStartDateError, txtEndDateError,
        txtFeedbackStartDate, txtFeedbackStartDateError, txtFeedbackEndDate,
        txtFeedbackEndDateError;
    private ImageView imgStartDate, imgEndDate, imgFeedbackStartDate,
        imgFeedbackEndDate;
    private Spinner spinnerAdmin, spinnerFeedbackTitle;
    private Button btnSave, btnCancel;
    private Intent intent;
    private ModuleService moduleService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        moduleService = APIUtility.getModuleService();
        intent = getIntent();

        initViews();
    }

    private void initViews() {
        txtModuleName = findViewById(R.id.txtModuleName);
        txtStartDate = findViewById(R.id.txtStartDate);
        txtEndDate = findViewById(R.id.txtEndDate);
        txtStartDateError = findViewById(R.id.txtStartDateError);
        txtEndDateError = findViewById(R.id.txtEndDateError);
        txtFeedbackStartDate = findViewById(R.id.txtFeedbackStartDate);
        txtFeedbackStartDateError = findViewById(R.id.txtFeedbackStartDateError);
        txtFeedbackEndDate = findViewById(R.id.txtFeedbackEndDate);
        txtFeedbackEndDateError = findViewById(R.id.txtFeedbackEndDateError);
        imgStartDate = findViewById(R.id.imgStartDate);
        imgEndDate = findViewById(R.id.imgEndDate);
        imgFeedbackStartDate = findViewById(R.id.imgFeedbackStartDate);
        imgFeedbackEndDate = findViewById(R.id.imgFeedbackEndDate);
        spinnerAdmin = findViewById(R.id.spinnerAdmin);
        spinnerFeedbackTitle = findViewById(R.id.spinnerFeedbackTitle);
        btnSave = findViewById(R.id.btnSave);
        btnCancel = findViewById(R.id.btnCancel);
    }
}
