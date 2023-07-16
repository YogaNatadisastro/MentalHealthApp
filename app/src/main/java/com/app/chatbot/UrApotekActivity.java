package com.app.chatbot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.app.chatbot.Adapter.ApotekAdapter;
import com.app.chatbot.Data.ApotekData;
import com.app.chatbot.Model.Apotek;

import java.util.ArrayList;

public class UrApotekActivity extends AppCompatActivity {

    private RecyclerView rv;
    private final ArrayList<Apotek> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ur_apotek);

        rv = findViewById(R.id.rvApotek);
        rv.setHasFixedSize(true);

        list.addAll(ApotekData.getList());
        showRecyclerView();
    }

    private void showRecyclerView() {
        rv.setLayoutManager(new LinearLayoutManager(this));
        ApotekAdapter apotek = new ApotekAdapter(list);
        rv.setAdapter(apotek);
    }
}