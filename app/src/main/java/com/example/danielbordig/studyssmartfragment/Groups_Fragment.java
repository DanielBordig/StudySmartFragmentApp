package com.example.danielbordig.studyssmartfragment;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;


public class Groups_Fragment extends Fragment  implements AdapterView.OnItemSelectedListener{

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

   ;

    String[] yourgroups = { "Unlimited", "1 second", "2 seconds", "3 seconds",
            "4 seconds", " 5 seconds" };

    String[] fingroup = { "Unlimited", "1 minute", "2 minutes", "3 minutes",
            "4 minutes", " 5 minutes" };

    String[] crgroup = { "Unlimited", "5", "10", "15",
            "20", "25" };
    String[] delgroup = { "Unlimited", "5", "10", "15",
            "20", "25" };
    String[] morgroup = { "Unlimited", "5", "10", "15",
            "20", "25" };


    ArrayDatabase arrayDatabase = new ArrayDatabase();



    public Groups_Fragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

//    GroupImages [] data = new GroupImages[]{
//
//
//            new GroupImages(R.drawable.ns_big),
//            new GroupImages(R.drawable.bmp_big),
//            new GroupImages(R.drawable.fin),
//            new GroupImages(R.drawable.mo),
//            new GroupImages(R.drawable.ds),
//            new GroupImages(R.drawable.bmp_big),
//    };
//
    int[] logopic = new int[]{
        //   R.mipmap.groupicon,
            R.mipmap.bmp,
           R.mipmap.ns,
           R.mipmap.fin,
            R.mipmap.ds,
           R.mipmap.mo,
   };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_groups, container, false);
        ImageView  iv = (ImageView) root.findViewById(R.id.imageView);
        ImageView  iv2 = (ImageView) root.findViewById(R.id.imageView2);
        ImageView  iv3 = (ImageView) root.findViewById(R.id.imageView3);
        ImageView  iv4 = (ImageView) root.findViewById(R.id.imageView4);
        ImageView  iv5 = (ImageView) root.findViewById(R.id.imageView5);

        iv.setImageResource(logopic[0]);
        iv2.setImageResource(logopic[1]);
        iv3.setImageResource(logopic[2]);
        iv4.setImageResource(logopic[3]);
        iv5.setImageResource(logopic[4]);

        Spinner spinner1 = (Spinner) root.findViewById(R.id.yourgroupspin);
        Spinner spinner2 = (Spinner) root.findViewById(R.id.findgroupspin);
        Spinner spinner3 = (Spinner) root.findViewById(R.id.creatgroupspin);
        Spinner spinner4 = (Spinner) root.findViewById(R.id.deletegroupspin);
        Spinner spinner5 = (Spinner) root.findViewById(R.id.morespin);

        ArrayAdapter adapter1 = new ArrayAdapter(getActivity(),R.layout.spinner_elements, R.id.overskrift,yourgroups);
        ArrayAdapter adapter2 = new ArrayAdapter(getActivity(),R.layout.spinner_elements, R.id.overskrift, fingroup);
        ArrayAdapter adapter3 = new ArrayAdapter(getActivity(),R.layout.spinner_elements, R.id.overskrift, crgroup);
        ArrayAdapter adapter4 = new ArrayAdapter(getActivity(),R.layout.spinner_elements, R.id.overskrift, delgroup);
        ArrayAdapter adapter5 = new ArrayAdapter(getActivity(),R.layout.spinner_elements, R.id.overskrift, morgroup);

       //ArrayAdapter adapter6 = new ArrayAdapter(getActivity(), R.layout.spinner_elements, R.id.overskrift, groups){

//            @Override
//            public View getView(int position, View convertView, ViewGroup parent) {
//                View view = super.getView(position, convertView, parent);
//
//                ImageView billede = (ImageView) view.findViewById(R.id.listeelem_billede);
//
//                billede.setImageResource(Integer.parseInt(GroupImage[position]));
//
//                return view;
//            }
//        };

        spinner1.setOnItemSelectedListener(this);
        spinner2.setOnItemSelectedListener(this);
        spinner3.setOnItemSelectedListener(this);
        spinner4.setOnItemSelectedListener(this);
        spinner5.setOnItemSelectedListener(this);

//        spinner1.setAdapter(adapter1);
//        spinner2.setAdapter(adapter2);
//        spinner3.setAdapter(adapter3);
//        spinner4.setAdapter(adapter4);
//        spinner5.setAdapter(adapter);

        return root;
    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
