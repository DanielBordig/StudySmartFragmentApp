package com.example.danielbordig.studyssmartfragment;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Fragment fragment_main = new Main_frag();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("StudySmart");
        getFragmentManager().beginTransaction().add(R.id.mainFrame, fragment_main).commit();
    }
}
