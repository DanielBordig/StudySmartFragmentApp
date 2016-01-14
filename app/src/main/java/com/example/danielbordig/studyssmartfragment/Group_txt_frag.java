package com.example.danielbordig.studyssmartfragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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

    int[] logopic = new int[]{
            R.mipmap.groupicon,
    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.grouptxt, container, false);

        ImageView ico = (ImageView) root.findViewById(R.id.grp);
        ico.setImageResource(logopic[0]);

        yourgroup = (TextView)root.findViewById(R.id.buttyrg);
        yourgroup.setOnClickListener(this);
        findgroups = (TextView)root.findViewById(R.id.buttfndg);
        findgroups.setOnClickListener(this);
        creategroups = (TextView)root.findViewById(R.id.buttcrtg);
        creategroups.setOnClickListener(this);
        deletegroups= (TextView)root.findViewById(R.id.buttdelt);
        deletegroups.setOnClickListener(this);
        moreoption = (TextView)root.findViewById(R.id.buttmore);
        moreoption.setOnClickListener(this);

return root;
    }


    @Override
    public void onClick(View v) {
        getFragmentManager().beginTransaction().replace(R.id.mainFrame,yourgroup_frag).commit();
    }
}



