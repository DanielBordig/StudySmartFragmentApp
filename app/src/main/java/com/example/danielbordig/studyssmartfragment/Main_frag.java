package com.example.danielbordig.studyssmartfragment;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class Main_frag extends Fragment implements View.OnClickListener{

    ImageView logoStudySmart, logoDTU, logoCBS;
    TextView header;

    public Main_frag() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        logoStudySmart = (ImageView) root.findViewById(R.id.logoStudySmartMain);
        logoDTU = (ImageView) root.findViewById(R.id.logoDTU);
        logoCBS = (ImageView) root.findViewById(R.id.logoCBS);
        header = (TextView) root.findViewById(R.id.headerMain);

        logoDTU.setOnClickListener(this);
        logoCBS.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View v) {
        if(v==logoDTU){
            getFragmentManager().beginTransaction().replace(R.id.mainFrame, new Login_frag()).commit();
        }
        if(v==logoCBS){
            getFragmentManager().beginTransaction().replace(R.id.mainFrame, new Login_frag()).commit();
        }
    }
}
