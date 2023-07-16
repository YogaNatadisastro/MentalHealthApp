package com.app.chatbot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnLogin, btnSign;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.login);
        btnSign = findViewById(R.id.sign);

        // For Login
        btnLogin.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, Login_user.class)));
        // For SignUp
        btnSign.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, SignUp.class )));
    }

}