package com.app.chatbot;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.Settings;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "reminder");



        MediaPlayer mp = MediaPlayer.create(context, Settings.System.DEFAULT_ALARM_ALERT_URI);
        mp.start();
        Toast.makeText(context, "Waktunya Minum Obat", Toast.LENGTH_LONG).show();
    }
}
