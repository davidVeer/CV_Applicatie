package com.example.cv_applicatie.models;

public class ProjectModel {
    final String projectname;
    final String projectDiscription;
    final int image;

    public ProjectModel(String projectname, String projectDiscription, int image) {
        this.projectname = projectname;
        this.projectDiscription = projectDiscription;
        this.image = image;
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
