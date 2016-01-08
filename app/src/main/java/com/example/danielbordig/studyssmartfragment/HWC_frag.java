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
    Button weekBut, allHomeworkBut, donedone;
    ArrayList<HashMap<String,String>> hwcList;
    ArrayList<HomeworkDTO> homeworkListWeek;
    ArrayList<HomeworkDTO> homeworkListAll;
    CalendarController cc = new CalendarController();
    ArrayDatabase arrayDatabase = new ArrayDatabase();
    HomeworkDAO homeworkDAO = new HomeworkDAO();
    Done_frag done = new Done_frag();
    Fragment done_frag = new Done_frag();

    // Array of integers pointing to course images
    ArrayList<Integer> coursesWeek = new ArrayList<>();

    ArrayList<Integer> coursesAll = new ArrayList<>();

    // Array of strings storing descriptions for one week of homework
    ArrayList<String> descriptionsWeek = new ArrayList<>();

    // Array of strings storing descriptions all homework
    ArrayList<String> descriptionsAll = new ArrayList<>();

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
        weekBut.setClickable(false);

        allHomeworkBut = (Button) root.findViewById(R.id.allHomeworkBut);
        allHomeworkBut.setTextColor(Color.BLACK);
        allHomeworkBut.setBackgroundColor(Color.WHITE);
        allHomeworkBut.setOnClickListener(this);

        donedone = (Button) root.findViewById(R.id.donedone);
        donedone.setOnClickListener(this);

        homeworkListWeek = new ArrayList<>();
        homeworkListAll = new ArrayList<>();

        for(int i = 0; i < arrayDatabase.getCoursesAll().size(); i++){
            homeworkListAll.add(new HomeworkDTO(arrayDatabase.coursesAll.get(i), arrayDatabase.descriptionsAll.get(i), arrayDatabase.getDetailsAll().get(i)));
        }

        for(int i = 0; i < 3; i++){
            homeworkListWeek.add(new HomeworkDTO(arrayDatabase.coursesAll.get(i), arrayDatabase.descriptionsAll.get(i), arrayDatabase.getDetailsAll().get(i)));
        }

        coursesWeek.add(R.drawable.bmp);
        coursesWeek.add(R.drawable.ns);
        coursesWeek.add(R.drawable.bmp);

        coursesAll.add(R.drawable.bmp);
        coursesAll.add(R.drawable.ns);
        coursesAll.add(R.drawable.bmp);
        coursesAll.add(R.drawable.ns);
        coursesAll.add(R.drawable.bmp);
        coursesAll.add(R.drawable.bmp);
        coursesAll.add(R.drawable.ns);
        coursesAll.add(R.drawable.bmp);
        coursesAll.add(R.drawable.bmp);
        coursesAll.add(R.drawable.ns);
        coursesAll.add(R.drawable.ns);
        coursesAll.add(R.mipmap.fin);
        coursesAll.add(R.mipmap.ds);
        coursesAll.add(R.mipmap.mo);

        descriptionsWeek.add("Monday - 39 Aug.\nSession 3 - 13682 pages");
        descriptionsWeek.add("Wednesday - 56 Okt.\nSession 6 - 583 pages");
        descriptionsWeek.add("Missing description 0");

        descriptionsAll.add("Monday - 39 Aug.\nSession 3 - 13682 pages");
        descriptionsAll.add("Wednesday - 56 Okt.\nSession 6 - 583 pages");
        descriptionsAll.add("Missing description 0");
        descriptionsAll.add("Missing description 1");
        descriptionsAll.add("Missing description 2");
        descriptionsAll.add("Missing description 3");
        descriptionsAll.add("Missing description 4");
        descriptionsAll.add("Missing description 5");
        descriptionsAll.add("Missing description 6");
        descriptionsAll.add("Missing description 7");
        descriptionsAll.add("Missing description 8");

        // Each row in the list stores course image and description
        hwcList = cc.calenderCreate(homeworkListWeek);

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
    public void onItemClick(AdapterView<?> parent, View view, final int position, final long id) {
        String deta = homeworkListAll.get(position).detail;
        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
        dialog.setTitle("Homework details:");
        dialog.setMessage(deta);
        dialog.setNegativeButton("Done", new AlertDialog.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                HomeworkDTO homeworkMove = homeworkListAll.get(position);
                homeworkListAll.remove(position);
                if (position < homeworkListWeek.size()) homeworkListWeek.remove(position);

//                int coursesMove = homeworkListAll.get(position).course;
//                coursesAll.remove(position);
//
//                String descriptionMove = descriptionsAll.get(position);
//                descriptionsAll.remove(position);
//                if (position < descriptionsWeek.size()) descriptionsWeek.remove(position);

                //done.update(coursesMove, descriptionMove);
                if (!weekBut.isClickable())
                    hwcList = cc.calenderCreate(homeworkListWeek);
                else if (!allHomeworkBut.isClickable())
                    hwcList = cc.calenderCreate(homeworkListAll);

                updateCalender(hwcList);
                done.update(homeworkMove.course, homeworkMove.description);
                homeworkDAO.updateDoneHomework(homeworkMove);
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
            weekBut.setTextColor(Color.WHITE);
            weekBut.setBackgroundColor(Color.BLUE);
            weekBut.setClickable(false);
            allHomeworkBut.setTextColor(Color.BLACK);
            allHomeworkBut.setBackgroundColor(Color.WHITE);
            allHomeworkBut.setClickable(true);
            hwcList = cc.calenderCreate(homeworkListWeek);
            updateCalender(hwcList);
        }
        if(v== allHomeworkBut) {
            allHomeworkBut.setTextColor(Color.WHITE);
            allHomeworkBut.setBackgroundColor(Color.BLUE);
            allHomeworkBut.setClickable(false);
            weekBut.setTextColor(Color.BLACK);
            weekBut.setBackgroundColor(Color.WHITE);
            weekBut.setClickable(true);
            hwcList = cc.calenderCreate(homeworkListAll);
            updateCalender(hwcList);
        }
        if(v==donedone){
            getFragmentManager().beginTransaction().replace(R.id.mainFrame, done_frag).commit();
        }
    }
}
