package com.example.fms_android.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fms_android.R;
import com.example.fms_android.activity.ModuleActivity;
import com.example.fms_android.adapter.ModuleAdapter;
import com.example.fms_android.model.Module;
import com.example.fms_android.viewmodel.ModuleViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ModuleFragment extends Fragment {
    private View view;
    private RecyclerView recyclerView;
    private FloatingActionButton fabAdd;
    private ModuleViewModel moduleViewModel;
    private ArrayList<Module> modules;
    private ModuleAdapter moduleAdapter;

    public static ModuleFragment getInstance(){return new ModuleFragment();}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_module, container, false);

        moduleViewModel = ViewModelProviders.of(this).get(ModuleViewModel.class);

        recyclerView = view.findViewById(R.id.recyclerViewModuleList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        fabAdd = view.findViewById(R.id.fabAdd);
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), ModuleActivity.class));
            }
        });

        modules = new ArrayList<>();
        moduleAdapter = new ModuleAdapter(getContext(), modules);

        recyclerView.setAdapter(moduleAdapter);

        return view;
    }

    private void retrieveTasks(){
        moduleViewModel.getModuleList().observe(getViewLifecycleOwner(), modules1 -> {
            modules.clear();
            modules.addAll(modules1);
            moduleAdapter.notifyDataSetChanged();
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        retrieveTasks();
    }
}
