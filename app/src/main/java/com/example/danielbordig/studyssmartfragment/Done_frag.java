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

public class Done_frag extends Fragment implements AdapterView.OnItemClickListener {

    TextView header, underHeader;
    ListView doneHomeworkListView;
    ArrayList<Integer> course = new ArrayList<>();
    ArrayList<String> description = new ArrayList<>();
    HomeworkDAO homeworkDAO = new HomeworkDAO();
    ArrayList<HomeworkDTO> doneHomeworkList = new ArrayList<>();

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
        underHeader = (TextView) root.findViewById(R.id.underheaderDone);
        doneHomeworkListView = ( ListView ) root.findViewById(R.id.listDone);
        doneHomeworkList = homeworkDAO.getDoneHomework();
        for(int i = doneHomeworkList.size()-1; i >= 0; i--){
            course.add(doneHomeworkList.get(i).course);
            description.add(doneHomeworkList.get(i).description);
        }

        ArrayAdapter adapter = new ArrayAdapter(getActivity(), R.layout.listview_layout, R.id.txt, description) {
            @Override
            public View getView(int position, View cachedView, ViewGroup parent) {
                View view = super.getView(position, cachedView, parent);
                TextView beskrivelse = (TextView) view.findViewById(R.id.txt);
                beskrivelse.setText(description.get(position));
                ImageView billede = (ImageView) view.findViewById(R.id.course);
                billede.setImageResource(course.get(position));
                return view;
            }
        };
        doneHomeworkListView.setAdapter(adapter);

        return root;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
