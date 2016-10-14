package com.example.developer.db;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class OrderView extends AppCompatActivity {
    ListView lv;
    ArrayList<String> players=new ArrayList<String>();
    Button retrieveBtn;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_view);
        //listview
        lv=(ListView) findViewById(R.id.listView1);
        //lv.setBackgroundColor(Color.LTGRAY);
        retrieveBtn = (Button) findViewById(R.id.retrievebtn);
        final DBAdapter db = new DBAdapter(this);
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_selectable_list_item,players);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, final int pos,
                                    long id) {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(OrderView.this);
                alertDialogBuilder.setMessage("Are you sure,to Delete?");

                alertDialogBuilder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {


                        adapter.remove(adapter.getItem(pos));


                        Toast.makeText(OrderView.this,"you deleted the item succesfully",Toast.LENGTH_LONG).show();
                    }
                });

                alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });
        //RETRIEVE
        retrieveBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                players.clear();

                //OPEN
                db.openDB();

                //RETRIEVE
                Cursor c=db.getAllNames();

                while(c.moveToNext())
                {
                    String name=c.getString(1);
                    players.add(name);
                }

                lv.setAdapter(adapter);

                db.close();

            }
        });



    }




}


