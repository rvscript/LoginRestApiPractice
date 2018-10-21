package com.example.ga_mlsdiscovery.loginrestapi101.views.repositories;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ga_mlsdiscovery.loginrestapi101.R;
import com.example.ga_mlsdiscovery.loginrestapi101.models.GitHubRepo;

import java.util.List;

public class ReposAdapter extends RecyclerView.Adapter<ReposAdapter.ReposViewHolder> {
    private List<GitHubRepo> repos;
    private int rowLayout;
    private Context context;

    public List<GitHubRepo> getRepos() {
        return repos;
    }

    public void setRepos(List<GitHubRepo> repos) {
        this.repos = repos;
    }

    public int getRowLayout() {
        return rowLayout;
    }

    public void setRowLayout(int rowLayout) {
        this.rowLayout = rowLayout;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ReposAdapter(List<GitHubRepo> repos, int rowLayout, Context context) {
        this.repos = repos;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @NonNull
    @Override
    public ReposViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new ReposViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ReposViewHolder holder, int position) {
        final int currentPostion = position + 1;
        if (repos == null) {
            holder.tv_repoName.setText("No Repos Found");
            holder.tv_repoDescription.setText("No Repos Found");
            holder.tv_repoDescription.setText("No Repos Found");
        } else {
            holder.tv_repoName.setText(repos.get(position).getName());
            holder.tv_repoDescription.setText(repos.get(position).getDescription());
            holder.tv_repoLanguage.setText(repos.get(position).getLanguage());
        }

        holder.cv_repoCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "repo info " + currentPostion, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        if (repos == null || repos.size() <= 0) {
            return 0;
        } else {
            return repos.size();
        }
    }

    public static class ReposViewHolder extends RecyclerView.ViewHolder {
        LinearLayout root_reposLayout;
        TextView tv_repoName;
        TextView tv_repoDescription;
        TextView tv_repoLanguage;
        CardView cv_repoCardView;

        public ReposViewHolder(View v) {
            super(v);
            root_reposLayout = v.findViewById(R.id.root_list_item_repo);
            tv_repoName = v.findViewById(R.id.tv_repo_name);
            tv_repoDescription = v.findViewById(R.id.tv_repo_description);
            tv_repoLanguage = v.findViewById(R.id.tv_repo_language);
            cv_repoCardView = v.findViewById(R.id.cv_list_item_repo);
        }
    }
}
