package com.example.user.myproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class DetailsProjectActivity extends AppCompatActivity {

    private static final String EXTRA_PROJECT_ID = "com.example.user.myproject.extras.EXTRA_PROJECT_ID";

    public static Intent getStartIntent(Context context, long projectId){
        return new Intent(context, DetailsProjectActivity.class).putExtra(EXTRA_PROJECT_ID, projectId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_project);
        long projectId = getIntent().getLongExtra(EXTRA_PROJECT_ID, 0);
        Project project = AppDatabase.getInstance(this).projectDao().getById(projectId);
        setTitle(project.getName());
    }
}
