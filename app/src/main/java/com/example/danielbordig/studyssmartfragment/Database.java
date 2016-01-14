package com.example.danielbordig.studyssmartfragment;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;

public class Database {

    String month = "", course = "", picture = "", description = "", detail = "";
    long day = 0;
    Firebase databasefire = new Firebase("https://studysmart.firebaseio.com/CBS/Students/Information/144869/HWC");
    ArrayList<String> monthAll;
    ArrayList<Long> dayAll;
    ArrayList<String> courseAll;
    ArrayList<String> pictureAll;
    ArrayList<String> descriptionAll;
    ArrayList<String> detailAll;
    ArrayList<String[]> homeworkInformation;
    ArrayList<String> existingDates;
    ArrayList<String> homework;
    ArrayList<HomeworkDTO> homeworkList;
    static ArrayList<Integer> billeder;


        public Database() {
            monthAll = new ArrayList<>();
            dayAll = new ArrayList<>();
            courseAll = new ArrayList<>();
            pictureAll = new ArrayList<>();
            descriptionAll = new ArrayList<>();
            detailAll = new ArrayList<>();
            homeworkInformation = new ArrayList<>();
            existingDates = new ArrayList<>();
            homework = new ArrayList<>();
            homeworkList = new ArrayList<>();
            billeder = new ArrayList<>();

        databasefire.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
//                for (int i = 1; i - 1 < snapshot.child("/Date/Month").getChildrenCount(); i++) {
//                    monthAll.add((String) snapshot.child("/Date/Month/"+i).getValue());
//                    System.out.println("1: month");
//                }
//                for (int j = 1; j - 1 < snapshot.child("/Date/Day/"+month).getChildrenCount(); j++) {
//                    dayAll.add((long) snapshot.child("/Date/Day/" + month + "/" + j).getValue());
//                    System.out.println("2: day");
//                }
//                for (int k = 1; k - 1 < snapshot.child("/Date/Course/"+month+"/"+ day).getChildrenCount(); k++) {
//                    courseAll.add((String) snapshot.child(month + "/" + day + "/" + Integer.toString(k)).getValue());
//                    System.out.println("3");
//                }
//                for (int l = 1; l - 1 < snapshot.child("/Pictures/" + course).getChildrenCount(); l++) {
//                    pictureAll.add((String) snapshot.child(Integer.toString(l)).getValue());
//                    System.out.println("4: picture");
//                }
//                for (int m = 1; m - 1 < snapshot.child("/Lektier/" + month + "/" + day + "/" + course + "/Bog/Descriptions").getChildrenCount(); m++) {
//                    System.out.println("5: description");
//                    descriptionAll.add((String) snapshot.child(Integer.toString(m)).getValue());
//                }
//                for(int n = 1; n - 1 < snapshot.child("/Lektier/" + month + "/" + day + "/" + course + "/Bog/Details").getChildrenCount(); n++) {
//                    detail = (String) snapshot.child(Integer.toString(n)).getValue();
//                    System.out.println("6: detail");
//                }
                billeder.add(R.drawable.bmp);
                billeder.add(R.drawable.ns);
                                            //4
                for(int i = 1; i < snapshot.child("/ExistingDates").getChildrenCount()+1; i++){
                    existingDates.add((String) snapshot.child("/ExistingDates/" + i).getValue());
                }
                                            //3
                for(int i = 1; i < existingDates.size()+1; i++){
                    for(int j = 1; j < snapshot.child("/Date/"+existingDates.get(i-1)).getChildrenCount()+1; j++){
                        homework.add(existingDates.get(i-1) + "," + snapshot.child("/Date/" + existingDates.get(i-1) + "/" + j).getValue());
                    }
                }
                for(int i = 0; i < homework.size(); i++){
                    homeworkInformation.add(homework.get(i).split(","));
                }
                for(int i = 0; i < homeworkInformation.size(); i++){
                    String[] temp = homeworkInformation.get(i);
                    homeworkList.add(new HomeworkDTO(temp[0], billeder.get(Integer.parseInt(temp[1])), temp[2], temp[3]));
                }
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
            }

        });
    }

     public ArrayList<HomeworkDTO> getHomeworkList(){
      return homeworkList;
     }
}
