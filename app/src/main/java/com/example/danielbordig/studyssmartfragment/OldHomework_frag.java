package com.example.danielbordig.studyssmartfragment;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Daniel Bordig on 16-01-2016.
 */
public class OldHomework_frag extends Fragment implements AdapterView.OnItemClickListener{
    TextView headerOldHomework;
    ListView listOldHomework;
    ArrayList<HomeworkDTO> oldHomework;
    HomeworkAdapter homeworkAdapter;
    HomeworkDAO homeworkDAO = new HomeworkDAO();

    public OldHomework_frag(){
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_old_homework, container, false);

        headerOldHomework = (TextView) root.findViewById(R.id.headerOldHomework);
        listOldHomework = (ListView) root.findViewById(R.id.listOldHomework);

        oldHomework = HWC_frag.arrayDatabase.getOldHomeworkList();
        homeworkAdapter = new HomeworkAdapter(getActivity(), R.layout.listview_hwc_layout, oldHomework);
        listOldHomework.setAdapter(homeworkAdapter);
        listOldHomework.setOnItemClickListener(this);
        return root;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
        String detail = oldHomework.get(position).detail;
        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
        dialog.setTitle("Homework details:");
        dialog.setMessage(detail);
        dialog.setNegativeButton("Done", new AlertDialog.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                HomeworkDTO homeworkMove = oldHomework.get(position);
                oldHomework.remove(position);
                listOldHomework.setAdapter(homeworkAdapter);
                homeworkDAO.updateDoneHomework(homeworkMove);
            }
        });
        dialog.setPositiveButton("Read Later", new AlertDialog.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                HomeworkDTO homeworkMove = oldHomework.get(position);
                oldHomework.remove(position);
                listOldHomework.setAdapter(homeworkAdapter);
                homeworkDAO.updateLaterHomework(homeworkMove);
            }
        });
        dialog.show();
    }
}

