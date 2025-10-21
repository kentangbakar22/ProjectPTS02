package com.example.projectpts02;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    ImageView imgProfile;
    EditText edtNamaLengkap, edtTanggalLahir, edtHobi;
    Button btnGantiFoto, btnLogout;
    Uri selectedImageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // 🔹 Hubungkan ke komponen XML
        imgProfile = findViewById(R.id.imgProfile);
        edtNamaLengkap = findViewById(R.id.edtNamaLengkap);
        edtTanggalLahir = findViewById(R.id.edtTanggalLahir);
        edtHobi = findViewById(R.id.edtHobi);
        btnGantiFoto = findViewById(R.id.btnGantiFoto);
        btnLogout = findViewById(R.id.btnLogout);

        // 🔹 Ambil data dari SharedPreferences
        SharedPreferences prefs = getSharedPreferences("UserPrefs", MODE_PRIVATE);
        String nama = prefs.getString("nama", "");
        String username = prefs.getString("username", "");
        String password = prefs.getString("password", "");
        String tanggal = prefs.getString("tanggal", "");
        String hobi = prefs.getString("hobi", "");

        // 🔹 Tampilkan ke EditText
        edtNamaLengkap.setText(nama);
        edtTanggalLahir.setText(tanggal);
        edtHobi.setText(hobi);

        // 🔹 Ganti foto profil
        ActivityResultLauncher<String> pickImageLauncher =
                registerForActivityResult(new ActivityResultContracts.GetContent(), uri -> {
                    if (uri != null) {
                        selectedImageUri = uri;
                        imgProfile.setImageURI(uri);
                        // Simpan URI ke SharedPreferences
                        prefs.edit().putString("fotoUri", uri.toString()).apply();
                    }
                });

        btnGantiFoto.setOnClickListener(v -> pickImageLauncher.launch("image/*"));

        // 🔹 Jika sebelumnya sudah ada foto yang disimpan
        String fotoUri = prefs.getString("fotoUri", null);
        if (fotoUri != null) {
            imgProfile.setImageURI(Uri.parse(fotoUri));
        }

        // 🔹 Tombol Logout
        btnLogout.setOnClickListener(v -> {
            SharedPreferences.Editor editor = prefs.edit();
            editor.clear();
            editor.apply();
            Toast.makeText(this, "Logout berhasil", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(ProfileActivity.this, LoginActivity.class));
            finish();
        });
    }
}
