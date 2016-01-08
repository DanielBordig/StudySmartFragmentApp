package com.example.danielbordig.studyssmartfragment;

import java.util.ArrayList;

/**
 * Created by Daniel Bordig on 07-01-2016.
 */
public class HomeworkDAO {

    ArrayList<HomeworkDTO> doneHomeworkList = new ArrayList<>();;

    public HomeworkDAO(){
    }

    public void updateDoneHomework(HomeworkDTO doneHomework){
        doneHomeworkList.add(doneHomework);
    }

    public ArrayList getDoneHomework(){return doneHomeworkList;}
}
