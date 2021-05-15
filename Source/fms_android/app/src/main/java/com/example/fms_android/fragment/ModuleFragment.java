package com.example.fms_android.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fms_android.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ModuleFragment extends Fragment {
    private View view;
    private RecyclerView recyclerView;
    private FloatingActionButton fabAdd;

    public static ModuleFragment getInstance(){return new ModuleFragment();}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_module, container, false);

        return view;
    }
}
