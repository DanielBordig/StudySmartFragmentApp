package com.example.danielbordig.studyssmartfragment;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;

public class Database {

    int doneCount;
    int laterCount;
    HomeworkDAO homeworkDAO = new HomeworkDAO();
    Firebase databaseHWC = new Firebase("https://studysmart.firebaseio.com/"+Singleton.userHWC);
    Firebase databaseSGM = new Firebase("https://studysmart.firebaseio.com/"+Singleton.userSGM);
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
    ArrayList<HomeworkDTO> doneHomeworkList;
    ArrayList<HomeworkDTO> laterHomeworkList;
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
            doneHomeworkList = new ArrayList<>();
            laterHomeworkList = new ArrayList<>();
            courseImages = new ArrayList<>();
            existingGroups = new ArrayList<>();
            bmpGroups = new ArrayList<>();
            nsGroups = new ArrayList<>();
            finGroups = new ArrayList<>();
            dsGroups = new ArrayList<>();
            moGroups = new ArrayList<>();

            courseImages.add(R.drawable.bmp);
            courseImages.add(R.drawable.ns);
            courseImages.add(R.drawable.fin);
            courseImages.add(R.drawable.ds);
            courseImages.add(R.drawable.mo);

        databaseHWC.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                // bruges i movedToDone
                doneCount = (int) snapshot.child("/DoneHomework").getChildrenCount()-1;
                // bruges i movedToLater
                laterCount = (int) snapshot.child("/ReadLaterHomework").getChildrenCount()-1;
                // finder alle kendte datoer
                for (int i = 1; i < snapshot.child("/ExistingDates").getChildrenCount() + 1; i++) {
                    existingDates.add((String) snapshot.child("/ExistingDates/" + i).getValue());
                }
                // henter all lektier ud fra deres datoer
                for (int i = 1; i < existingDates.size() + 1; i++) {
                    int amount = (int) snapshot.child("/Date/" + existingDates.get(i - 1)).getChildrenCount() + 1;
                    for (int j = 1; j < amount; j++) {
                        if(!(snapshot.child("/Date/" + existingDates.get(i - 1) + "/" + j).getValue() == null)) {
                            homework.add(snapshot.child("/Date/" + existingDates.get(i - 1) + "/" + j).getKey() + "," + existingDates.get(i - 1) + ","
                                        + snapshot.child("/Date/" + existingDates.get(i - 1) + "/" + j).getValue());
                        }
                        else amount++;
                    }
                }
                // slitter informationerne rigtigt op så de kan laves til en homeworkDTO
                for (int i = 0; i < homework.size(); i++) {
                    homeworkInformation.add(homework.get(i).split(","));
                }
                for (int i = 0; i < homeworkInformation.size(); i++) {
                    String[] temp = homeworkInformation.get(i);
                    homeworkList.add(new HomeworkDTO(Integer.parseInt(temp[0]),temp[1], courseImages.get(Integer.parseInt(temp[2])), temp[3], temp[4]));
                }
                // henter alle done homework
                homework.clear();
                homeworkInformation.clear();
                for(int i = 1; i < snapshot.child("/DoneHomework").getChildrenCount(); i++){
                                                                                //bare en tilfældig dato. skal ikke bruges
                    homework.add(snapshot.child("/DoneHomework/" + i).getKey() + "," + existingDates.get(i - 1) + ","
                            + snapshot.child("/DoneHomework/" +i).getValue());
                }
                for (int i = 0; i < homework.size(); i++) {
                    homeworkInformation.add(homework.get(i).split(","));
                }
                for (int i = 0; i < homeworkInformation.size(); i++) {
                    String[] temp = homeworkInformation.get(i);
                    doneHomeworkList.add(new HomeworkDTO(Integer.parseInt(temp[0]), temp[1], courseImages.get(Integer.parseInt(temp[2])), temp[3], temp[4]));
                }
                // henter  alle read later homework
                homework.clear();
                homeworkInformation.clear();
                for(int i = 1; i < snapshot.child("/ReadLaterHomework").getChildrenCount(); i++){
                    snapshot.child("/ReadLaterHomework/" +i).getValue();               //bare en tilfældig dato. skal ikke bruges
                    homework.add(snapshot.child("/ReadLaterHomework/" + i).getKey() + "," + existingDates.get(i - 1) + ","
                            + snapshot.child("/ReadLaterHomework/" +i).getValue());
                }
                for (int i = 0; i < homework.size(); i++) {
                    homeworkInformation.add(homework.get(i).split(","));
                }
                for (int i = 0; i < homeworkInformation.size(); i++) {
                    String[] temp = homeworkInformation.get(i);
                    laterHomeworkList.add(new HomeworkDTO(Integer.parseInt(temp[0]), temp[1], courseImages.get(Integer.parseInt(temp[2])), temp[3], temp[4]));
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

    public void movedToDone(HomeworkDTO doneHomework, String from){
        doneCount++;
        String done = "";
        for(int i = 0; i < courseImages.size(); i++){
            if(courseImages.get(i).equals(doneHomework.course)) done += i+",";
        }
        done += doneHomework.description+",";
        done += doneHomework.detail;
        databaseHWC.child("/DoneHomework/"+doneCount).setValue(done);
        if(from.equals("HWC")) databaseHWC.child("/Date/"+doneHomework.date+"/" + doneHomework.dbId).removeValue();
        if(from.equals("Read later")) databaseHWC.child("/ReadLaterHomework/"+ doneHomework.dbId).removeValue();
    }

    public void movedToLater(HomeworkDTO readLaterHomework){
        laterCount++;
        String later = "";
        for(int i = 0; i < courseImages.size(); i++){
            if(courseImages.get(i).equals(readLaterHomework.course)) later += i+",";
        }
        later += readLaterHomework.description+",";
        later += readLaterHomework.detail;
        databaseHWC.child("/ReadLaterHomework/"+laterCount).setValue(later);
        databaseHWC.child("/Date/"+readLaterHomework.date+"/"+readLaterHomework.dbId).removeValue();
    }

    public ArrayList<HomeworkDTO> getHomeworkList(){
      return homeworkList;
     }

    public ArrayList<HomeworkDTO> getDoneHomeworkList() {
        return doneHomeworkList;
    }

    public ArrayList<HomeworkDTO> getLaterHomeworkList() {
        return laterHomeworkList;
    }

    public ArrayList<String> getBmpGroups() {return bmpGroups;}
    public ArrayList<String> getNsGroups() { return nsGroups; }
    public ArrayList<String> getFinGroups() { return finGroups; }
    public ArrayList<String> getDsGroups() { return dsGroups; }
    public ArrayList<String> getMoGroups() { return moGroups; }
}
