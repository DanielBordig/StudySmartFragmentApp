package com.example.danielbordig.studyssmartfragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class HWC_frag extends Fragment implements AdapterView.OnItemClickListener, View.OnClickListener {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    ListView homeworkCalendarList;
    TextView headerHWC;
    Button weekBut, allHomeworkBut, donedone, later;
    ArrayList<HashMap<String,String>> hwcList;
    ArrayList<HomeworkDTO> homeworkListWeek;
    ArrayList<HomeworkDTO> homeworkListAll;
    ArrayList<String> printingList;
    CalendarController cc = new CalendarController();
//    ArrayDatabase arrayDatabase = new ArrayDatabase();
    HomeworkDAO homeworkDAO = new HomeworkDAO();
    Fragment fragment_done = new Done_frag();
    Fragment fragment_later = new ReadLater_frag();

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

        headerHWC = (TextView) root.findViewById(R.id.headerHWC);

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

        later = (Button) root.findViewById(R.id.later);
        later.setOnClickListener(this);

//        homeworkListWeek = arrayDatabase.getHomeworkListWeek();
//        homeworkListAll = arrayDatabase.getHomeworkListAll();
//        printingList = arrayDatabase.getPrintingList();

        // Each row in the list stores course image and description
        hwcList = cc.calenderCreate(homeworkListWeek);

        homeworkCalendarList = ( ListView ) root.findViewById(R.id.listHWC);
        //updateCalender(hwcList);
        homeworkCalendarList.setAdapter(new MinAdapterMedOverskrifter());
        homeworkCalendarList.setOnItemClickListener(this);

        return root;
    }

    public class MinAdapterMedOverskrifter extends BaseAdapter {

        public int getCount() {
            return printingList.size();
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        /**
         * Skal give typen af elementet der skal vises.
         * 0 er normale lande, 1 er kategorier og 2 er overskrifter
         */
        @Override
        public int getItemViewType(int position) {
            String landEllerOverskrift = printingList.get(position);
            if (landEllerOverskrift.startsWith("date")) return 0;
            return 1;
        }

        @Override
        public int getViewTypeCount() {
            return 2;
        }

        public View getView(final int position, View view, ViewGroup parent) {
            int typen = getItemViewType(position);

            if (view == null) {
                // Vi skal oprette et nyt view afhængig af typen
                if (typen == 0) {
                    view = getActivity().getLayoutInflater().inflate(android.R.layout.simple_list_item_1, null);
                } else {
                    view = getActivity().getLayoutInflater().inflate(R.layout.lekt04_listeelement, null);
                }
            }

            String landEllerOverskrift = printingList.get(position);
            // Sæt indholdet afhængig af typen
            if (typen == 0) {
                landEllerOverskrift = landEllerOverskrift.substring(4);
                    TextView tv = (TextView) view.findViewById(android.R.id.text1);
                    tv.setTextSize(22);
                tv.setGravity(Gravity.CENTER);
                tv.setText(landEllerOverskrift);
            } else {
                ImageView im = (ImageView) view.findViewById(R.id.listeelem_billede);
                im.setImageResource(homeworkListAll.get(position).course);
                TextView tvo = (TextView) view.findViewById(R.id.listeelem_overskrift);
                tvo.setText(landEllerOverskrift);
            }

            return view;
        }

        @Override
        public boolean isEnabled(int position) {
            return getItemViewType(position) > 1;
        }
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

                if (!weekBut.isClickable())
                    hwcList = cc.calenderCreate(homeworkListWeek);
                else
                    hwcList = cc.calenderCreate(homeworkListAll);

                //updateCalender(hwcList);
                homeworkCalendarList.setAdapter(new MinAdapterMedOverskrifter());
                homeworkDAO.updateDoneHomework(homeworkMove);
            }
        });
        dialog.setPositiveButton("Read Later", new AlertDialog.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                HomeworkDTO homeworkMove = homeworkListAll.get(position);
                homeworkListAll.remove(position);
                if (position < homeworkListWeek.size()) homeworkListWeek.remove(position);

                if (!weekBut.isClickable())
                    hwcList = cc.calenderCreate(homeworkListWeek);
                else if (!allHomeworkBut.isClickable())
                    hwcList = cc.calenderCreate(homeworkListAll);

                //updateCalender(hwcList);
                homeworkCalendarList.setAdapter(new MinAdapterMedOverskrifter());
                homeworkDAO.updateLaterHomework(homeworkMove);
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
            homeworkCalendarList.setAdapter(new MinAdapterMedOverskrifter());
        }
        if(v== allHomeworkBut) {
            allHomeworkBut.setTextColor(Color.WHITE);
            allHomeworkBut.setBackgroundColor(Color.BLUE);
            allHomeworkBut.setClickable(false);
            weekBut.setTextColor(Color.BLACK);
            weekBut.setBackgroundColor(Color.WHITE);
            weekBut.setClickable(true);
            hwcList = cc.calenderCreate(homeworkListAll);
            homeworkCalendarList.setAdapter(new MinAdapterMedOverskrifter());
        }
        if(v==donedone){
            getFragmentManager().beginTransaction().replace(R.id.mainFrame, fragment_done).commit();
        }
        if(v==later){
            getFragmentManager().beginTransaction().replace(R.id.mainFrame, fragment_later).commit();
        }
    }
}
