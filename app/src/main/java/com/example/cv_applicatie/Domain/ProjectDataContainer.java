package com.example.cv_applicatie.Domain;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cv_applicatie.R;

public class ProjectDataContainer extends AppCompatActivity {

    private final String placeholder_project_name = getResources().getString(R.string.placeholder_project_name);
    private final String placeholder_project_description_short = getResources().getString(R.string.placeholder_description_short);
    private final String placeholder_project_description_long = getResources().getString(R.string.placeholder_description_long);
    private final int placeholder_project_image = R.drawable.placeholder_image;

    private final String[] concrete_project_names = getResources().getStringArray(R.array.project_names);
    private final String[] concrete_project_description_short = getResources().getStringArray(R.array.short_description_projects);
    private final String[] concrete_project_descriptions_long = getResources().getStringArray(R.array.detailed_description_projects);
    private final int[] concrete_project_images = {
            R.drawable.weerstation,
            R.drawable.automatisch_geleid_voertuig,
            R.drawable.festival_planner,
            R.drawable.mobiele_beleving,
            R.drawable.remote_healthcare,
            R.drawable.mobile_systems,
            R.drawable.embedded_system,
            R.drawable.augmented_reality
    };

    public String getPlaceholder_project_name() {
        return placeholder_project_name;
    }

    public String getPlaceholder_project_description_short() {
        return placeholder_project_description_short;
    }

    public String getPlaceholder_project_description_long() {
        return placeholder_project_description_long;
    }

    public int getPlaceholder_project_image() {
        return placeholder_project_image;
    }

    public String[] getConcrete_project_names() {
        return concrete_project_names;
    }

    public String[] getConcrete_project_description_short() {
        return concrete_project_description_short;
    }

    public String[] getConcrete_project_descriptions_long() {
        return concrete_project_descriptions_long;
    }

    public int[] getConcrete_project_images() {
        return concrete_project_images;
    }
}
