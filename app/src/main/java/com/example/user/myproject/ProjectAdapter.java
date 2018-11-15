package com.example.user.myproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.ProjectViewHolder>{
    private List<Project> projects;
    private OnItemClickListener itemClickListener;

    public ProjectAdapter(List<Project> projects, OnItemClickListener itemClickListener) {
        this.projects = projects;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public ProjectViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_project, viewGroup, false);
        return new ProjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectViewHolder projectViewHolder, int position) {
        projectViewHolder.bind(projects.get(position), itemClickListener);
    }

    @Override
    public int getItemCount() {
        return projects == null ? 0 : projects.size();
    }

    public void add(Project project){
        projects.add(project);
        notifyDataSetChanged();
    }

    public void update(List<Project> projects){
        this.projects.clear();
        this.projects.addAll(projects);
        notifyDataSetChanged();
    }

    public interface OnItemClickListener {
        void onItemClick(Project project);
    }

    public static class ProjectViewHolder extends RecyclerView.ViewHolder{

        ImageView ivAvatar;
        TextView tvName;

        public ProjectViewHolder(@NonNull View itemView) {
            super(itemView);
            ivAvatar = itemView.findViewById(R.id.ivPicture);
            tvName = itemView.findViewById(R.id.tvName);
        }

        public void bind(final Project project, final OnItemClickListener itemClickListener){
            itemView.setOnClickListener(v -> itemClickListener.onItemClick(project));

            Picasso.get().load(project.getPicture())
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)
                    .fit()
                    .centerCrop()
                    .into(ivAvatar);
            tvName.setText(project.getName());
        }
    }

}