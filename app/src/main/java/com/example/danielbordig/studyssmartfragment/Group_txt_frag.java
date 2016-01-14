package com.example.danielbordig.studyssmartfragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by jose on 1/13/2016.
 */
public class Group_txt_frag extends Fragment implements View.OnClickListener {

    TextView yourgroup;
    TextView findgroups;
    TextView creategroups;
    TextView deletegroups;
    TextView moreoption;

    Fragment yourgroup_frag = new Groups_Fragment(); // this when to run the code

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.grouptxt, container, false);

        yourgroup = (TextView)root.findViewById(R.id.yourgroupstxt);
        yourgroup.setOnClickListener(this);
        findgroups = (TextView)root.findViewById(R.id.findgroupstxt);
        findgroups.setOnClickListener(this);
        creategroups = (TextView)root.findViewById(R.id.creatgroupstxt);
        creategroups.setOnClickListener(this);
        deletegroups= (TextView)root.findViewById(R.id.deletegroupstxt);
        deletegroups.setOnClickListener(this);
        moreoption = (TextView)root.findViewById(R.id.morestxt);
        moreoption.setOnClickListener(this);

return root;
    }


    @Override
    public void onClick(View v) {
        getFragmentManager().beginTransaction().replace(R.id.mainFrame,yourgroup_frag).commit();
    }
}



