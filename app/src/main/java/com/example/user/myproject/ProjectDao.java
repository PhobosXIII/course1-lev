package com.example.user.myproject;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface ProjectDao {

    @Query("SELECT * FROM projects")
    List<Project> getAll();

    @Query("SELECT * FROM projects WHERE id = :id")
    Project getById(long id);

    @Insert
    long insertProject(Project project);
}
