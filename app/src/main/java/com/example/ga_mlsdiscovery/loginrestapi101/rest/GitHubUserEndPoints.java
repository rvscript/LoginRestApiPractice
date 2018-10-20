package com.example.ga_mlsdiscovery.loginrestapi101.rest;

import com.example.ga_mlsdiscovery.loginrestapi101.models.GitHubUser;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubUserEndPoints {

    @GET("/users/{user}")
    Call<GitHubUser> getUser(@Path("user") String user);
}
