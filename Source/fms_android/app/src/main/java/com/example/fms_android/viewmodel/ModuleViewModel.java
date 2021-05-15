package com.example.fms_android.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.fms_android.model.Module;

import java.util.ArrayList;

public class ModuleViewModel extends AndroidViewModel {

    private MutableLiveData<ArrayList<Module>> moduleList;

    public ModuleViewModel(@NonNull Application application) {
        super(application);
    }
}
