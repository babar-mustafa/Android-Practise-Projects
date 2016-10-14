package com.example.developer.db;

import java.util.ArrayList;


import android.app.Dialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {



    EditText nameTxt,posTxt;
    Button savebtn,viewbtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //edit text fields
        nameTxt = (EditText) findViewById(R.id.nameTxt);
        posTxt = (EditText) findViewById(R.id.posTxt);
        //buttons
        savebtn = (Button) findViewById(R.id.saveBtn);
        viewbtn = (Button) findViewById(R.id.viewb);


        final DBAdapter db = new DBAdapter(this);

viewbtn.setOnClickListener(new OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent i = new Intent(MainActivity.this,OrderView.class);
        startActivity(i);
    }
});

        //EVENTS
        savebtn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {


                //OPEN
                db.openDB();

                //INSERT
                long result = db.add(nameTxt.getText().toString(), posTxt.getText().toString());

                if (result > 0) {
                    nameTxt.setText("");
                    posTxt.setText("");
                    Toast.makeText(getApplicationContext(), "Data Inserted Succes Fully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Failure", Toast.LENGTH_SHORT).show();
                }


                //CLOSE DB
                db.close();
            }

        });


    }}

