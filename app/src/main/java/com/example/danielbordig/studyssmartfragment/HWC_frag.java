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
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.client.Firebase;

import java.util.ArrayList;

public class HWC_frag extends Fragment implements AdapterView.OnItemClickListener, View.OnClickListener {

    Singleton st;
    int offset = 0;
    ListView homeworkCalendarList;
    TextView headerHWC, noRemainingHomework;
    Button weekBut, futureHomeworkBut;
    ArrayList<HomeworkDTO> homeworkListWeek;
    ArrayList<HomeworkDTO> homeworkListFuture;
    ArrayList<String> printingListDesciptionWeek;
    ArrayList<Integer> printingListCourseWeek;
    ArrayList<String> printingListDesciptionFuture;
    ArrayList<Integer> printingListCourseFuture;
    ArrayList<Integer> offsetPosition;
    static ArrayDatabase arrayDatabase;
    HomeworkDAO homeworkDAO = new HomeworkDAO();
    static boolean firstCreate = true;

    public HWC_frag() {
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
        noRemainingHomework = (TextView) root.findViewById(R.id.noRemainingHomework);

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
        printingListDesciptionWeek = arrayDatabase.getPrintingListWeek();
        printingListCourseWeek = arrayDatabase.getPrintingCourseWeek();
        printingListDesciptionFuture = arrayDatabase.getPrintingListFuture();
        printingListCourseFuture = arrayDatabase.getPrintingCourseFuture();
        offsetPosition = new ArrayList<>();
        offsetPosition = getOffsetPosition();

        homeworkCalendarList = ( ListView ) root.findViewById(R.id.listHWC);
        HomeworkWithTitlesAdapter homeworkWithTitlesAdapter = new HomeworkWithTitlesAdapter(getActivity(), R.layout.listview_hwc_layout,
                                                                                            printingListDesciptionWeek, printingListCourseWeek);
        homeworkCalendarList.setAdapter(homeworkWithTitlesAdapter);
        homeworkCalendarList.setOnItemClickListener(this);

        return root;
    }

    public ArrayList<Integer> getOffsetPosition(){
        for(int i = 0; i < printingListDesciptionFuture.size(); i++){
            if(printingListDesciptionFuture.get(i).startsWith("date")) offset++;
            offsetPosition.add(offset);
        }
        return offsetPosition;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, final int position, final long id) {
        String detail = "";
        if(!weekBut.isClickable()) detail = homeworkListWeek.get(position-offsetPosition.get(position)).detail;
        if(!futureHomeworkBut.isClickable()) detail = homeworkListFuture.get(position-offsetPosition.get(position)).detail;
        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
        dialog.setTitle("Homework details:");
        dialog.setMessage(detail);
        dialog.setNegativeButton("Done", new AlertDialog.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                HomeworkDTO homeworkMove = homeworkListFuture.get(position - offsetPosition.get(position));
                homeworkListFuture.remove(position - offsetPosition.get(position));
                printingListDesciptionFuture.remove(position);
                printingListCourseFuture.remove(position);
                if (position < printingListDesciptionWeek.size()) {
                    printingListDesciptionWeek.remove(position);
                    printingListCourseWeek.remove(position);
                    homeworkListWeek.remove(position - offsetPosition.get(position));
                }
                updatePrintingList();

                if (!weekBut.isClickable()) {
                    homeworkCalendarList.setAdapter(new HomeworkWithTitlesAdapter(getActivity(), R.layout.listview_hwc_layout,
                            printingListDesciptionWeek, printingListCourseWeek));
                } else if (!futureHomeworkBut.isClickable()) {
                    homeworkCalendarList.setAdapter(new HomeworkWithTitlesAdapter(getActivity(), R.layout.listview_hwc_layout,
                            printingListDesciptionFuture, printingListCourseFuture));
                }
                homeworkDAO.updateDoneHomework(homeworkMove);

                if(!weekBut.isClickable() && printingListDesciptionWeek.isEmpty()) noRemainingHomework.setText("No more homework this week");
                if(!futureHomeworkBut.isClickable() && printingListDesciptionFuture.isEmpty()) noRemainingHomework.setText("No more future homework at the moment");
            }
        });
        dialog.setPositiveButton("Read Later", new AlertDialog.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                HomeworkDTO homeworkMove = homeworkListFuture.get(position - offsetPosition.get(position));
                homeworkListFuture.remove(position - offsetPosition.get(position));
                printingListDesciptionFuture.remove(position);
                printingListCourseFuture.remove(position);
                if (position < printingListDesciptionWeek.size()) {
                    printingListDesciptionWeek.remove(position);
                    printingListCourseWeek.remove(position);
                    homeworkListWeek.remove(position - offsetPosition.get(position));
                }
                updatePrintingList();

                if (!weekBut.isClickable()) {
                    homeworkCalendarList.setAdapter(new HomeworkWithTitlesAdapter(getActivity(), R.layout.listview_hwc_layout,
                            printingListDesciptionWeek, printingListCourseWeek));
                } else if (!futureHomeworkBut.isClickable()) {
                    homeworkCalendarList.setAdapter(new HomeworkWithTitlesAdapter(getActivity(), R.layout.listview_hwc_layout,
                            printingListDesciptionFuture, printingListCourseFuture));
                }
                homeworkDAO.updateLaterHomework(homeworkMove);

                if(!weekBut.isClickable() && printingListDesciptionWeek.isEmpty()) noRemainingHomework.setText("No more homework this week");
                if(!futureHomeworkBut.isClickable() && printingListDesciptionFuture.isEmpty()) noRemainingHomework.setText("No more future homework at the moment");
            }
        });
        dialog.show();
    }

    public void updatePrintingList(){
        int lastIndex = printingListDesciptionFuture.size()-1;
        if(printingListDesciptionFuture.get(lastIndex).startsWith("date")){
            printingListDesciptionFuture.remove(lastIndex);
            printingListCourseFuture.remove(lastIndex);
            if(lastIndex < printingListDesciptionWeek.size()){
                printingListDesciptionWeek.remove(lastIndex);
                printingListCourseWeek.remove(lastIndex);
            }
        }
        for(int i = 0; i < printingListDesciptionFuture.size(); i++){
            if(printingListDesciptionFuture.get(i).startsWith("date")){
                if(printingListDesciptionFuture.get(i+1).startsWith("date")){
                    printingListDesciptionFuture.remove(i);
                    printingListCourseFuture.remove(i);
                    if(i < printingListDesciptionWeek.size()){
                        printingListDesciptionWeek.remove(i);
                        printingListCourseWeek.remove(i);
                    }
                    offsetPosition = getOffsetPosition();
                }
            }
        }
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
            homeworkCalendarList.setAdapter(new HomeworkWithTitlesAdapter(getActivity(), R.layout.listview_hwc_layout,
                    printingListDesciptionWeek, printingListCourseWeek));
            if(printingListDesciptionWeek.isEmpty()) noRemainingHomework.setText("No more homework this week");
            else noRemainingHomework.setText("");
        }
        if(v==futureHomeworkBut) {
            futureHomeworkBut.setTextColor(Color.WHITE);
            futureHomeworkBut.setBackgroundColor(Color.BLUE);
            futureHomeworkBut.setClickable(false);
            weekBut.setTextColor(Color.BLACK);
            weekBut.setBackgroundColor(Color.WHITE);
            weekBut.setClickable(true);
            homeworkCalendarList.setAdapter(new HomeworkWithTitlesAdapter(getActivity(), R.layout.listview_hwc_layout,
                                            printingListDesciptionFuture, printingListCourseFuture));
            if(printingListDesciptionFuture.isEmpty()) noRemainingHomework.setText("No more future homework at the moment");
            else noRemainingHomework.setText("");
        }
    }
}
