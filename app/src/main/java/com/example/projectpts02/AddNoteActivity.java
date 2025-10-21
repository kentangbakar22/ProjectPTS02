package com.example.projectpts02;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddNoteActivity extends AppCompatActivity {

    EditText edtNoteTitle, edtNoteContent;
    Button btnSave;
    SharedPreferences sharedPreferences;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        // Hubungkan ke layout
        edtNoteTitle = findViewById(R.id.edtNoteTitle);
        edtNoteContent = findViewById(R.id.edtNoteContent);
        btnSave = findViewById(R.id.btnSave);

        sharedPreferences = getSharedPreferences("NotesData", MODE_PRIVATE);

        // Ambil data judul dari intent (kalau diklik dari list)
        String noteTitle = getIntent().getStringExtra("NOTE_TITLE");

        if (noteTitle != null) {
            // Kalau ada judul (catatan lama)
            edtNoteTitle.setText(noteTitle);
            String content = sharedPreferences.getString(noteTitle, "");
            edtNoteContent.setText(content);
        } else {
            // Kalau catatan baru
            noteTitle = "";
        }

        String finalNoteTitle = noteTitle; // buat variabel final biar bisa dipakai di lambda

        // Tombol SIMPAN
        btnSave.setOnClickListener(v -> {
            String title = edtNoteTitle.getText().toString().trim();
            String content = edtNoteContent.getText().toString();

            if (title.isEmpty()) {
                Toast.makeText(this, "Judul catatan tidak boleh kosong", Toast.LENGTH_SHORT).show();
                return;
            }

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(title, content);
            editor.apply();

            Toast.makeText(this, "Catatan disimpan", Toast.LENGTH_SHORT).show();

            // Balik ke halaman daftar catatan
            Intent intent = new Intent(AddNoteActivity.this, NoteListActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
