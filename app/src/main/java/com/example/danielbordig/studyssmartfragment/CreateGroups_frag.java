package com.example.danielbordig.studyssmartfragment;

import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;


public class CreateGroups_frag extends Fragment implements View.OnClickListener{

    TextView yourName,time, location, literature;
    EditText nam, tim, loca,liter;
    Button submitbutt;
    Bundle bundle;
    String course;

    public CreateGroups_frag() {
}
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_create_groups_frag, container, false);
        bundle = this.getArguments();
        if(bundle.get("group").equals(R.mipmap.bmp)) course = "BMP";
        else if(bundle.get("group").equals(R.mipmap.ns)) course = "NS";
        else if(bundle.get("group").equals(R.mipmap.fin)) course = "FIN";
        else if(bundle.get("group").equals(R.mipmap.ds)) course = "DS";
        else if(bundle.get("group").equals(R.mipmap.mo)) course = "MO";

        submitbutt = (Button)root.findViewById(R.id.subbutton);
        submitbutt.setBackgroundColor(Color.BLUE);
        submitbutt.setTextColor(Color.WHITE);

        yourName = (TextView) root.findViewById(R.id.yourNametxt);
        time = (TextView) root.findViewById(R.id.timetxt);
        location = (TextView) root.findViewById(R.id.locationtxt);
        literature = (TextView) root.findViewById(R.id.literaturetxt);

        nam = (EditText) root.findViewById(R.id.nameEdit);
        tim = (EditText) root.findViewById(R.id.timeEdit);
        loca = (EditText) root.findViewById(R.id.locationEdit);
        liter = (EditText) root.findViewById(R.id.literatureEdit);

        submitbutt.setOnClickListener(this);
        return root;
    }


    @Override
    public void onClick(View v) {
        if(nam.getText().equals("") || tim.getText()==null || loca.getText()==null || liter.getText()==null){
            Toast.makeText(getActivity(), "Fill out all fields", Toast.LENGTH_LONG).show();
        }

        String nyGroup = "";
        nyGroup += "Creator: " + nam.getText() + "\n";
        nyGroup += "Course: " + course + "\n";
        nyGroup += "Time: " + tim.getText() + "\n";
        nyGroup += "Location: " + loca.getText() + "\n";
        nyGroup += "Literature: " + liter.getText() + "\n";

        String testf = nam.getText().toString().trim();

        Firebase postRef = new Firebase("https://studysmart.firebaseio.com/CBS/All Created Groups/");

        postRef.child(testf + "/" + testf).setValue(nyGroup);

    }
}
