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

public class ReadLater_frag extends Fragment implements AdapterView.OnItemClickListener {

    TextView header, noRemainingLaterHomework;
    ListView laterHomeworkListView;
    HomeworkDAO homeworkDAO = new HomeworkDAO();
    ArrayList<HomeworkDTO> laterHomeworkList = new ArrayList<>();
    HomeworkAdapter homeworkAdapter;

    public ReadLater_frag() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_readlater, container, false);

        header = (TextView) root.findViewById(R.id.headerReadlater);
        laterHomeworkListView = ( ListView ) root.findViewById(R.id.listReadlater);
        noRemainingLaterHomework = (TextView) root.findViewById(R.id.noRemainingLaterHomework);
        laterHomeworkList = homeworkDAO.getLaterHomework();
        homeworkAdapter = new HomeworkAdapter(getActivity(), R.layout.listview_hwc_layout, laterHomeworkList);

        laterHomeworkListView.setAdapter(homeworkAdapter);
        laterHomeworkListView.setOnItemClickListener(this);
        if(laterHomeworkList.isEmpty()) noRemainingLaterHomework.setText("No homework set to read later");

        return root;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
        String detail = laterHomeworkList.get(position).detail;
        String dialogTitle = laterHomeworkList.get(position).description;
        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
        dialog.setTitle(dialogTitle);
        dialog.setMessage(detail);
        dialog.setNegativeButton("Done", new AlertDialog.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                HomeworkDTO homeworkMove = laterHomeworkList.get(position);
                laterHomeworkList.remove(position);
                laterHomeworkListView.setAdapter(homeworkAdapter);
                homeworkDAO.updateDoneHomework(homeworkMove);
                Login_frag.db.movedToDone(homeworkMove,"Read later");
                if(laterHomeworkList.isEmpty()) noRemainingLaterHomework.setText("No homework set to read later");
            }
        });
        dialog.setPositiveButton("OK", new AlertDialog.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
