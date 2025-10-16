package com.example.projectpts02;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class NoteListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    NoteListAdapter adapter;
    ArrayList<String> notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_list);

        recyclerView = findViewById(R.id.recyclerNotes);

        notes = new ArrayList<>();
        notes.add("Catatan 1");
        notes.add("Aktivitas 2");
        notes.add("Diary Hari Ini");

        adapter = new NoteListAdapter(this, notes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
