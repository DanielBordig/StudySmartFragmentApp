package com.example.danielbordig.studyssmartfragment;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;


public class Groups_Fragment extends Fragment  implements AdapterView.OnItemSelectedListener{

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public Groups_Fragment() {
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

    String[] groups = {"your groups", "BMP","NS", "FIN", "DS","MO"};
    String[] fingroup ={ "find groups"};
    String[] crgroup ={ "create groups"};
    String[] delgroup ={ "delet groups"};
    String[] morgroup ={ "more groups"};

    int[] logopic = new int[]{
            R.mipmap.groupicon,
            R.mipmap.bmp,
            R.mipmap.ns,
            R.mipmap.fin,
            R.mipmap.ds,
            R.mipmap.mo,
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_groups, container, false);
        Spinner spinner1 = (Spinner) root.findViewById(R.id.yourgroupspin);
        Spinner spinner2 = (Spinner) root.findViewById(R.id.findgroupspin);
        Spinner spinner3 = (Spinner) root.findViewById(R.id.creatgroupspin);
        Spinner spinner4 = (Spinner) root.findViewById(R.id.deletegroupspin);
        Spinner spinner5 = (Spinner) root.findViewById(R.id.morespin);

        ArrayAdapter adapter = new ArrayAdapter(getActivity(),R.layout.spinner_elements, R.id.overskrift, groups);
        ArrayAdapter adapter2 = new ArrayAdapter(getActivity(),R.layout.spinner_elements, R.id.overskrift, fingroup);
        ArrayAdapter adapter3 = new ArrayAdapter(getActivity(),R.layout.spinner_elements, R.id.overskrift, crgroup);
        ArrayAdapter adapter4 = new ArrayAdapter(getActivity(),R.layout.spinner_elements, R.id.overskrift, delgroup);
        ArrayAdapter adapter5 = new ArrayAdapter(getActivity(),R.layout.spinner_elements, R.id.overskrift, morgroup);

        ArrayAdapter adapter6 = new ArrayAdapter(getActivity(), R.layout.spinner_elements, R.id.overskrift, groups){

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);

                ImageView billede = (ImageView) view.findViewById(R.id.listeelem_billede);

                billede.setImageResource(logopic[position]);

                return view;
            }
        };

        spinner1.setOnItemSelectedListener(this);
        spinner2.setOnItemSelectedListener(this);
        spinner3.setOnItemSelectedListener(this);
        spinner4.setOnItemSelectedListener(this);
        spinner5.setOnItemSelectedListener(this);

        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter2);
        spinner3.setAdapter(adapter3);
        spinner4.setAdapter(adapter4);
        spinner5.setAdapter(adapter6);

        return root;
    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
