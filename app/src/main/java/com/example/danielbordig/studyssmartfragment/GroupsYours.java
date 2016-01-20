package com.example.danielbordig.studyssmartfragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by jose on 1/18/2016.
 */
public class GroupsYours extends Fragment {

    ListView bmphmwrk;
    ArrayList<String> bmpGroups, nsGroups, finGroups, dsGroups, moGroups;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.yourgroups_layout, container, false);
        Bundle bundle = this.getArguments();

        bmphmwrk = (ListView)  root.findViewById(R.id.bmphmwrk);

        bmpGroups = MainActivity.db.getBmpGroups();
        nsGroups = MainActivity.db.getNsGroups();
        finGroups = MainActivity.db.getFinGroups();
        dsGroups = MainActivity.db.getDsGroups();
        moGroups = MainActivity.db.getMoGroups();

        if(bundle.get("group").equals(R.mipmap.bmp)) bmphmwrk.setAdapter(new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, bmpGroups));
        else if(bundle.get("group").equals(R.mipmap.ns)) bmphmwrk.setAdapter(new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, nsGroups));
        else if(bundle.get("group").equals(R.mipmap.fin)) bmphmwrk.setAdapter(new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, finGroups));
        else if(bundle.get("group").equals(R.mipmap.ds)) bmphmwrk.setAdapter(new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, dsGroups));
        else if(bundle.get("group").equals(R.mipmap.mo)) bmphmwrk.setAdapter(new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, moGroups));
        return root;
    }

}
