package com.example.ga_mlsdiscovery.loginrestapi101.views.repositories;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.example.ga_mlsdiscovery.loginrestapi101.R;
import com.example.ga_mlsdiscovery.loginrestapi101.models.GitHubRepo;
import com.example.ga_mlsdiscovery.loginrestapi101.rest.ApiClient;
import com.example.ga_mlsdiscovery.loginrestapi101.rest.GitHubUserEndPoints;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repositories extends AppCompatActivity {
    String receivedUserName;
    TextView tv_userName;
    RecyclerView rv_RecyclerView;
    List<GitHubRepo> myDataSource = new ArrayList<>();
    RecyclerView.Adapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repositories);

        Bundle extras = getIntent().getExtras();

        receivedUserName = extras != null ? extras.getString("username") : null;
        tv_userName = findViewById(R.id.tv_username);
        tv_userName.setText("user: "+receivedUserName);

        rv_RecyclerView = findViewById(R.id.rv_repos);
        rv_RecyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new ReposAdapter(myDataSource, R.layout.list_item_repo, getApplicationContext());
        rv_RecyclerView.setAdapter(myAdapter);

        if(!tv_userName.getText().toString().isEmpty()) {
            loadRepositories();
        } else {
            tv_userName.setText("NO Username defined");
        }

    }

    private void loadRepositories() {
        final GitHubUserEndPoints apiService = ApiClient.getClient().create(GitHubUserEndPoints.class);
        Call<List<GitHubRepo>> call = apiService.getRepo(receivedUserName);
        call.enqueue(new Callback<List<GitHubRepo>>() {
            @Override
            public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {
               myDataSource.clear();
               myDataSource.addAll(response.body());
               myAdapter.notifyDataSetChanged();
                for(GitHubRepo g: myDataSource){
                    Log.i("GitHubRepo", "onResponse: "+g.getName());
                }
            }

            @Override
            public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {
                Log.e("Repos", t.toString());
            }
        });
    }
}
