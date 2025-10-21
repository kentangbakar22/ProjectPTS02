package com.example.projectpts02;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    EditText edtNamaLengkap, edtUsername, edtPassword;
    Button btnMasuk, btnKembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // 🔹 Hubungkan ke komponen XML
        edtNamaLengkap = findViewById(R.id.edtNamaLengkap);
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnMasuk = findViewById(R.id.btnMasuk);
        btnKembali = findViewById(R.id.btnKembali);

        // ✅ Tombol MASUK -> simpan data & pindah ke ChooseNoteTypeActivity
        btnMasuk.setOnClickListener(v -> {
            String nama = edtNamaLengkap.getText().toString().trim();
            String username = edtUsername.getText().toString().trim();
            String password = edtPassword.getText().toString().trim();

            if (nama.isEmpty() || username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Isi semua data dulu ya!", Toast.LENGTH_SHORT).show();
                return;
            }

            // Simpan ke SharedPreferences
            SharedPreferences prefs = getSharedPreferences("UserPrefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("nama", nama);
            editor.putString("username", username);
            editor.putString("password", password);
            editor.apply();

            // ✅ Pindah ke halaman ChooseNoteTypeActivity
            Intent intent = new Intent(RegisterActivity.this, ChooseNoteTypeActivity.class);
            startActivity(intent);
            finish();
        });

        // 🔙 Tombol KEMBALI -> balik ke halaman Login
        btnKembali.setOnClickListener(v -> {
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
