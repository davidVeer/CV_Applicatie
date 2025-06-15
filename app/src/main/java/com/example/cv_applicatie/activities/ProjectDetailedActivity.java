package com.example.cv_applicatie.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.cv_applicatie.R;

public class ProjectDetailedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_project_detailed);

        Intent intent = getIntent();
        String name = intent.getStringExtra("Name");
        String description = intent.getStringExtra("description");
        int image = intent.getIntExtra("image", R.drawable.placeholder_image);

        TextView nameTextview = findViewById(R.id.detailedProjectTitleTextView);
        TextView descriptionTextview = findViewById(R.id.detailedProjectDescriptionTextView);
        ImageView imageview = findViewById(R.id.detailedProjectImageView);

        nameTextview.setText(name);
        descriptionTextview.setText(description);
        imageview.setImageResource(image);



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}