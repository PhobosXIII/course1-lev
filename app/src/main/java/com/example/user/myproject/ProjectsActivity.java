package com.example.user.myproject;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ProjectsActivity extends AppCompatActivity {

    ProjectAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initList();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            final Intent intent = AddProjectActivity.getStartIntent(this);
            startActivity(intent);
        });
    }

    private void initList() {
        RecyclerView rvPersons = findViewById(R.id.rvPersons);
        rvPersons.setHasFixedSize(true);
        rvPersons.setLayoutManager(new LinearLayoutManager(this));
        rvPersons.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        List<Project> projects = AppDatabase.getInstance(this).projectDao().getAll();
        adapter = new ProjectAdapter(projects, project -> {
            final Intent intent = DetailsProjectActivity.getStartIntent(this, project.getId());
            startActivity(intent);
        });
        rvPersons.setAdapter(adapter);
    }
}
