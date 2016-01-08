package com.example.danielbordig.studyssmartfragment;

import java.util.ArrayList;

/**
 * Created by Daniel Bordig on 07-01-2016.
 */
public class HomeworkDAO {

    static ArrayList<HomeworkDTO> doneHomeworkList = new ArrayList<>();
    static ArrayList<HomeworkDTO> laterHomeworkList = new ArrayList<>();

    public HomeworkDAO(){

    }

    public static void updateDoneHomework(HomeworkDTO doneHomework){
        doneHomeworkList.add(doneHomework);
    }

    public static void updateLaterHomework(HomeworkDTO doneHomework){
        laterHomeworkList.add(doneHomework);
    }

    public static ArrayList getDoneHomework(){return doneHomeworkList;}

    public static ArrayList getLaterHomework(){return laterHomeworkList;}
}
