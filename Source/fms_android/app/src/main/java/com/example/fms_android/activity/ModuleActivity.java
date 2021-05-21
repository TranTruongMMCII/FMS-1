package com.example.fms_android.activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fms_android.R;
import com.example.fms_android.service.ModuleService;
import com.example.fms_android.utility.APIUtility;

import java.util.Calendar;

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
    private int lastSelectedYear;
    private int lastSelectedMonth;
    private int lastSelectedDayOfMonth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        moduleService = APIUtility.getModuleService();
        intent = getIntent();

        final Calendar c = Calendar.getInstance();
        this.lastSelectedYear = c.get(Calendar.YEAR);
        this.lastSelectedMonth = c.get(Calendar.MONTH);
        this.lastSelectedDayOfMonth = c.get(Calendar.DAY_OF_MONTH);

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

        imgEndDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        txtEndDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                    }
                };

                DatePickerDialog datePickerDialog = null;

                datePickerDialog = new DatePickerDialog(ModuleActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_NoActionBar,
                        dateSetListener, lastSelectedYear, lastSelectedMonth, lastSelectedDayOfMonth);
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
                datePickerDialog.show();
            }
        });

        imgStartDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        txtStartDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                    }
                };

                DatePickerDialog datePickerDialog = null;

                datePickerDialog = new DatePickerDialog(ModuleActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_NoActionBar,
                        dateSetListener, lastSelectedYear, lastSelectedMonth, lastSelectedDayOfMonth);
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
                datePickerDialog.show();
            }
        });
    }
}
