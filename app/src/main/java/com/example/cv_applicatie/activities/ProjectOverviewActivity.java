package com.example.cv_applicatie.activities;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.cv_applicatie.R;
import com.example.cv_applicatie.models.ProjectModel;

import java.util.ArrayList;

public class ProjectOverviewActivity extends AppCompatActivity {

    ArrayList<ProjectModel> concreteProjects = new ArrayList<>();
    int[] projectImages = {
      R.drawable.weerstation,
            R.drawable.automatisch_geleid_voertuig,
            R.drawable.festival_planner,
            R.drawable.mobiele_beleving,
            R.drawable.remote_healthcare,
            R.drawable.mobile_systems,
            R.drawable.embedded_system,
            R.drawable.augmented_reality
    };
    String[] projectNames;
    String[] projectDescriptions;


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
    }

    private void defineProjectsFromValues() throws Exception {
        String[] projectNames = getResources().getStringArray(R.array.project_names);
        String[] projectDescriptions = getResources().getStringArray(R.array.short_description_projects);
        int projectCount;

        try {
            projectCount = checkAndFetchProjectCount();
        } catch (Exception e) {
            //TODO: generate toast explaning the situation
            return;
        }

        for (int i = 0; i < projectCount; i++) {
            concreteProjects.add(new ProjectModel(projectNames[i], projectDescriptions[i], projectImages[i]));
        }
    }

    private int checkAndFetchProjectCount() throws Exception {
        int lengthProjectNamesArray = this.projectNames.length;
        int lengthProjectDescriptionsArray = this.projectDescriptions.length;
        int lengthProjectImagesArray = this.projectImages.length;
        int projectCount;

        if (lengthProjectNamesArray != lengthProjectDescriptionsArray &&
                lengthProjectNamesArray != lengthProjectImagesArray){
            throw new Exception("Arrays aren't the same length. Can't map models correctly");
        }
        projectCount = lengthProjectNamesArray;
        return projectCount;
    }
}