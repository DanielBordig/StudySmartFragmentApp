package com.example.danielbordig.studyssmartfragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class GroupsActivity extends Activity implements AdapterView.OnItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_groups);

        // setContentView(R.layout.activity_groups);
        String[] groups = {"your groups", "find groups", "create groups", "delete groups", "more"};
        Spinner spinner = (Spinner) findViewById(R.id.creatgroupspin);
        spinner.setOnItemSelectedListener(this);

        // Standard-udseende
        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.spinner_elements, R.id.overskrift, groups);
        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Eget layout af listeelementerne
       // ArrayAdapter adapter = new ArrayAdapter(this, R.layout.listview_hwc_layout, R.id.listeelem_overskrift, lande);
        //adapter.setDropDownViewResource(R.layout.listview_hwc_layout);

        spinner.setAdapter(adapter);
        //spinner.setPrompt("Vælg et land");

    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "Klik på " + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(this, "Intet valgt", Toast.LENGTH_SHORT).show();
    }
}
 // tesning recommit again