package com.example.danielbordig.studyssmartfragment;

import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import java.util.ArrayList;


public class Groups_Fragment extends Fragment  implements AdapterView.OnItemSelectedListener{

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    Singleton sg;



    GroupImages[] test = new GroupImages[]{
        new GroupImages(R.mipmap.bmp),
        new GroupImages(R.mipmap.ds),
        new GroupImages(R.mipmap.fin),
        new GroupImages(R.mipmap.bmp),
        new GroupImages(R.mipmap.bmp),
        new GroupImages(R.mipmap.bmp),
        new GroupImages(R.mipmap.bmp),
    };


////    String[] groups = {""};
   String[] yourgroups = {"BMP","NS","FIN","SD", "MO" };
   String[] fingroup = {"BMP","NS","FIN","SD", "MO" };
   String[] crgroup = { "1", "2", "2", "4",};
   String[] delgroup = { "Unlimited", "5", "10", "15",};
   String[] morgroup = { "messages", "discusions", "metups", "exstra",};


    public Groups_Fragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        sg = Singleton.st;
        sg.visDrawer = true;
    }
//    int[] pic1 = new int[R.mipmap.create];
//    int[] pic2 = new int[R.mipmap.delete];

    int[] logopic = new int[]{
           // R.mipmap.groupicon,
            R.mipmap.bmp,
            R.mipmap.ns,
            R.mipmap.fin,
            R.mipmap.ds,
            R.mipmap.mo
   };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_groups, container, false);
        System.out.println("ocreatview start");

      // ImageView  ico = (ImageView) root.findViewById(R.id.imageView);
        ImageView  iv = (ImageView) root.findViewById(R.id.imageView1);
        ImageView  iv2 = (ImageView) root.findViewById(R.id.imageView2);
        ImageView  iv3 = (ImageView) root.findViewById(R.id.imageView3);
        ImageView  iv4 = (ImageView) root.findViewById(R.id.imageView4);
        ImageView  iv5 = (ImageView) root.findViewById(R.id.imageView5);

       // ico.setImageResource(logopic[0]);
        iv.setImageResource(logopic[0]);
        iv2.setImageResource(logopic[1]);
        iv3.setImageResource(logopic[2]);
        iv4.setImageResource(logopic[3]);
        iv5.setImageResource(logopic[4]);

       // Spinner spinner =  (Spinner) root.findViewById(R.id.grp);
        Spinner spinner1 = (Spinner) root.findViewById(R.id.yourgroupspin);
        Spinner spinner2 = (Spinner) root.findViewById(R.id.findgroupspin);
        Spinner spinner3 = (Spinner) root.findViewById(R.id.creatgroupspin);
        Spinner spinner4 = (Spinner) root.findViewById(R.id.deletegroupspin);
        Spinner spinner5 = (Spinner) root.findViewById(R.id.morespin);

       // ArrayAdapter adapter = new ArrayAdapter(getActivity(),R.layout.spinner_elements, R.id.overskrift,groups);

        ArrayAdapter adapter1 = new ArrayAdapter(getActivity(),R.layout.spinner_elements, R.id.overskrift,yourgroups);
//        {
//            @Override
//            public View getView(int position, View cachedView, ViewGroup parent) {
//                View view = super.getView(position, cachedView, parent);
//
//                Button beskrivelse = (Button) view.findViewById(R.id.grp);
//                beskrivelse.setText("");
//                ImageView billede = (ImageView) view.findViewById(R.id.imageView6);
//               billede.setImageResource(logopic[position]);
//                return view;
//            }
//        };


        GroupImagesAdapter adape = new GroupImagesAdapter(getActivity(),R.layout.spinner_elements, test);

        ArrayAdapter adapter2 = new ArrayAdapter(getActivity(),R.layout.spinner_elements, R.id.overskrift, fingroup);
        ArrayAdapter adapter3 = new ArrayAdapter(getActivity(),R.layout.spinner_elements, R.id.overskrift, crgroup);
        ArrayAdapter adapter4 = new ArrayAdapter(getActivity(),R.layout.spinner_elements, R.id.overskrift, delgroup);
        ArrayAdapter adapter5 = new ArrayAdapter(getActivity(),R.layout.spinner_elements, R.id.overskrift, morgroup);



       // spinner.setAdapter(adapter);
//        spinner1.setAdapter(adapter1);
//        spinner2.setAdapter(adapter2);
//        spinner3.setAdapter(adapter3);
//        spinner4.setAdapter(adapter4);
//        spinner5.setAdapter(adapter5);



        spinner1.setAdapter(adape);
        spinner2.setAdapter(adapter1);
        spinner3.setAdapter(adapter3);
        spinner4.setAdapter(adapter4);
        spinner5.setAdapter(adapter5);

        spinner1.setOnItemSelectedListener(this);
        spinner2.setOnItemSelectedListener(this);
        spinner3.setOnItemSelectedListener(this);
        spinner4.setOnItemSelectedListener(this);
        spinner5.setOnItemSelectedListener(this);
        System.out.println("onCreateview slut");

        return root;

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
