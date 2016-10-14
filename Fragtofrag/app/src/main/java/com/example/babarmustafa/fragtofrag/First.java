package com.example.babarmustafa.fragtofrag;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class First extends Fragment {
SendMessage SM;
    EditText editText;
    Button button;


    public First() {
        // Required empty public constructor
    }



    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_first, container, false);
        editText = (EditText) view.findViewById(R.id.msg);
        button = (Button) view.findViewById(R.id.btn_sendata);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String get_message = editText.getText().toString();
                SM.sendData(get_message);
            }
        });
        return view;
    }

    //interface
    interface SendMessage {
        public void sendData(String message);

    }

    //to check this abstract method is implemented or not


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            SM = (SendMessage) activity;
        }
        catch (ClassCastException e){

            throw new ClassCastException("You need to implement send data method");
        }

    }
}
