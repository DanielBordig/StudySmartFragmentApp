package com.example.danielbordig.studyssmartfragment;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;

public class Database {

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
    ArrayList<Integer> courseImages;

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
            courseImages = new ArrayList<>();

        databasefire.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                courseImages.add(R.drawable.bmp);
                courseImages.add(R.drawable.ns);

                for(int i = 1; i < snapshot.child("/ExistingDates").getChildrenCount()+1; i++){
                    existingDates.add((String) snapshot.child("/ExistingDates/" + i).getValue());
                }

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
                    homeworkList.add(new HomeworkDTO(temp[0], courseImages.get(Integer.parseInt(temp[1])), temp[2], temp[3]));
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