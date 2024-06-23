package com.example.cv_applicatie;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class Project_list_page extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_project_list_page, container, false);

        LinearLayout project1Layout = rootView.findViewById(R.id.project_1_layout);
        project1Layout.setOnClickListener(v -> {
            FragmentManager fragmentManager = getParentFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.fragmentContainerView, Project1.class,null);
            transaction.setReorderingAllowed(true);
            transaction.commit();

        });
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        LinearLayout project2Layout = rootView.findViewById(R.id.project_2_layout);
        project2Layout.setOnClickListener(v -> {
            FragmentManager fragmentManager = getParentFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.fragmentContainerView, Project2.class,null);
            transaction.setReorderingAllowed(true);
            transaction.commit();
        });
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        LinearLayout project3Layout = rootView.findViewById(R.id.project_3_layout);
        project3Layout.setOnClickListener(v -> {
            FragmentManager fragmentManager = getParentFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.add(R.id.fragmentContainerView, Project3.class,null);
            transaction.remove(this);
            transaction.setReorderingAllowed(true);
            transaction.commit();
        });
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        LinearLayout project4Layout = rootView.findViewById(R.id.project_4_layout);
        project4Layout.setOnClickListener(v -> {
            FragmentManager fragmentManager = getParentFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.add(R.id.fragmentContainerView, Project4.class,null);
            transaction.remove(this);
            transaction.setReorderingAllowed(true);
            transaction.commit();
        });
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        LinearLayout project5Layout = rootView.findViewById(R.id.project_5_layout);
        project5Layout.setOnClickListener(v -> {
            FragmentManager fragmentManager = getParentFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.add(R.id.fragmentContainerView, Project5.class,null);
            transaction.remove(this);
            transaction.setReorderingAllowed(true);
            transaction.commit();
        });



       return rootView;
    }
}