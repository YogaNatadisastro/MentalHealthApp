package com.app.chatbot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.Query;

public class ReminderActivity extends AppCompatActivity {

    FloatingActionButton addReminderBtn;
    RecyclerView recyclerView;
    ImageButton menuBtn;
    ReminderAdapter reminderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);

        addReminderBtn = findViewById(R.id.add_reminder);
        recyclerView = findViewById(R.id.recycler_view);
        menuBtn = findViewById(R.id.menu_btn);

        addReminderBtn.setOnClickListener((v)-> startActivity(new Intent(ReminderActivity.this, DetailReminderActivity.class)));
        menuBtn.setOnClickListener((v)->showMenu());
        setupRecyclerView();
    }

    void showMenu() {
    }

    void setupRecyclerView(){
        Query query = UtilityReminder.getCollectionReferenceForReminder().orderBy("timestamp", Query.Direction.DESCENDING);
        FirestoreRecyclerOptions<Reminder> options = new FirestoreRecyclerOptions.Builder<Reminder>()
                .setQuery(query,Reminder.class).build();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        reminderAdapter = new ReminderAdapter(options, this);
        recyclerView.setAdapter(reminderAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        reminderAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        reminderAdapter.stopListening();
    }

    @Override
    protected void onResume() {
        super.onResume();
        reminderAdapter.notifyDataSetChanged();
    }
}