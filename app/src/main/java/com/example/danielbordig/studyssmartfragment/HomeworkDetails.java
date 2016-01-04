package com.example.danielbordig.studyssmartfragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class HomeworkDetails extends AppCompatActivity implements View.OnClickListener {

    TextView header;
    Button doneBut, laterBut;
    LayoutInflater layoutIn;
    PopupWindow popupWindow;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homework_details);
        Intent intentExtras = getIntent();
        Bundle bundle = intentExtras.getBundleExtra("detailBundle");
        String s = bundle.getString("detail");

//        layoutIn = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
//        ViewGroup container = (ViewGroup) layoutIn.inflate(R.layout.homework_details, null);
//        linearLayout = (LinearLayout) findViewById(R.id.homework_details);
//        popupWindow = new PopupWindow(container, 400, 400, false);
//        popupWindow.showAtLocation(linearLayout, Gravity.NO_GRAVITY, 500, 500);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        header = (TextView) findViewById(R.id.headerDetails);
        doneBut = (Button) findViewById(R.id.doneBut);
        laterBut = (Button) findViewById(R.id.laterBut);

        header.setText(s);
        getWindow().setLayout((int) (width * .75), (int) (height * .55));

        doneBut.setOnClickListener(this);
        laterBut.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "I can't do anything yet :(", Toast.LENGTH_SHORT).show();
    }
}
