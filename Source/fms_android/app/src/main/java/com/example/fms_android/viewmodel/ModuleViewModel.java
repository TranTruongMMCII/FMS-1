package com.example.fms_android.viewmodel;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.fms_android.model.Module;
import com.example.fms_android.service.ModuleService;
import com.example.fms_android.utility.APIUtility;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModuleViewModel extends AndroidViewModel {
    private MutableLiveData<ArrayList<Module>> moduleList;
    private ModuleService moduleService;

    public ModuleViewModel(@NonNull Application application) {
        super(application);
        moduleService = APIUtility.getModuleService();
    }

    public MutableLiveData<ArrayList<Module>> getModuleList() {
        if (moduleList == null){
            moduleList = new MutableLiveData<>();
        }
        loadModule();

        return moduleList;
    }

    private void loadModule() {
        Call<ArrayList<Module>> call = moduleService.getAllModules();
        call.enqueue(new Callback<ArrayList<Module>>() {
            @Override
            public void onResponse(Call<ArrayList<Module>> call, Response<ArrayList<Module>> response) {
                moduleList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Module>> call, Throwable t) {
                Toast.makeText(getApplication().getBaseContext(), "Error: Module view model " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void deleteModule(long moduleID){
        Call<ResponseBody> call = moduleService.deleteModule(moduleID);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                loadModule();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getApplication().getBaseContext(), "Error: Module view model " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
