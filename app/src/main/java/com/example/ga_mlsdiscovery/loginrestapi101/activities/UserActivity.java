package com.example.ga_mlsdiscovery.loginrestapi101.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ga_mlsdiscovery.loginrestapi101.R;

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

        extras = getIntent().getExtras();
        newString = extras.getString("STRING_I_NEED");

        iv_avatar = findViewById(R.id.iv_avatar);
        tv_email = findViewById(R.id.tv_email);
        tv_followers = findViewById(R.id.tv_followers);
        tv_following = findViewById(R.id.tv_following);
        tv_login= findViewById(R.id.tv_login);
        tv_username = findViewById(R.id.tv_username);
        bt_ownedrepos = findViewById(R.id.bt_login);
    }

    public void loadOwnReposOnClick(View view) {
    }
}
