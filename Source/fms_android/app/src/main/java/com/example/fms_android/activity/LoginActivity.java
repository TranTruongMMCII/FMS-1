package com.example.fms_android.activity;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fms_android.AppExecutors;
import com.example.fms_android.Constants;
import com.example.fms_android.R;
import com.example.fms_android.model.Admin;
import com.example.fms_android.model.Trainee;
import com.example.fms_android.model.Trainer;
import com.example.fms_android.service.AdminService;
import com.example.fms_android.service.TraineeService;
import com.example.fms_android.service.TrainerService;
import com.example.fms_android.utility.APIUtility;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private static LoginActivity instance;
    private EditText txtUsername, txtPassword;
    private TextView txtUsernameError, txtPasswordError;
    private Spinner spinnerRole;
    private CheckBox chkRememberPassword;
    private Button btnLogin;
    private AdminService adminService;
    private TraineeService traineeService;
    private TrainerService trainerService;

    public static final LoginActivity getInstance() {
        return instance == null ? new LoginActivity() : instance;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();
        initViews();

        adminService = APIUtility.getAdminService();
        traineeService = APIUtility.getTraineeService();
        trainerService = APIUtility.getTrainerService();
    }

    private void initViews() {
        txtUsername = findViewById(R.id.txtUsername);
        txtPassword = findViewById(R.id.txtPassword);
        txtUsernameError = findViewById(R.id.txtUsernameError);
        txtPasswordError = findViewById(R.id.txtPasswordError);
        spinnerRole = findViewById(R.id.spinnerRole);
        chkRememberPassword = findViewById(R.id.chkRememberPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onLoginButtonClicked();
            }
        });

        chkRememberPassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (chkRememberPassword.isChecked()){
                    Constants.rememberPassword = 1;
                }
                else {
                    Constants.rememberPassword = 30;
                }
            }
        });
    }

    private void failLogin() {
        Builder builder = new Builder(LoginActivity.this);
        builder.setTitle(getString(R.string.announcement));
        builder.setMessage(getString(R.string.wronglogin));
        builder.setIcon(R.drawable.baseline_priority_high_black_18dp);
        builder.setPositiveButton(getString(R.string.ok), (dialogInterface, i) -> {

        });
        builder.setCancelable(false);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void onLoginButtonClicked() {

//        AppExecutors.getInstance().getNetworkIO().execute(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        });

        if (validateInput()) {
            int pos = spinnerRole.getSelectedItemPosition();
            String user = txtUsername.getText().toString();
            String password = txtPassword.getText().toString();
            final boolean[] isFound = {false};
            if (pos == 0) {
                Call<Admin> adminCall = adminService.getAdmin(user, password);

                adminCall.enqueue(new Callback<Admin>() {
                    @Override
                    public void onResponse(Call<Admin> call, Response<Admin> response) {
                        finish();
                    }

                    @Override
                    public void onFailure(Call<Admin> call, Throwable t) {
                        failLogin();
                    }
                });
            } else if (pos == 1) {
                Call<Trainer> trainerCall = trainerService.getAnswersByUsername(user);
                trainerCall.enqueue(new Callback<Trainer>() {
                    @Override
                    public void onResponse(Call<Trainer> call, Response<Trainer> response) {
                        if (response.isSuccessful()) {
                            Trainer trainer = response.body();
                            if (trainer.getPassword().equals(password)) {
                                finish();
                            } else {
                                failLogin();
                            }
                        } else {
                            failLogin();
                        }
                    }

                    @Override
                    public void onFailure(Call<Trainer> call, Throwable t) {
                        failLogin();
                    }
                });
            } else {
                Call<Trainee> traineeCall = traineeService.getAnswersByUsername(user);
                traineeCall.enqueue(new Callback<Trainee>() {
                    @Override
                    public void onResponse(Call<Trainee> call, Response<Trainee> response) {
                        if (response.isSuccessful()) {
                            Trainee trainee = response.body();
                            if (trainee.getPassword().equals(password)) {
                                finish();
                            } else {
                                failLogin();
                            }
                        } else {
                            failLogin();
                        }
                    }

                    @Override
                    public void onFailure(Call<Trainee> call, Throwable t) {
                        failLogin();
                    }
                });
            }
        }
    }

    private boolean validateInput() {
        txtPasswordError.setVisibility(View.INVISIBLE);
        txtUsernameError.setVisibility(View.INVISIBLE);

        boolean _isSuccess = true;

        if (TextUtils.isEmpty(txtUsername.getText())) {
            txtUsernameError.setText(getText(R.string.usernamenotempty));
            txtUsernameError.setVisibility(View.VISIBLE);
            _isSuccess = false;
        }

        if (TextUtils.isEmpty(txtPassword.getText())) {
            txtPasswordError.setText(getText(R.string.passwordnotempty));
            txtPasswordError.setVisibility(View.VISIBLE);
            _isSuccess = false;
        }

        if (txtUsername.getText().toString().contains(" ")) {
            txtUsernameError.setText(getText(R.string.blankusername));
            txtUsernameError.setVisibility(View.VISIBLE);
            _isSuccess = false;
        }

        return _isSuccess;
    }
}
