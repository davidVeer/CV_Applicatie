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

    final ProjectDataContainer projectDataContainer = new ProjectDataContainer();
    ArrayList<ProjectModel> concreteProjects = new ArrayList<>();
    int[] projectImages = projectDataContainer.getConcrete_project_images();
    String[] projectNames = projectDataContainer.getConcrete_project_names();
    String[] projectDescriptions = projectDataContainer.getConcrete_project_description_short();


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
        RecyclerView recyclerView = findViewById(R.id.ProjectsRecyclerview);
        defineProjectsFromValues();

        ProjectRecyclerviewAdapter recyclerviewAdapter = new ProjectRecyclerviewAdapter(this, concreteProjects);
        recyclerView.setAdapter(recyclerviewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void defineProjectsFromValues(){
        String[] projectNames = getResources().getStringArray(R.array.project_names);
        String[] projectDescriptions = getResources().getStringArray(R.array.short_description_projects);

        int projectCount;

        try {
            projectCount = checkAndFetchProjectCount();
        } catch (Exception e) {
            //TODO:io generate toast explaining the situatn

            concreteProjects.add(new ProjectModel(
                    projectDataContainer.getPlaceholder_project_name(),
                    projectDataContainer.getPlaceholder_project_description_short(),
                    projectDataContainer.getPlaceholder_project_image()));

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
            throw new ArrayIndexOutOfBoundsException("Arrays aren't the same length. Can't map (all) models correctly");
        }
        projectCount = lengthProjectNamesArray;
        return projectCount;
    }
}