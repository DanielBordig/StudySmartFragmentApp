package com.example.danielbordig.studyssmartfragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by jose on 1/18/2016.
 */
public class Studyhomework extends Fragment {

    TextView bmphmwrk;
    ArrayList<String> yourGroups;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.akt_studyhomework, container, false);
        Bundle bundle = this.getArguments();

        bmphmwrk = (TextView)  root.findViewById(R.id.bmphmwrk);

        yourGroups = MainActivity.db.getYourGroups();
        if(bundle.get("group").equals(R.mipmap.bmp)) bmphmwrk.setText(yourGroups.get(0));
        else if(bundle.get("group").equals(R.mipmap.ns)) bmphmwrk.setText(yourGroups.get(1));
        else if(bundle.get("group").equals(R.mipmap.fin)) bmphmwrk.setText(yourGroups.get(2));
        else if(bundle.get("group").equals(R.mipmap.ds)) bmphmwrk.setText(yourGroups.get(3));
        else if(bundle.get("group").equals(R.mipmap.mo)) bmphmwrk.setText(yourGroups.get(4));
        return root;
    }

}
