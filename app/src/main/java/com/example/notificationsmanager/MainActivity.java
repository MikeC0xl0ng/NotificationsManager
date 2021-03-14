package com.example.notificationsmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
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
        String channel_description = "channel_description";
        String channel_ID = "my_channel_ID";
        String channel_name = "channel_name";
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel(channel_ID,
                    channel_name,
                    NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            channel.setDescription(channel_description);
            notificationManager.createNotificationChannel(channel);
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                NotificationCompat.Builder builder  = new NotificationCompat.Builder(MainActivity.this, channel_ID)
                        .setContentTitle("Title of the notification")
                        .setContentText("Subject of the notification")
                        .setSmallIcon(R.drawable.ic_launcher_foreground)
                        .setAutoCancel(true);

                NotificationManager managerCompat = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                managerCompat.notify(0, builder.build());


            }
        });
    }

    private void notificationAppear(double seconds) {

    }

    private void notificationAppear() {

        /*
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        String channel_ID = "my_channel_ID";
        String channel_name = "channel_name";
        String channel_description = "channel_description";

        if(android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel(channel_ID,
                    channel_name,
                    NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription(channel_description);
            notificationManager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder builder  = new NotificationCompat.Builder(this)
                .setContentTitle("New mail from " + "test@gmail.com")
                .setContentText("Subject")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentIntent(pIntent)
                .setAutoCancel(true)
                .addAction(R.drawable.icon, "Call", pIntent)
                .addAction(R.drawable.icon, "More", pIntent)
                .addAction(R.drawable.icon, "And more", pIntent).build();

        notificationManager.notify(0, builder.build());


         */


    }

}