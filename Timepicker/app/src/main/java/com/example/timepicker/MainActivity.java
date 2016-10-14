package com.example.timepicker;

import java.util.Calendar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    private TimePicker timePicker1;
    private TextView time_view;
    private Calendar calendar;
    private String format = "";
    Button btn_for_time_set;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timePicker1 = (TimePicker) findViewById(R.id.timePicker1);
        time_view = (TextView) findViewById(R.id.textView1);
        calendar = Calendar.getInstance();
btn_for_time_set = (Button) findViewById(R.id.set_button);

//on start this will show the curent time_view
               int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int min = calendar.get(Calendar.MINUTE);
        showTime(hour, min);

        btn_for_time_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hour = timePicker1.getCurrentHour();
                int min = timePicker1.getCurrentMinute();
                showTime(hour, min);
            }
        });
    }


    public void showTime(int hour, int min) {
        if (hour == 0) {
            hour += 12;
            format = "AM";
        }
        else if (hour == 12) {
            format = "PM";
        } else if (hour > 12) {
            hour -= 12;
            format = "PM";
        } else {
            format = "AM";
        }
        time_view.setText(new StringBuilder().append(hour).append(" : ").append(min)
                .append(" ").append(format));
    }


}