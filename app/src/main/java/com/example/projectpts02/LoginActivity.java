package com.example.projectpts02;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    EditText username, password;
    Button btnLogin, btnRegister;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // bind views (pastikan ids sama dengan activity_login.xml)
        username = findViewById(R.id.edtUsername);
        password = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogout);
        btnRegister = findViewById(R.id.btnLogout);

        // klik Masuk -> ChooseNoteTypeActivity
        btnLogin.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, ChooseNoteTypeActivity.class);
            startActivity(intent);
        });

        // klik Buat Akun -> RegisterActivity
        btnRegister.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        });
    }
}
