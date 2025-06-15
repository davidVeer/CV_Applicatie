package com.example.cv_applicatie.activities;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cv_applicatie.BusinessLogic.ProjectRecyclerviewAdapter;
import com.example.cv_applicatie.Domain.ProjectDataContainer;
import com.example.cv_applicatie.R;
import com.example.cv_applicatie.Domain.ProjectModel;

import java.util.ArrayList;

public class ProjectOverviewActivity extends AppCompatActivity {

    private ArrayList<ProjectModel> concreteProjects = new ArrayList<>();
    private String placeholder_project_name;
    private String placeholder_project_description_short;
    private String[] concrete_project_names;
    private String[] concrete_project_description_short;

    private final int placeholder_project_image = R.drawable.placeholder_image;
    private final int[] concrete_project_images = {
            R.drawable.weerstation,
            R.drawable.automatisch_geleid_voertuig,
            R.drawable.festival_planner,
            R.drawable.mobiele_beleving,
            placeholder_project_image,
            R.drawable.remote_healthcare,
            R.drawable.mobile_systems,
            R.drawable.embedded_system,
            R.drawable.augmented_reality

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_project_overview);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        this.placeholder_project_name = getResources().getString(R.string.placeholder_project_name);
        this.placeholder_project_description_short = getResources().getString(R.string.placeholder_description_short);
        this.concrete_project_names = getResources().getStringArray(R.array.project_names);
        this.concrete_project_description_short = getResources().getStringArray(R.array.short_description_projects);

        RecyclerView recyclerView = findViewById(R.id.ProjectsRecyclerview);
        defineProjectsFromValues();

        ProjectRecyclerviewAdapter recyclerviewAdapter = new ProjectRecyclerviewAdapter(this, concreteProjects);
        recyclerView.setAdapter(recyclerviewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    private void defineProjectsFromValues(){
        int projectCount;

        try {
            projectCount = checkAndFetchProjectCount();
        } catch (Exception e) {
            //TODO:io generate toast explaining the situation

                concreteProjects.add(new ProjectModel(
                        this.placeholder_project_name,
                        this.placeholder_project_description_short,
                        this.placeholder_project_image));
            return;
        }

        for (int i = 0; i < projectCount; i++) {
            concreteProjects.add(new ProjectModel(concrete_project_names[i], concrete_project_description_short[i], concrete_project_images[i]));
        }
    }

    private int checkAndFetchProjectCount() throws ArrayIndexOutOfBoundsException {
        int lengthProjectNamesArray = concrete_project_names.length;
        int lengthProjectDescriptionsArray = concrete_project_description_short.length;
        int lengthProjectImagesArray = concrete_project_images.length;
        int projectCount;

        if (lengthProjectNamesArray != lengthProjectDescriptionsArray ||
                lengthProjectNamesArray != lengthProjectImagesArray){
            throw new ArrayIndexOutOfBoundsException("Arrays aren't the same length. Can't map (all) models correctly");
        }
        projectCount = lengthProjectNamesArray;
        return projectCount;
    }

}