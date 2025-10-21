package com.example.projectpts02;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class NoteListActivity extends AppCompatActivity {

    EditText edtNoteTitle;
    Button btnAddNote;
    ListView listNotes;

    ArrayList<String> noteList; // Data catatan
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_list); // pastikan ini sesuai XML kamu

        edtNoteTitle = findViewById(R.id.edtNoteTitle);
        btnAddNote = findViewById(R.id.btnAddNote);
        listNotes = findViewById(R.id.listNotes);

        noteList = new ArrayList<>();

        // Adapter untuk menampilkan data di ListView
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, noteList);
        listNotes.setAdapter(adapter);

        // Tombol tambah catatan
        btnAddNote.setOnClickListener(v -> {
            String title = edtNoteTitle.getText().toString().trim();
            if (!title.isEmpty()) {
                noteList.add(title);
                adapter.notifyDataSetChanged();
                edtNoteTitle.setText("");
            }
        });

        // Klik item list → pindah ke halaman AddNoteActivity
        listNotes.setOnItemClickListener((adapterView, view, position, id) -> {
            String selectedNote = noteList.get(position);

            Intent intent = new Intent(NoteListActivity.this, AddNoteActivity.class);
            intent.putExtra("noteTitle", selectedNote); // kirim judul catatan
            startActivity(intent);
        });
    }
}
