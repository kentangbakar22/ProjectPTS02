package com.example.projectpts02;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    EditText edtNamaLengkap, edtUsername, edtPassword, edtKonfirmasi;
    Button btnDaftar, btnKembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtNamaLengkap = findViewById(R.id.edtNamaLengkap);
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        edtKonfirmasi = findViewById(R.id.edtKonfirmasi);
        btnDaftar = findViewById(R.id.btnDaftar);
        btnKembali = findViewById(R.id.btnKembali);

        // klik DAFTAR
        btnDaftar.setOnClickListener(v -> {
            // nanti bisa tambahkan validasi di sini
            finish(); // untuk sementara, kembali ke login
        });

        // klik KEMBALI
        btnKembali.setOnClickListener(v -> {
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
