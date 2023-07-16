package com.app.chatbot.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.chatbot.Model.Apotek;
import com.app.chatbot.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ApotekAdapter extends RecyclerView.Adapter<ApotekAdapter.ListViewHolder> {

    private ArrayList<Apotek> list;

    public ApotekAdapter(ArrayList<Apotek> listApotek){
        this.list = listApotek;
    }

    @NonNull
    @Override
    public ApotekAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vi = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_obat, parent, false);
        return new ListViewHolder(vi);
    }

    @Override
    public void onBindViewHolder(@NonNull ApotekAdapter.ListViewHolder holder, int position) {
        Apotek apotek = list.get(position);

        holder.tvNama.setText(apotek.getNama());
        holder.tvAlamat.setText(apotek.getAlamat());
        Glide.with(holder.itemView.getContext())
                .load(apotek.getGambar())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgObat);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ListViewHolder extends RecyclerView.ViewHolder {

        TextView tvAlamat, tvNama;
        ImageView imgObat;
        public ListViewHolder(@NonNull View v) {
            super(v);

            tvNama = v.findViewById(R.id.tvObat);
            tvAlamat = v.findViewById(R.id.tvAlamat);
            imgObat = v.findViewById(R.id.imgObat);
        }
    }
}
