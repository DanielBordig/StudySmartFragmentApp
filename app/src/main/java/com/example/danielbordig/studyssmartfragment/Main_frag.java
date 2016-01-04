package com.example.danielbordig.studyssmartfragment;

import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class Main_frag extends Fragment implements View.OnClickListener{

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;


    ImageView logoStudySmart, logoDTU, logoCBS;
    TextView header;
    Fragment fragment_login = new Login_frag();

    public Main_frag() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
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
            getFragmentManager().beginTransaction().replace(R.id.mainFrame, fragment_login).commit();
        }
        if(v==logoCBS){
            getFragmentManager().beginTransaction().replace(R.id.mainFrame, fragment_login).commit();
        }
    }

}
