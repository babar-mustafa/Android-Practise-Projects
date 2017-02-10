package com.example.babarmustafa.sastrtandstopservices;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by BabarMustafa on 1/2/2017.
 */

public class TestService extends Service {
    DatabaseReference db ;
    Calendar cal;
    Calendar lol;


    @Override
    public void onCreate() {
        db = FirebaseDatabase.getInstance().getReference();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    cal = Calendar.getInstance();
        Log.d("time", String.valueOf(cal.getTime()));
        Toast.makeText(this, "time"+cal.getTime(), Toast.LENGTH_SHORT).show();

        Toast.makeText(this, "service created", Toast.LENGTH_SHORT).show();
        db.child("on-service-create").push().child(String.valueOf(cal.getTime())).child("text").setValue("service created");
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "service destroyed", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        Timer timer = new Timer ();
        TimerTask hourlyTask = new TimerTask () {
            @Override
            public void run () {
                lol = Calendar.getInstance();
        db.child("onStartCommand").push().child(String.valueOf(lol.getTime())).child("text").setValue("service restarted");
            }
        };

// schedule the task to run starting now and then every hour...
        timer.schedule (hourlyTask, 0l, 1000*60*60);
        // 1000*10*60 every 10 minut

        Runnable r = new Runnable() {
            @Override
            public void run(){
                Toast.makeText(TestService.this, "service restarted", Toast.LENGTH_SHORT).show();
            }
        };

        Handler h = new Handler();
        h.postDelayed(r, 1000*1*60);



        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }
}