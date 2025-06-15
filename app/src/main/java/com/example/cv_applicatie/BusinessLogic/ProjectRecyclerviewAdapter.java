package com.example.cv_applicatie.BusinessLogic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cv_applicatie.Domain.ProjectModel;
import com.example.cv_applicatie.R;

import java.util.ArrayList;

public class project_RecyclerviewAdapter extends RecyclerView.Adapter<project_RecyclerviewAdapter.ProjectViewHolder> {

    private final Context context;
    private final ArrayList<ProjectModel> projectsForRecyclerView;

    public project_RecyclerviewAdapter(Context context, ArrayList<ProjectModel> projectsForRecyclerView) {
        this.context = context;
        this.projectsForRecyclerView = projectsForRecyclerView;
    }

    @NonNull
    @Override
    public project_RecyclerviewAdapter.ProjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        View view = layoutInflater.inflate(R.layout.project_recycler_view_row, parent, false);

        return new project_RecyclerviewAdapter.ProjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull project_RecyclerviewAdapter.ProjectViewHolder holder, int position) {
        holder.projectNameTextView.setText(projectsForRecyclerView.get(position).getProjectname());
        holder.projectDescriptionTextView.setText(projectsForRecyclerView.get(position).getProjectDiscription());
        holder.projectImageView.setImageResource(projectsForRecyclerView.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return projectsForRecyclerView.size();
    }

    public static class ProjectViewHolder extends RecyclerView.ViewHolder{

        ImageView projectImageView;
        TextView projectNameTextView,projectDescriptionTextView;

        public ProjectViewHolder(@NonNull View itemView) {
            super(itemView);

            projectImageView = itemView.findViewById(R.id.project_image_view);
            projectNameTextView = itemView.findViewById(R.id.overview_project_name_textview);
            projectDescriptionTextView = itemView.findViewById(R.id.overview_project_description_textview);
        }
    }
}
