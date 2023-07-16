package com.app.chatbot;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class DiaryAdapter extends FirestoreRecyclerAdapter<Diary, DiaryAdapter.DiaryViewHolder> {
    Context context;

    public DiaryAdapter(@NonNull FirestoreRecyclerOptions<Diary> options, Context context) {
        super(options);
        this.context = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull DiaryViewHolder holder, int position, @NonNull Diary diary) {
        holder.titleTextView.setText(diary.title);
        holder.contentTextView.setText(diary.content);
        holder.timeStampTextView.setText(Utility.timestampToString(diary.timestamp));

        holder.itemView.setOnClickListener((v)->{
            Intent intent = new Intent(context,DetailDiaryActivity.class);
            intent.putExtra("title",diary.title);
            intent.putExtra("content",diary.content);
            String docId = this.getSnapshots().getSnapshot(position).getId();
            intent.putExtra("docId", docId);
            context.startActivity(intent);
        });
    }

    @NonNull
    @Override
    public DiaryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_diary_item,parent,false);
        return new DiaryViewHolder(view);
    }

    class DiaryViewHolder extends RecyclerView.ViewHolder{
        TextView titleTextView,contentTextView,timeStampTextView;

        public DiaryViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.diary_title_text_view);
            contentTextView = itemView.findViewById(R.id.diary_content_text_view);
            timeStampTextView = itemView.findViewById(R.id.timestamp);
        }


    }
}
