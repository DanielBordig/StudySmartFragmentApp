package com.example.danielbordig.studyssmartfragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class HWC_frag extends Fragment implements AdapterView.OnItemClickListener, View.OnClickListener {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    ListView homeworkCalendarList;
    ArrayList<HashMap<String,String>> hwcList;
    Button weekBut, allHomeworkBut;
    CalendarController cc = new CalendarController();

    // Array of integers pointing to course images
    int[] coursesWeek = new int[]{
            R.drawable.bmp,
            R.drawable.ns,
            R.drawable.bmp
    };

    int[] coursesAll = new int[]{
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
            R.drawable.ns
    };

    // Array of strings storing descriptions for one week of homework
    String[] descriptionsWeek = new String[] {
            "Monday - 39 Aug.\n" +
                    "Session 3 - 13682 pages",
            "Wednesday - 56 Okt.\n" +
                    "Session 6 - 583 pages",
            "Missing description 0"
    };

    // Array of strings storing descriptions all homework
    String[] descriptionAll = new String[] {
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
            "Missing description 8"
    };

    // Array of strings storing details for one week of homework
    String[] detailsAll = new String[] {
            "This homework is awesome, you better read it.\nBook: Naruto 1-72",
            "This homework sucks, and is not recommended as necessary.\nBook: Fifty Shades of Grey",
            "Missing details 0",
            "Missing details 1",
            "Missing details 2",
            "Missing details 3",
            "Missing details 4",
            "Missing details 5",
            "Missing details 6",
            "Missing details 7",
            "Missing details 8"
    };

    public HWC_frag() {
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
        View root = inflater.inflate(R.layout.fragment_hwc, container, false);

        weekBut = (Button) root.findViewById(R.id.weekBut);
        weekBut.setTextColor(Color.WHITE);
        weekBut.setBackgroundColor(Color.BLUE);
        weekBut.setOnClickListener(this);
        allHomeworkBut = (Button) root.findViewById(R.id.allHomeworkBut);
        allHomeworkBut.setOnClickListener(this);

        // Each row in the list stores course image and description
        hwcList = cc.calenderCreate(coursesWeek, descriptionsWeek);

        homeworkCalendarList = ( ListView ) root.findViewById(R.id.listHWC);
        updateCalender(hwcList);
        homeworkCalendarList.setOnItemClickListener(this);

        return root;
    }

    public void updateCalender(ArrayList HWC){
        // Keys used in Hashmap
        String[] from = { "course","txt" };

        // Ids of views in listview_layout
        int[] to = {R.id.course,R.id.txt};

        // Instantiating an adapter to store each item
        // R.layout.listview_layout defines the layout of each item
        SimpleAdapter adapter = new SimpleAdapter(getActivity(), HWC, R.layout.listview_layout, from, to);

        homeworkCalendarList.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String deta = detailsAll[position];
        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
        dialog.setTitle("Homework details:");
        dialog.setMessage(deta);
        dialog.setNegativeButton("Done", new AlertDialog.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), "trylle trylle og nu er lektien væk...\n...\nnæsten", Toast.LENGTH_LONG).show();
            }
        });
        dialog.setPositiveButton("Read Later", new AlertDialog.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), "trylle trylle og nu er lektien udskudt... næsten", Toast.LENGTH_LONG).show();
            }
        });
        dialog.show();

    }

    @Override
    public void onClick(View v) {
        if(v==weekBut){
            allHomeworkBut.setTextColor(Color.BLACK);
            allHomeworkBut.setBackgroundColor(Color.WHITE);
            allHomeworkBut.setClickable(true);
            weekBut.setTextColor(Color.WHITE);
            weekBut.setBackgroundColor(Color.BLUE);
            weekBut.setClickable(false);
            hwcList = cc.calenderCreate(coursesWeek, descriptionsWeek);
            updateCalender(hwcList);
        }
        if(v== allHomeworkBut) {
            weekBut.setTextColor(Color.BLACK);
            weekBut.setBackgroundColor(Color.WHITE);
            weekBut.setClickable(true);
            allHomeworkBut.setTextColor(Color.WHITE);
            allHomeworkBut.setBackgroundColor(Color.BLUE);
            allHomeworkBut.setClickable(false);
            hwcList = cc.calenderCreate(coursesAll, descriptionAll);
            updateCalender(hwcList);
        }
    }
}
