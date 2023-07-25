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


public class ReminderAdapter extends FirestoreRecyclerAdapter<Reminder, ReminderAdapter.ReminderViewHolder> {
    Context context;

    public ReminderAdapter(@NonNull FirestoreRecyclerOptions<Reminder> options, Context context) {
        super(options);
        this.context = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull ReminderViewHolder holder, int position, @NonNull Reminder model) {
        holder.titleTextView.setText(model.title);
        holder.contentTextView.setText(model.content);
        holder.timestampTextView.setText(UtilityReminder.timestampToString(model.timestamp));

        holder.itemView.setOnClickListener((v)-> {
            Intent intent = new Intent(context,DetailReminderActivity.class);
            intent.putExtra("title",model.title);
            intent.putExtra("content",model.content);
            String docId = this.getSnapshots().getSnapshot(position).getId();
            intent.putExtra("docId", docId);
            context.startActivity(intent);
        });
    }

    @NonNull
    @Override
    public ReminderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item_reminder,parent,false);
        return new ReminderViewHolder(view);
    }

    class ReminderViewHolder extends RecyclerView.ViewHolder{

        TextView titleTextView,contentTextView,timestampTextView;

        public ReminderViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.nama_obat_title);
            contentTextView = itemView.findViewById(R.id.nama_waktuObat_content);
            timestampTextView = itemView.findViewById(R.id.timestamp);
        }
    }

}
