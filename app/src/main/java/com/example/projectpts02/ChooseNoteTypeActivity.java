package com.example.projectpts02;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class ChooseNoteTypeActivity extends AppCompatActivity {
    private android.R.attr R;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout);

        @SuppressLint("ResourceType") Button diary = findViewById(R.id);
        Button harian = findViewById(R.id);

        diary.setOnClickListener(v -> startActivity(new Intent(this, NoteListActivity.class)));
        harian.setOnClickListener(v -> startActivity(new Intent(this, NoteListActivity.class)));
    }
}
