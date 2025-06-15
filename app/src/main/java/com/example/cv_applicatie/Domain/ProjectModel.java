package com.example.cv_applicatie.Domain;

public class ProjectModel {
    final String projectname;
    final String projectDiscription;

    public String getConcrete_project_description_long() {
        return concrete_project_description_long;
    }

    private String concrete_project_description_long;
    final int image;

    public ProjectModel(String projectname, String projectDiscription, int image, String concrete_project_description_long) {
        this.projectname = projectname;
        this.projectDiscription = projectDiscription;
        this.image = image;
        this.concrete_project_description_long = concrete_project_description_long;
    }

    public String getProjectname() {
        return projectname;
    }

    public String getProjectDiscription() {
        return projectDiscription;
    }

    public int getImage() {
        return image;
    }
}
