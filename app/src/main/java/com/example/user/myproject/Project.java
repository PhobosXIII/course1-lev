package com.example.user.myproject;

import java.util.Objects;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "projects")
public class Project {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private String picture;
    private String name;
    private String description;
    private String actions;

    public Project(String picture, String name, String description, String actions) {
        this(0, picture, name, description, actions);
    }

    @Ignore
    public Project(long id, String picture, String name, String description, String actions) {
        this.id = id;
        this.picture = picture;
        this.name = name;
        this.description = description;
        this.actions = actions;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getActions() {
        return actions;
    }

    public void setActions(String actions) {
        this.actions = actions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return id == project.id &&
                Objects.equals(picture, project.picture) &&
                Objects.equals(name, project.name) &&
                Objects.equals(description, project.description) &&
                Objects.equals(actions, project.actions);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, picture, name, description, actions);
    }
}
