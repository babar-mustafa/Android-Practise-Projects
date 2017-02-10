package com.example.babarmustafa.intentservices;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setting button click
        findViewById(R.id.btn_start_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Creating an intent for sending to service
                Intent intent = new Intent(getApplicationContext(), MyService.class);

                intent.putExtra("id", 101);
                intent.putExtra("msg", "hi");

                //starting service
                startService(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        //register broadcast receiver for the intent MyTaskStatus
        LocalBroadcastManager.getInstance(this).registerReceiver(MyReceiver, new IntentFilter("MyServiceStatus"));
    }


    //Defining broadcast receiver
    private BroadcastReceiver MyReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            String message = intent.getStringExtra("serviceMessage");

            Toast.makeText(MainActivity.this, "Received : " + message, Toast.LENGTH_SHORT).show();
        }
    };


    @Override
    protected void onStop() {
        super.onStop();

        LocalBroadcastManager.getInstance(this).unregisterReceiver(MyReceiver);
    }

}