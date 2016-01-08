package com.example.danielbordig.studyssmartfragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.Toast;

public class GroupsActivity extends Activity implements AdapterView.OnItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);
        String[] lande = {"Danmark", "Norge", "Sverige", "Finland",
                "Holland", "Italien", "Tyskland", "Frankrig", "Spanien", "Portugal",
                "Nepal", "Indien", "Kina", "Japan", "Thailand"};
        Spinner spinner = new Spinner(this);
        spinner.setOnItemSelectedListener(this);

        // Standard-udseende
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, android.R.id.text1, lande);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Eget layout af listeelementerne
       // ArrayAdapter adapter = new ArrayAdapter(this, R.layout.lekt04_listeelement, R.id.listeelem_overskrift, lande);
        //adapter.setDropDownViewResource(R.layout.lekt04_listeelement);

        spinner.setAdapter(adapter);
        spinner.setPrompt("Vælg et land");

        TableLayout tl = new TableLayout(this);
        tl.addView(spinner);
        setContentView(tl);
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
