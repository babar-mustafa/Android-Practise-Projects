package com.example.babarmustafa.fragtofrag;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements First.SendMessage{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public void sendData(String message) {
       Second_Fragment fragment = (Second_Fragment) getSupportFragmentManager().findFragmentById(R.id.fragment2);
        fragment.getData(message);
    }
}
