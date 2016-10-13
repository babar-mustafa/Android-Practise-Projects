package com.example.fragement_details;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment_A extends Fragment {
    Button btn;
    EditText editText;



    public BlankFragment_A() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank_fragment_a, container, false);
        btn = (Button) view.findViewById(R.id.showburron);
        editText = (EditText) view.findViewById(R.id.edittext1);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//infergment must right getactivity



                Toast.makeText(getActivity(), "You enterd " +editText.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

}
