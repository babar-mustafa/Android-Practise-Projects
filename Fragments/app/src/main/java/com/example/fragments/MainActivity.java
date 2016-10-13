package com.example.fragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //id of frame layout
        //object of fragment class
        getSupportFragmentManager().beginTransaction().add(R.id.frame_layout,new Firsst_Fragment()).commit();
    }
}
