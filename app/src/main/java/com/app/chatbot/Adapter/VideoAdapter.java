package com.app.chatbot.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.chatbot.Model.Video;

import com.app.chatbot.R;
import com.app.chatbot.VideoDetailActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ListViewHolder> {

    private final ArrayList<Video> listVid;

    public VideoAdapter(ArrayList<Video> list){
        this.listVid = list;
    }

    @NonNull
    @Override
    public VideoAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoAdapter.ListViewHolder holder, int position) {
        Video model = listVid.get(position);

        holder.tvVid.setText(model.getName());
        holder.tvDur.setText(model.getDurasi());
        Glide.with(holder.itemView.getContext())
                .load(model.getGambar())
                .apply(new RequestOptions().override(55,55))
                .into(holder.imgVid);

        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(holder.itemView.getContext(), VideoDetailActivity.class);

            intent.putExtra("name", model.getName());
            intent.putExtra("durasi", model.getDurasi());
            intent.putExtra("url", model.getUrl());
            holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return listVid.size();
    }

    static class ListViewHolder extends RecyclerView.ViewHolder {
        TextView tvVid, tvDur;
        ImageView imgVid;
        ListViewHolder(@NonNull View itemView) {
            super(itemView);

            tvVid = itemView.findViewById(R.id.tvVideo);
            tvDur = itemView.findViewById(R.id.tvDurasi);
            imgVid = itemView.findViewById(R.id.vidImg);
        }
    }
}
