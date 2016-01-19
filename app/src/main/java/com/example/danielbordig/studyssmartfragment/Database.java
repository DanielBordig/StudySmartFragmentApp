package com.example.danielbordig.studyssmartfragment;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;

public class Database {

    Firebase databaseHWC = new Firebase("https://studysmart.firebaseio.com/CBS/Students/Information/144869/HWC");
    Firebase databaseSGM = new Firebase("https://studysmart.firebaseio.com/CBS/Students/Information/144869/SGM");
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
    ArrayList<String> existingGroups;
    ArrayList<String> bmpGroups, nsGroups,finGroups, dsGroups,moGroups ;

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
            existingGroups = new ArrayList<>();
            bmpGroups = new ArrayList<>();
            nsGroups = new ArrayList<>();
            finGroups = new ArrayList<>();
            dsGroups = new ArrayList<>();
            moGroups = new ArrayList<>();

        databaseHWC.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                courseImages.add(R.drawable.bmp);
                courseImages.add(R.drawable.ns);

                for (int i = 1; i < snapshot.child("/ExistingDates").getChildrenCount() + 1; i++) {
                    existingDates.add((String) snapshot.child("/ExistingDates/" + i).getValue());
                }

                for (int i = 1; i < existingDates.size() + 1; i++) {
                    for (int j = 1; j < snapshot.child("/Date/" + existingDates.get(i - 1)).getChildrenCount() + 1; j++) {
                        homework.add(existingDates.get(i - 1) + "," + snapshot.child("/Date/" + existingDates.get(i - 1) + "/" + j).getValue());
                    }
                }
                for (int i = 0; i < homework.size(); i++) {
                    homeworkInformation.add(homework.get(i).split(","));
                }
                for (int i = 0; i < homeworkInformation.size(); i++) {
                    String[] temp = homeworkInformation.get(i);
                    homeworkList.add(new HomeworkDTO(temp[0], courseImages.get(Integer.parseInt(temp[1])), temp[2], temp[3]));
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
            }

        });


            databaseSGM. addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    for (int i = 1; i < dataSnapshot.child("/ExistingGroups").getChildrenCount() + 1; i++) {
                        existingGroups.add((String) dataSnapshot.child("/ExistingGroups/" + i).getValue());
                    }

                    for (int i = 1; i < dataSnapshot.child("/your groups/" + existingGroups.get(0)).getChildrenCount() + 1; i++) {
                        bmpGroups.add((String) dataSnapshot.child("/your groups/" + existingGroups.get(0) + "/" + i).getValue());
                    }
                    for (int i = 1; i < dataSnapshot.child("/your groups/" + existingGroups.get(1)).getChildrenCount() + 1; i++) {
                        nsGroups.add((String) dataSnapshot.child("/your groups/" + existingGroups.get(1) + "/" + i).getValue());
                    }
                    for (int i = 1; i < dataSnapshot.child("/your groups/" + existingGroups.get(2)).getChildrenCount() + 1; i++) {
                        finGroups.add((String) dataSnapshot.child("/your groups/" + existingGroups.get(2) + "/" + i).getValue());
                    }
                    for (int i = 1; i < dataSnapshot.child("/your groups/" + existingGroups.get(3)).getChildrenCount() + 1; i++) {
                        dsGroups.add((String) dataSnapshot.child("/your groups/" + existingGroups.get(3) + "/" + i).getValue());
                    }
                    for (int i = 1; i < dataSnapshot.child("/your groups/" + existingGroups.get(4)).getChildrenCount() + 1; i++) {
                        moGroups.add((String) dataSnapshot.child("/your groups/" + existingGroups.get(4) + "/" + i).getValue());
                    }

                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });
    }

     public ArrayList<HomeworkDTO> getHomeworkList(){
      return homeworkList;
     }

    public ArrayList<String> getBmpGroups() {return bmpGroups;}
    public ArrayList<String> getNsGroups() { return nsGroups; }
    public ArrayList<String> getFinGroups() { return finGroups; }
    public ArrayList<String> getDsGroups() { return dsGroups; }
    public ArrayList<String> getMoGroups() { return moGroups; }

}
