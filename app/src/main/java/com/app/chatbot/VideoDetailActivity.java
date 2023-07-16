package com.app.chatbot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.app.chatbot.Adapter.VideoAdapter;
import com.app.chatbot.Data.VideoData;
import com.app.chatbot.Model.Video;

import java.util.ArrayList;

public class VideoDetailActivity extends AppCompatActivity {

    private RecyclerView rv;
    private final ArrayList<Video> list = new ArrayList<>();
    TextView tvName, tvWaktu;
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_detail);

        videoView = findViewById(R.id.videoView);

        MediaController media = new MediaController(this);
        videoView.setMediaController(media);
        media.setAnchorView(videoView);

        String url = getIntent().getStringExtra("url");
        Uri uri = Uri.parse(url);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();

        // Nama Video
        String name = getIntent().getStringExtra("name");
        tvName = findViewById(R.id.tvName);
        tvName.setText(name);
        // Lama Durasi
        String waktu = getIntent().getStringExtra("waktu");
        tvWaktu = findViewById(R.id.tvWaktu);
        tvWaktu.setText(waktu);

        rv = findViewById(R.id.rvVidDet);
        rv.setHasFixedSize(true);

        list.addAll(VideoData.getListData());
        showRecyclerList();
    }

    private void showRecyclerList() {
        rv.setLayoutManager(new LinearLayoutManager(this));
        VideoAdapter vid = new VideoAdapter(list);
        rv.setAdapter(vid);
    }
}