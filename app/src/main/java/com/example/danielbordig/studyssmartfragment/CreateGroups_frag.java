package com.example.danielbordig.studyssmartfragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.client.Firebase;

import java.util.HashMap;
import java.util.Map;


public class CreateGroups_frag extends Fragment implements View.OnClickListener{

    TextView name,time, location, literature;
    EditText subject;
    EditText nam, tim,loca,liter;
    Button submitbutt;

    public CreateGroups_frag() {
}
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_create_groups_frag, container, false);
        Bundle bundle = this.getArguments();

        submitbutt = (Button)root.findViewById(R.id.subbutton);

        name = (TextView) root.findViewById(R.id.nameText);
        time = (TextView) root.findViewById(R.id.timetxt);
        location = (TextView) root.findViewById(R.id.locationtxt);
        literature = (TextView) root.findViewById(R.id.literaturetxt);

        nam = (EditText) root.findViewById(R.id.nameEdit);
        tim = (EditText) root.findViewById(R.id.timeEdit);
        loca = (EditText) root.findViewById(R.id.locationEdit);
        liter = (EditText) root.findViewById(R.id.literatureEdit);
        subject = (EditText) root.findViewById(R.id.subjectEdit);

        submitbutt.setOnClickListener(this);
        return root;
    }


    @Override
    public void onClick(View v) {

        String nyGroup = "";
        nyGroup += "Name: " + nam.getText() + "\n";
        nyGroup += "Subject: " + subject.getText() + "\n";
        nyGroup += "Time: " + tim.getText() + "\n";
        nyGroup += "Location: " + loca.getText() + "\n";
        nyGroup += "Literature: " + liter.getText() + "\n";

        String testf = nam.getText().toString().trim();

        Firebase postRef = new Firebase("https://studysmart.firebaseio.com/CBS/All Created Groups/");

        postRef.child(testf+"/"+testf).setValue(nyGroup);
    }
}
