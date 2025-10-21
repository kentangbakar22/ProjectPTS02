package com.example.projectpts02;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ChooseNoteTypeActivity extends AppCompatActivity {

    Button btnDiary, btnHarian, btnProfil;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_note_type); // pastikan XML ini benar

        // Hubungkan ke tombol di XML
        btnDiary = findViewById(R.id.btnDiary);
        btnHarian = findViewById(R.id.btnHarian);
        btnProfil = findViewById(R.id.btnProfil);

        // Ketika tombol DIARY ditekan
        btnDiary.setOnClickListener(v -> {
            Intent intent = new Intent(ChooseNoteTypeActivity.this, NoteListActivity.class);
            intent.putExtra("noteType", "DIARY");
            startActivity(intent);
        });

        // Ketika tombol HARIAN ditekan
        btnHarian.setOnClickListener(v -> {
            Intent intent = new Intent(ChooseNoteTypeActivity.this, NoteListActivity.class);
            intent.putExtra("noteType", "HARIAN");
            startActivity(intent);
        });

        // ✅ Tombol Profil
        btnProfil.setOnClickListener(v -> {
            Intent intent = new Intent(ChooseNoteTypeActivity.this, ProfileActivity.class);
            startActivity(intent);
        });
    }
}
