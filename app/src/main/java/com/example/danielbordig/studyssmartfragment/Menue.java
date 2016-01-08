package com.example.danielbordig.studyssmartfragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by jose on 1/7/2016.
 */
class Menue extends Activity implements AdapterView.OnItemClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] lande = {"Danmark", "Norge", "Sverige", "Finland",
                "Holland", "Italien", "Tyskland", "Frankrig", "Spanien", "Portugal",
                "Nepal", "Indien", "Kina", "Japan", "Thailand"};
        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.lekt04_listeelement, R.id.listeelem_overskrift, lande);

        ListView listView = new ListView(this);
        listView.setOnItemClickListener(this);
        listView.setAdapter(adapter);

        setContentView(listView);
    }

    public void onItemClick(AdapterView<?> liste, View v, int position, long id) {
        Toast.makeText(this, "Klik på " + position, Toast.LENGTH_SHORT).show();
        // v vil pege på det LinearLayout der er roden i R.layout.lekt04_listeelement
        //Toast.makeText(this, " v = " + v, Toast.LENGTH_SHORT).show();
    }
}
