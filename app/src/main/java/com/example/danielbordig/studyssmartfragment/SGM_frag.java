package com.example.danielbordig.studyssmartfragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class SGM_frag extends Fragment implements AdapterView.OnItemClickListener, View.OnClickListener {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    TextView Header, UnderHeader;
    ListView GroupList;
    int[] Groups = {R.drawable.bmp, R.drawable.ns,};
    String[] Emne = {"", "",};

    String[] homeworkoverview = new String[]{
            "This homework is awesome, lets start.\nBook: Naruto 1-72",
            "This homework sucks, I don't want to study today.\nBook: Fifty Shades of Grey",
            "Item 1",
            "Item 2",
            "Item 3",
            "Itme 4",
            "Item 5",
            "Item 6",
    };

    public SGM_frag() {
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_sgm, container, false);

        Header = (TextView) root.findViewById(R.id.headerSGM);
        UnderHeader = (TextView) root.findViewById(R.id.underheaderSGM);
        GroupList = ( ListView ) root.findViewById(R.id.listSGM);

        NewGameItem[] data = new NewGameItem[] {
                new NewGameItem(R.drawable.ns_big),
                new NewGameItem(R.drawable.ns_big),
                new NewGameItem(R.drawable.ns_big),
                new NewGameItem(R.drawable.bmp_big),
                new NewGameItem(R.drawable.bmp_big),
                new NewGameItem(R.drawable.bmp_big),
                new NewGameItem(R.drawable.bmp_big),
                new NewGameItem(R.drawable.bmp_big),
                new NewGameItem(R.drawable.bmp_big)
        };

        NewGameAdapter newGameAdapter = new NewGameAdapter(getActivity(), R.layout.new_game_list_row, data);

        ArrayAdapter adapter = new ArrayAdapter(getActivity(), R.layout.listview_layout, R.id.txt, Emne) {
            @Override
            public View getView(int position, View cachedView, ViewGroup parent) {
                View view = super.getView(position, cachedView, parent);
                System.out.println("Loop");
                TextView beskrivelse = (TextView) view.findViewById(R.id.txt);
                beskrivelse.setText("");
                ImageView billede = (ImageView) view.findViewById(R.id.course);
                billede.setImageResource(Groups[position]);
                return view;
            }
        };
        GroupList.setAdapter(newGameAdapter);
        return root;
    }



    @Override
    public void onClick(View v) {
//        if(v==a){
//            b.setTextColor(Color.BLACK);
//            b.setBackgroundColor(Color.WHITE);
//            b.setClickable(true);
//    }
//        if(v==b) {
//            a.setTextColor(Color.BLACK);
//            a.setBackgroundColor(Color.WHITE);
//            a.setClickable(true);

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String hmover = homeworkoverview[position];

        Intent intentBundle = new Intent(getActivity(), HomeworkDetails.class);
        Bundle bundle = new Bundle();

        bundle.putString("detail", hmover);
        intentBundle.putExtra("detailBundle", bundle);
        startActivity(new Intent(intentBundle));

    }
}
