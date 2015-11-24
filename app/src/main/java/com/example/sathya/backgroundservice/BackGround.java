package com.example.sathya.backgroundservice;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

/**
 * Created by Sathya on 24-11-2015.
 */
public class BackGround extends IntentService implements Runnable {
    public BackGround(String name) {
        super(name);
    }
    public BackGround(){
        super("sathya");
    }
    private int id=0;
    @Override
    protected void onHandleIntent(Intent intent) {

        run();

    }

    @Override
    public void run() {
        for (int i=1;i>0;i++){

            Uri uri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            NotificationCompat.Builder mBuilder=new NotificationCompat.Builder(this)
                    .setSmallIcon(R.drawable.notification_template_icon_bg)
                    .setContentTitle("Notification"+id)
                    .setSound(uri)
                    .setContentText("Notification from Map activity");

            NotificationManager mNotificationManager= (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            id++;
            mNotificationManager.notify(id,mBuilder.build());
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }
}
