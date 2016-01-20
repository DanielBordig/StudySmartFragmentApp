package com.example.danielbordig.studyssmartfragment;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Done_frag extends Fragment implements AdapterView.OnItemClickListener {

    TextView header, underHeader;
    ListView doneHomeworkListView;
    HomeworkDAO homeworkDAO = new HomeworkDAO();
    ArrayList<HomeworkDTO> tempdoneHomeworkList = new ArrayList<>();
    ArrayList<HomeworkDTO> doneHomeworkList = new ArrayList<>();
    HomeworkAdapter homeworkAdapter;

    public Done_frag() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_done, container, false);

        //header = (TextView) root.findViewById(R.id.headerDone);
        underHeader = (TextView) root.findViewById(R.id.underheaderDone);
        doneHomeworkListView = ( ListView ) root.findViewById(R.id.listDone);
        tempdoneHomeworkList = homeworkDAO.getDoneHomework();
        for(int i = tempdoneHomeworkList.size()-1; i >= 0; i--){
            doneHomeworkList.add(new HomeworkDTO(tempdoneHomeworkList.get(i).dbId,tempdoneHomeworkList.get(i).date, tempdoneHomeworkList.get(i).course,
                    tempdoneHomeworkList.get(i).description, tempdoneHomeworkList.get(i).detail));
        }

        homeworkAdapter = new HomeworkAdapter(getActivity(), R.layout.listview_hwc_layout, doneHomeworkList);
        doneHomeworkListView.setAdapter(homeworkAdapter);
        doneHomeworkListView.setOnItemClickListener(this);

        return root;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String detail = doneHomeworkList.get(position).detail;
        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
        dialog.setTitle("Homework details:");
        dialog.setMessage(detail);
        dialog.setPositiveButton("OK", new AlertDialog.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
