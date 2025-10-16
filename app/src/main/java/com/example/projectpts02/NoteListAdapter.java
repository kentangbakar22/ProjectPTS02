package com.example.projectpts02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class NoteListAdapter extends RecyclerView.Adapter<NoteListAdapter.ViewHolder> {

    private Context context;
    private ArrayList<String> noteList;

    // Konstruktor harus urut: Context dulu, lalu data
    public NoteListAdapter(Context context, ArrayList<String> noteList) {
        this.context = context;
        this.noteList = noteList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_main, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtNote.setText(noteList.get(position));
    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtNote;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNote = itemView.findViewById(R.id.txtNote);
        }
    }
}
