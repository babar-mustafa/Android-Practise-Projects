package com.example.fragement_details;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn,btn2,btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);


btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Toast.makeText(MainActivity.this, "Button 1 pressed", Toast.LENGTH_SHORT).show();
        getSupportFragmentManager()

                .beginTransaction().add(R.id.frame_layout,new BlankFragment_A()).commit();
    }
});
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Button 2 pressed", Toast.LENGTH_SHORT).show();
                getSupportFragmentManager()
                        .beginTransaction().add(R.id.frame_layout,new BlankFragment_B()).commit();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Button 3 pressed", Toast.LENGTH_SHORT).show();
                getSupportFragmentManager()
                        .beginTransaction().add(R.id.frame_layout,new BlankFragment_C()).commit();
            }
        });
    }
    }


