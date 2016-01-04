package com.example.danielbordig.studyssmartfragment;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Daniel Bordig on 03-01-2016.
 */
public class CalendarController {

    public ArrayList calenderCreate(int[] courses, String[] descriptions) {
        ArrayList<HashMap<String, String>> hwcList = new ArrayList<>();

        for (int i = 0; i < courses.length; i++) {
            HashMap<String, String> hm = new HashMap<>();
            hm.put("course", Integer.toString(courses[i]));
            hm.put("txt", descriptions[i]);
            hwcList.add(hm);
        }
        return hwcList;
    }
}