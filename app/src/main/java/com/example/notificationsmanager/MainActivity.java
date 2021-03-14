package com.example.notificationsmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notificationAppear();
            }
        });
    }

    private void notificationAppear() {

        Intent intent = new Intent(this, MessageActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        String channel_ID = "my_channel_ID";
        String channel_name = "channel_name";
        String channel_description = "channel_description";

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel(channel_ID,
                    channel_name,
                    NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription(channel_description);
            notificationManager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder builder  = new NotificationCompat.Builder(this, channel_ID)
                .setContentTitle("Notification's title")
                .setContentText("Cliccami per eseguire la PendingIntentActivity")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setAutoCancel(true)
                .setContentIntent(pi);

        notificationManager.notify(0, builder.build());
    }
}