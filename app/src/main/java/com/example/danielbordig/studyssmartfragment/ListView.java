package com.example.danielbordig.studyssmartfragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

/**
 * Created by jose on 1/7/2016.
 */
public class ListView extends Activity implements AdapterView.OnItemClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] lande = {"Danmark", "Norge", "Sverige", "Finland",
                "Holland", "Italien", "Tyskland", "Frankrig", "Spanien", "Portugal",
                "Nepal", "Indien", "Kina", "Japan", "Thailand"};
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1, lande);

        android.widget.ListView listView = new android.widget.ListView(this);
        listView.setOnItemClickListener(this);
        listView.setAdapter(adapter);

        setContentView(listView);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
