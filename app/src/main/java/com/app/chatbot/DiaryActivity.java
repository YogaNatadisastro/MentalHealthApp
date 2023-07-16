package com.app.chatbot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.Query;

public class DiaryActivity extends AppCompatActivity {

    FloatingActionButton addNoteBtn;
    RecyclerView recyclerView;
    ImageButton menuBtn;
    DiaryAdapter diaryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);

        addNoteBtn = findViewById(R.id.add_note_btn);
        recyclerView = findViewById(R.id.recycler_view);
        menuBtn = findViewById(R.id.menu_btn);



        addNoteBtn.setOnClickListener((v)-> startActivity(new Intent(DiaryActivity.this, DetailDiaryActivity.class)));
        menuBtn.setOnClickListener((v)-> showMenu());
        setupRecyclerView();
    }

    void showMenu(){

    }

    void setupRecyclerView(){
        Query query = Utility.getCollectionReferenceForDiary().orderBy("timestamp", Query.Direction.DESCENDING);
        FirestoreRecyclerOptions<Diary> options = new FirestoreRecyclerOptions.Builder<Diary>()
                .setQuery(query,Diary.class).build();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        diaryAdapter = new DiaryAdapter(options, this);
        recyclerView.setAdapter(diaryAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        diaryAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        diaryAdapter.stopListening();
    }

    @Override
    protected void onResume() {
        super.onResume();
        diaryAdapter.notifyDataSetChanged();
    }
}