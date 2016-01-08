package com.example.danielbordig.studyssmartfragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ReadLater_frag extends Fragment implements AdapterView.OnItemClickListener, View.OnClickListener {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    TextView Header, UnderHeader;
    ListView GroupList;
    // ArrayList<Integer> groups = new ArrayList<Integer>();
    int[] Groups = {
            R.drawable.bmp,
            R.drawable.ns,
            R.drawable.bmp,
            R.drawable.ns,
            R.drawable.bmp,
            R.drawable.bmp,
            R.drawable.ns,
            R.drawable.bmp,
            R.drawable.bmp,
            R.drawable.ns,
            R.drawable.ns,
    };

    String[] Emne = {
            "Monday - 39 Aug.\n" +
                    "Session 3 - 13682 pages",
            "Wednesday - 56 Okt.\n" +
                    "Session 6 - 583 pages",
            "Missing description 0",
            "Missing description 1",
            "Missing description 2",
            "Missing description 3",
            "Missing description 4",
            "Missing description 5",
            "Missing description 6",
            "Missing description 7",
            "Missing description 8",
    };




    public ReadLater_frag() {
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
        View root = inflater.inflate(R.layout.fragment_readlater, container, false);


        Header = (TextView) root.findViewById(R.id.headerReadlater);
        UnderHeader = (TextView) root.findViewById(R.id.underheaderReadlater);
        GroupList = ( ListView ) root.findViewById(R.id.listReadlater);


        ArrayAdapter adapter = new ArrayAdapter(getActivity(), R.layout.listview_layout, R.id.txt, Emne) {
            @Override
            public View getView(int position, View cachedView, ViewGroup parent) {
                View view = super.getView(position, cachedView, parent);
                TextView beskrivelse = (TextView) view.findViewById(R.id.txt);
                beskrivelse.setText(Emne[position]);
                ImageView billede = (ImageView) view.findViewById(R.id.course);
                billede.setImageResource(Groups[position]);
                return view;
            }
        };
        GroupList.setAdapter(adapter);
        return root;
    }



    @Override
    public void onClick(View v) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
