package com.example.danielbordig.studyssmartfragment;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.client.Firebase;

import java.util.ArrayList;

public class HWC_frag_testing extends Fragment implements AdapterView.OnItemClickListener, View.OnClickListener {

    Singleton st;
    ListView homeworkCalendarList;
    TextView headerHWC;
    Button weekBut, futureHomeworkBut;
    ArrayList<HomeworkDTO> homeworkListWeek;
    ArrayList<HomeworkDTO> homeworkListFuture;
    ArrayList<String> printingList;
    static ArrayDatabase arrayDatabase;
    HomeworkDAO homeworkDAO = new HomeworkDAO();
    static boolean firstCreate = true;

    public HWC_frag_testing() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(getActivity());
        if(firstCreate) arrayDatabase = new ArrayDatabase(); firstCreate = false;
        st = Singleton.st;
        st.visDrawer = true;
        st.startDrawer();
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

        futureHomeworkBut = (Button) root.findViewById(R.id.futureHomeworkBut);
        futureHomeworkBut.setTextColor(Color.BLACK);
        futureHomeworkBut.setBackgroundColor(Color.WHITE);
        futureHomeworkBut.setOnClickListener(this);

        homeworkListWeek = arrayDatabase.getHomeworkWeekList();
        homeworkListFuture = arrayDatabase.getHomeworkFutureList();
        printingList = arrayDatabase.getPrintingListAll();

        homeworkCalendarList = ( ListView ) root.findViewById(R.id.listHWC);
        HomeworkAdapter homeworkAdapter = new HomeworkAdapter(getActivity(),R.layout.listview_hwc_layout, homeworkListWeek);
        homeworkCalendarList.setAdapter(homeworkAdapter);
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
                    view = getActivity().getLayoutInflater().inflate(R.layout.listview_hwc_layout, null);
                }
            }

            String landEllerOverskrift = printingList.get(position);
            // Sæt indholdet afhængig af typen
            if (typen == 0) {
                landEllerOverskrift = landEllerOverskrift.substring(4);
                TextView tv = (TextView) view.findViewById(android.R.id.text1);
                tv.setTextSize(22);
                tv.setText(landEllerOverskrift);
            } else {
                ImageView im = (ImageView) view.findViewById(R.id.listeelem_billede);
//                im.setImageResource(homeworkListFuture.get(position).course);
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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, final int position, final long id) {
        String detail = "";
        if(futureHomeworkBut.isClickable()) detail = homeworkListWeek.get(position).detail;
        if(weekBut.isClickable()) detail = homeworkListFuture.get(position).detail;
        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
        dialog.setTitle("Homework details:");
        dialog.setMessage(detail);
        dialog.setNegativeButton("Done", new AlertDialog.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                HomeworkDTO homeworkMove = homeworkListFuture.get(position);
                homeworkListFuture.remove(position);
                if (position < homeworkListWeek.size()) homeworkListWeek.remove(position);

                if (!weekBut.isClickable()) {
                    homeworkCalendarList.setAdapter(new HomeworkAdapter(getActivity(),R.layout.listview_hwc_layout, homeworkListWeek));
                } else if (!futureHomeworkBut.isClickable()) {
                    homeworkCalendarList.setAdapter(new HomeworkAdapter(getActivity(),R.layout.listview_hwc_layout, homeworkListFuture));
                }
                homeworkDAO.updateDoneHomework(homeworkMove);
            }
        });
        dialog.setPositiveButton("Read Later", new AlertDialog.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                HomeworkDTO homeworkMove = homeworkListFuture.get(position);
                homeworkListFuture.remove(position);
                if (position < homeworkListWeek.size()) homeworkListWeek.remove(position);

                if (!weekBut.isClickable()) {
                    homeworkCalendarList.setAdapter(new HomeworkAdapter(getActivity(),R.layout.listview_hwc_layout, homeworkListWeek));
                } else if (!futureHomeworkBut.isClickable()) {
                    homeworkCalendarList.setAdapter(new HomeworkAdapter(getActivity(),R.layout.listview_hwc_layout, homeworkListFuture));
                }
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
            futureHomeworkBut.setTextColor(Color.BLACK);
            futureHomeworkBut.setBackgroundColor(Color.WHITE);
            futureHomeworkBut.setClickable(true);
            homeworkCalendarList.setAdapter(new HomeworkAdapter(getActivity(),R.layout.listview_hwc_layout, homeworkListWeek));
        }
        if(v== futureHomeworkBut) {
            futureHomeworkBut.setTextColor(Color.WHITE);
            futureHomeworkBut.setBackgroundColor(Color.BLUE);
            futureHomeworkBut.setClickable(false);
            weekBut.setTextColor(Color.BLACK);
            weekBut.setBackgroundColor(Color.WHITE);
            weekBut.setClickable(true);
            homeworkCalendarList.setAdapter(new HomeworkAdapter(getActivity(),R.layout.listview_hwc_layout, homeworkListFuture));
        }
    }
}
