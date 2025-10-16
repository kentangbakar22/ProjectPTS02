package com.example.projectpts02;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class AddNoteActivity extends AppCompatActivity {

    EditText edtTitle, edtContent;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        // Hubungkan ke komponen di layout
        edtTitle = findViewById(R.id.edtTitle);
        edtContent = findViewById(R.id.edtContent);
        btnSave = findViewById(R.id.btnSave);

        // Saat tombol "Simpan Catatan" diklik
        btnSave.setOnClickListener(v -> {
            String title = edtTitle.getText().toString();
            String content = edtContent.getText().toString();

            // (opsional) nanti bisa disimpan ke database atau dikirim ke activity lain
            // Untuk sementara, cukup tutup halaman ini
            finish();
        });
    }
}
