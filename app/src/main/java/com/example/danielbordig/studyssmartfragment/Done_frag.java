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

public class Done_frag extends Fragment implements AdapterView.OnItemClickListener {

    TextView header, noRemainingDoneHomework;
    ListView doneHomeworkListView;
    HomeworkDAO homeworkDAO = new HomeworkDAO();
    ArrayList<HomeworkDTO> tempDoneHomeworkList = new ArrayList<>();
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

        header = (TextView) root.findViewById(R.id.headerDone);
        doneHomeworkListView = ( ListView ) root.findViewById(R.id.listDone);
        noRemainingDoneHomework = (TextView) root.findViewById(R.id.noRemainingDoneHomework);

        tempDoneHomeworkList = homeworkDAO.getDoneHomework();
        for(int i = tempDoneHomeworkList.size()-1; i >= 0; i--){
            doneHomeworkList.add(new HomeworkDTO(tempDoneHomeworkList.get(i).dbId, tempDoneHomeworkList.get(i).date, tempDoneHomeworkList.get(i).course,
                    tempDoneHomeworkList.get(i).description, tempDoneHomeworkList.get(i).detail));
        }

        homeworkAdapter = new HomeworkAdapter(getActivity(), R.layout.listview_hwc_layout, doneHomeworkList);
        doneHomeworkListView.setAdapter(homeworkAdapter);
        doneHomeworkListView.setOnItemClickListener(this);
        if(doneHomeworkList.isEmpty()) noRemainingDoneHomework.setText("No homework marked as done");

        return root;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String detail = doneHomeworkList.get(position).detail;
        String dialogTitle = doneHomeworkList.get(position).description;
        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
        dialog.setTitle(dialogTitle);
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
