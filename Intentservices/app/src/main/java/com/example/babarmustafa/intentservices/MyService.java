package com.example.babarmustafa.intentservices;

/**
 * Created by BabarMustafa on 1/2/2017.
 */


        import android.app.IntentService;
        import android.content.Intent;
        import android.support.v4.content.LocalBroadcastManager;
        import android.util.Log;

public class MyService extends IntentService {

    public MyService() {
        super(MyService.class.getName());
    }

    @Override
    protected void onHandleIntent(Intent intent) {


        //retrieving data from the received intent
        int id = intent.getIntExtra("id",0);
        String message = intent.getStringExtra("msg");

        Log.i("Data  ", "id : "+id+" message : "+ message );
        //-----------------------------------------------


        //Do your long running task here


        //------------------------------------------------

        //Broadcasting some data
        Intent myIntent = new Intent("MyServiceStatus");
        myIntent.putExtra("serviceMessage", "Task done");

        // Send broadcast
        LocalBroadcastManager.getInstance(this).sendBroadcast(myIntent);

    }
}