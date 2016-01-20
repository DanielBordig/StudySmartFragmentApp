package com.example.danielbordig.studyssmartfragment;

import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;


public class Groups_Fragment extends Fragment implements View.OnClickListener {

    private Spinner spinner1, spinner2, spinner3,spinner4, spinner5;

    String[] yourgroups = {"","", "", "", "", ""};
    String[] fingroup = {"", "", "", "", "", ""};
    String[] crgroup = {"", "", "","", "", ""};
    String[] delgroup = {"", "", "", "","",""};
    String[] morgroup = {"", "", ""};


    public Groups_Fragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    int[] logopic = new int[]{
            R.mipmap.studyicon,
            R.mipmap.findico,
            R.mipmap.create,
            R.mipmap.deicon,
            R.mipmap.moreico,
    };

    String[] more2 =new String[]{
            "Messages", "Discussions", "Bullitenboard",
    };
    int[] logopic2 = new int[]{
            R.mipmap.empty,
            R.mipmap.bmp,
            R.mipmap.ns,
            R.mipmap.fin,
            R.mipmap.ds,
            R.mipmap.mo,
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_groups, container, false);

        ImageView iv = (ImageView) root.findViewById(R.id.imageView1);
        ImageView iv2 = (ImageView) root.findViewById(R.id.imageView2);
        ImageView iv3 = (ImageView) root.findViewById(R.id.imageView3);
        ImageView iv4 = (ImageView) root.findViewById(R.id.imageView4);
        ImageView iv5 = (ImageView) root.findViewById(R.id.imageView5);

        iv.setImageResource(logopic[0]);
        iv2.setImageResource(logopic[1]);
        iv3.setImageResource(logopic[2]);
        iv4.setImageResource(logopic[3]);
        iv5.setImageResource(logopic[4]);

        spinner1 = (Spinner) root.findViewById(R.id.yourgroupspin);
        spinner2 = (Spinner) root.findViewById(R.id.findgroupspin);
        spinner3 = (Spinner) root.findViewById(R.id.creatgroupspin);
        spinner4 = (Spinner) root.findViewById(R.id.deletegroupspin);
        spinner5 = (Spinner) root.findViewById(R.id.morespin);


        ArrayAdapter adapter1 = new ArrayAdapter(getActivity(), R.layout.spinner_elements, R.id.overskrift, yourgroups) {
            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                View v = super.getDropDownView(position, convertView, parent);

                ImageView i = (ImageView) v.findViewById(R.id.spinnerimage);
                i.setImageResource(logopic2[position]);

                TextView t = (TextView) v.findViewById(R.id.overskrift);
                t.setText("");

                return v;
            }
        };

        ArrayAdapter adapter2 = new ArrayAdapter(getActivity(), R.layout.spinner_elements, R.id.overskrift, fingroup) {
            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                View v = super.getDropDownView(position, convertView, parent);

                ImageView i = (ImageView) v.findViewById(R.id.spinnerimage);
                i.setImageResource(logopic2[position]);

                TextView t = (TextView) v.findViewById(R.id.overskrift);
                t.setText("");

                return v;
            }
        };

        ArrayAdapter adapter3 = new ArrayAdapter(getActivity(), R.layout.spinner_elements, R.id.overskrift, crgroup) {
            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                View v = super.getDropDownView(position, convertView, parent);

                ImageView i = (ImageView) v.findViewById(R.id.spinnerimage);
                i.setImageResource(logopic2[position]);

                TextView t = (TextView) v.findViewById(R.id.overskrift);
                t.setText("");

                return v;
            }
        };

        ArrayAdapter adapter4 = new ArrayAdapter(getActivity(), R.layout.spinner_elements, R.id.overskrift, delgroup) {

            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                View v = super.getDropDownView(position, convertView, parent);

                ImageView i = (ImageView) v.findViewById(R.id.spinnerimage);
                i.setImageResource(logopic2[position]);

                TextView t = (TextView) v.findViewById(R.id.overskrift);
                t.setText("");

                return v;
            }
        };

        ArrayAdapter adapter5 = new ArrayAdapter(getActivity(), R.layout.spinner_elements, R.id.overskrift, morgroup) {

            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                View v = super.getDropDownView(position, convertView, parent);

               // ImageView i = (ImageView) v.findViewById(R.id.spinnerimage);
                //i.setImageResource(logopic2[position]);

                TextView t = (TextView) v.findViewById(R.id.overskrift);
                t.setText(more2[position]);

                return v;
            }
        };

        spinner1.setAdapter(adapter1);
        spinner2.setAdapter(adapter2);
        spinner3.setAdapter(adapter3);
        spinner4.setAdapter(adapter4);
        spinner5.setAdapter(adapter5);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){

                }
                else if (position==1){
                    Bundle bundle = new Bundle();
                    bundle.putInt("group", R.mipmap.bmp);
                    Fragment fragment = new GroupsYours();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainFrame, fragment).addToBackStack(null).commit();
                }
                else if (position==2){
                    Bundle bundle = new Bundle();
                    bundle.putInt("group",R.mipmap.ns);
                    Fragment fragment = new GroupsYours();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainFrame, fragment).addToBackStack(null).commit();
                }
                else if (position==3){
                    Bundle bundle = new Bundle();
                    bundle.putInt("group",R.mipmap.fin);
                    Fragment fragment = new GroupsYours();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainFrame, fragment).addToBackStack(null).commit();

                }
                else if (position==4){
                    Bundle bundle = new Bundle();
                    bundle.putInt("group",R.mipmap.ds);
                    Fragment fragment = new GroupsYours();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainFrame, fragment).addToBackStack(null).commit();
                }
                else if (position==5) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("group",R.mipmap.mo);
                    Fragment fragment = new GroupsYours();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainFrame, fragment).addToBackStack(null).commit();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()

        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){

                }
                else if (position==1){
                    Bundle bundle = new Bundle();
                    bundle.putInt("group",R.mipmap.bmp);
                    Fragment fragment = new GroupsYours();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainFrame, fragment).addToBackStack(null).commit();
                }
                else if (position==2){
                    Bundle bundle = new Bundle();
                    bundle.putInt("group",R.mipmap.ns);
                    Fragment fragment = new GroupsYours();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainFrame, fragment).addToBackStack(null).commit();
                }
                else if (position==3){
                    Bundle bundle = new Bundle();
                    bundle.putInt("group",R.mipmap.fin);
                    Fragment fragment = new GroupsYours();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainFrame, fragment).addToBackStack(null).commit();

                }
                else if (position==4){
                    Bundle bundle = new Bundle();
                    bundle.putInt("group",R.mipmap.ds);
                    Fragment fragment = new GroupsYours();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainFrame, fragment).addToBackStack(null).commit();
                }
                else if (position==5) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("group",R.mipmap.mo);
                    Fragment fragment = new GroupsYours();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainFrame, fragment).addToBackStack(null).commit();
                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()

        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){

                }
                else if (position==1){
                    Bundle bundle = new Bundle();
                    bundle.putInt("group",R.mipmap.bmp);
                    Fragment fragment = new CreateGroups_frag();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainFrame, fragment).addToBackStack(null).commit();
                }
                else if (position==2){
                    Bundle bundle = new Bundle();
                    bundle.putInt("group",R.mipmap.ns);
                    Fragment fragment = new CreateGroups_frag();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainFrame, fragment).addToBackStack(null).commit();
                }
                else if (position==3){
                    Bundle bundle = new Bundle();
                    bundle.putInt("group",R.mipmap.fin);
                    Fragment fragment = new CreateGroups_frag();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainFrame, fragment).addToBackStack(null).commit();

                }
                else if (position==4){
                    Bundle bundle = new Bundle();
                    bundle.putInt("group",R.mipmap.ds);
                    Fragment fragment = new CreateGroups_frag();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainFrame, fragment).addToBackStack(null).commit();
                }
                else if (position==5) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("group",R.mipmap.mo);
                    Fragment fragment = new CreateGroups_frag();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainFrame, fragment).addToBackStack(null).commit();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()

        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                }
                else if (position==1){

                }
                else if (position==2){

                }
                else if (position==3){


                }
                else if (position==4){

                }
                else if (position==5) {

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()

        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){

                }
                else if (position==1){

                }
                else if (position==2){

                }
                else if (position==3){


                }
                else if (position==4){

                }
                else if (position==5) {

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return root;

    }


    @Override
    public void onClick(View v) {

    }
}


