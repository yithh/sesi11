package com.example.session10;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    TextView username, email, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        username = findViewById(R.id.tv_username);
        email = findViewById(R.id.tv_email);
        password = findViewById(R.id.tv_password);

        Intent intent = getIntent();
        String uname = intent.getStringExtra("username_user");
        String mail = intent.getStringExtra("email_user");
        String psw = intent.getStringExtra("password_user");
        username.setText(uname);
        email.setText(mail);
        password.setText(psw);

    }
}