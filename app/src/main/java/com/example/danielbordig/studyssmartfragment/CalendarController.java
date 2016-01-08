package com.example.danielbordig.studyssmartfragment;

import java.util.ArrayList;
import java.util.HashMap;

public class CalendarController {

    public ArrayList calenderCreate(ArrayList<HomeworkDTO> homework) {
        ArrayList<HashMap<String, String>> hwcList = new ArrayList<>();

        for (int i = 0; i < homework.size(); i++) {
            HashMap<String, String> hm = new HashMap<>();
            hm.put("course", Integer.toString(homework.get(i).course));
            hm.put("txt", homework.get(i).description);
            hwcList.add(hm);
        }
        return hwcList;
    }
}