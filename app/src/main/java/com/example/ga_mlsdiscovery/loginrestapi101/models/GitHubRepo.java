package com.example.ga_mlsdiscovery.loginrestapi101.models;

import com.google.gson.annotations.SerializedName;

public class GitHubRepo {
    @SerializedName("name")
    String name;
    @SerializedName("description")
    String description;
    @SerializedName("language")
    String language;

    public GitHubRepo(String name, String description, String language) {

        this.name = name;
        this.description = description;
        this.language = language;
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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
