package com.example.serviceforegroundnotification;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.core.app.NotificationCompat;

// https://developer.android.com/guide/components/foreground-services

public class PushService extends Service {
    public PushService() { // -------------
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        startForeground(1,getNotification());
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stopForeground(true);
    }

    private Notification getNotification() {
        // phase 1
        int icon = android.R.drawable.sym_call_incoming;
        long when = System.currentTimeMillis();
        String title = "new phone call";
        String contentText="push to restart game";

        // phase 2
        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
        intent.putExtra("key", "Kugel is the next Google");
        PendingIntent pendingIntent =
                PendingIntent.getActivity(getApplicationContext(),0,intent,0);

        // phase 3
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext());
        Notification notification = builder.setContentIntent(pendingIntent)
                .setSmallIcon(icon)
                .setWhen(when)
                .setAutoCancel(true)
                .setContentTitle(title)
                .setContentText(contentText)
                .build();
        // phase 4
        //notificationManager.notify(1, notification); // 1 is id, to use in cancel
        return notification;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}