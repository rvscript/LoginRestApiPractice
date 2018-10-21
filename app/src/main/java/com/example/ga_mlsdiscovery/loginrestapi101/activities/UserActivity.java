package com.example.ga_mlsdiscovery.loginrestapi101.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ga_mlsdiscovery.loginrestapi101.R;
import com.example.ga_mlsdiscovery.loginrestapi101.models.GitHubUser;
import com.example.ga_mlsdiscovery.loginrestapi101.rest.ApiClient;
import com.example.ga_mlsdiscovery.loginrestapi101.rest.GitHubUserEndPoints;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserActivity extends AppCompatActivity {

    ImageView iv_avatar;
    TextView tv_username, tv_followers, tv_following, tv_login, tv_email;
    Button bt_ownedrepos;
    Bundle extras;
    String newString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        iv_avatar = findViewById(R.id.iv_avatar);
        tv_email = findViewById(R.id.tv_email);
        tv_followers = findViewById(R.id.tv_followers);
        tv_following = findViewById(R.id.tv_following);
        tv_login= findViewById(R.id.tv_login);
        tv_username = findViewById(R.id.tv_username);
        bt_ownedrepos = findViewById(R.id.bt_login);

        extras = getIntent().getExtras();
        newString = extras != null ? extras.getString("STRING_I_NEED") : null;

        //debug code
        System.out.println(newString);

        loadData();
    }

    private void loadData() {
        final GitHubUserEndPoints apiService = ApiClient.getClient().create(GitHubUserEndPoints.class);
        Call<GitHubUser> call = apiService.getUser(newString);
        call.enqueue(new Callback<GitHubUser>() {
            @Override
            public void onResponse(Call<GitHubUser> call, Response<GitHubUser> response) {
                tv_username.setText("Username: "+ response.body().getName());
                tv_followers.setText("Followers: "+ response.body().getFollowers());
                tv_following.setText("Following: "+ response.body().getFollowing());
                tv_login.setText("Login: "+ response.body().getLogin());
                if (response.body().getEmail() == null) {
                    tv_email.setText("No email was provided");
                } else {
                    tv_email.setText("Email: "+ response.body().getEmail());
                }
            }

            @Override
            public void onFailure(Call<GitHubUser> call, Throwable t) {
                //Error logged here

            }
        });
    }

    public void loadOwnReposOnClick(View view) {
    }
}
