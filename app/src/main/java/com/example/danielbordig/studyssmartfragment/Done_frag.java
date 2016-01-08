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

import java.util.ArrayList;

public class Done_frag extends Fragment implements AdapterView.OnItemClickListener, View.OnClickListener {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    TextView header, underHeader;
    ListView groupList;
    ArrayList<Integer> groups;
    ArrayList<String> subject;
    ArrayList<HomeworkDTO> test = new ArrayList<>();
    HomeworkDAO homeworkDAO = new HomeworkDAO();
    ArrayList<HomeworkDTO> doneHomeworkList = new ArrayList<>();

    public Done_frag() {
        groups = new ArrayList<>();
        subject = new ArrayList<>();
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
        View root = inflater.inflate(R.layout.fragment_done, container, false);

        header = (TextView) root.findViewById(R.id.headerDone);
        underHeader = (TextView) root.findViewById(R.id.underheaderDone);
        groupList = ( ListView ) root.findViewById(R.id.listDone);
        doneHomeworkList = homeworkDAO.getDoneHomework();
//        groups.add(doneHomeworkList.get(0).course);
//        subject.add(doneHomeworkList.get(0).description);

        underHeader.setText("" + doneHomeworkList.size());

        ArrayAdapter adapter = new ArrayAdapter(getActivity(), R.layout.listview_layout, R.id.txt, subject) {
            @Override
            public View getView(int position, View cachedView, ViewGroup parent) {
                View view = super.getView(position, cachedView, parent);
                TextView beskrivelse = (TextView) view.findViewById(R.id.txt);
                beskrivelse.setText(subject.get(position));
                ImageView billede = (ImageView) view.findViewById(R.id.course);
                billede.setImageResource(groups.get(position));
                return view;
            }
        };
        groupList.setAdapter(adapter);

        return root;
    }

    public void update(int course, String description) {
        groups.add(course);
        subject.add(description);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
