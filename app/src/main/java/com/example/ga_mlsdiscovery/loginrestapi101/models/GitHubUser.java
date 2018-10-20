package com.example.ga_mlsdiscovery.loginrestapi101.models;

import android.os.Parcel;
import android.os.Parcelable;

public class GitHubUser implements Parcelable {
    String email, avatar, following, followers, name, login;

    public GitHubUser(String email, String avatar, String following, String followers, String name, String login) {
        this.email = email;
        this.avatar = avatar;
        this.following = following;
        this.followers = followers;
        this.name = name;
        this.login = login;
    }

    protected GitHubUser(Parcel in) {
        email = in.readString();
        avatar = in.readString();
        following = in.readString();
        followers = in.readString();
        name = in.readString();
        login = in.readString();
    }

    public static final Creator<GitHubUser> CREATOR = new Creator<GitHubUser>() {
        @Override
        public GitHubUser createFromParcel(Parcel in) {
            return new GitHubUser(in);
        }

        @Override
        public GitHubUser[] newArray(int size) {
            return new GitHubUser[size];
        }
    };

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getFollowing() {
        return following;
    }

    public void setFollowing(String following) {
        this.following = following;
    }

    public String getFollowers() {
        return followers;
    }

    public void setFollowers(String followers) {
        this.followers = followers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(email);
        dest.writeString(avatar);
        dest.writeString(following);
        dest.writeString(followers);
        dest.writeString(name);
        dest.writeString(login);
    }
}
