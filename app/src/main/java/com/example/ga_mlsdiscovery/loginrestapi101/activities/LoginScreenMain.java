package com.example.ga_mlsdiscovery.loginrestapi101.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ga_mlsdiscovery.loginrestapi101.R;

public class LoginScreenMain extends AppCompatActivity {
    protected Button bt_login;
    protected EditText et_username;
    protected Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen_main);

        bt_login = findViewById(R.id.bt_login);
        et_username = findViewById(R.id.et_loginScreen);
    }

    public void loginOnClick(View view) {
        i = new Intent(LoginScreenMain.this, UserActivity.class);
        i.putExtra("STRING_I_NEED", et_username.getText().toString());
        startActivity(i);
    }
}
