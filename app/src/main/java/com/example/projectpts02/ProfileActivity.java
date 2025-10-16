package com.example.projectpts02;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    EditText edtNama, edtTanggal, edtAlamat;
    Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // pastikan nama layout sesuai file XML di folder res/layout
        setContentView(R.layout.activity_profile);

        // hubungkan semua komponen dengan ID di XML
        edtNama = findViewById(R.id.edtNama);
        edtTanggal = findViewById(R.id.edtTanggal);
        edtAlamat = findViewById(R.id.edtAlamat);
        btnLogout = findViewById(R.id.btnLogout);

        // tombol logout kembali ke LoginActivity
        btnLogout.setOnClickListener(v -> {
            Intent intent = new Intent(ProfileActivity.this, LoginActivity.class);
            startActivity(intent);
            finish(); // agar tidak bisa balik pakai tombol Back
        });
    }
}
