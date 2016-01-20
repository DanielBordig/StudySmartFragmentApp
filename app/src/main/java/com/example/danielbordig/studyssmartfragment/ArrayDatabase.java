package com.example.danielbordig.studyssmartfragment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Nicklas Jensen on 07-01-2016.
 */
public class ArrayDatabase {
    static boolean firstCreate = true;
    HomeworkDAO homeworkDAO = new HomeworkDAO();
    //Other ArrayList'
    ArrayList<StudentDTO> studentList = new ArrayList<>();
    static ArrayList<HomeworkDTO> oldHomework = new ArrayList<>();
    static ArrayList<HomeworkDTO> homeworkWeek = new ArrayList<>();
    static ArrayList<HomeworkDTO> homeworkFuture = new ArrayList<>();
    static ArrayList<HomeworkDTO> homeworkAll = new ArrayList<>();
    static ArrayList<HomeworkDTO> doneHomework = new ArrayList<>();
    static ArrayList<HomeworkDTO> laterHomework = new ArrayList<>();
    //Integer ArrayList's
    ArrayList<Integer> coursesAll = new ArrayList<Integer>();
    ArrayList<Integer> coursesWeek = new ArrayList<Integer>();
    ArrayList<Integer> done = new ArrayList<Integer>();
    ArrayList<Integer> groups = new ArrayList<Integer>();
    ArrayList<Integer> groupsAll = new ArrayList<Integer>();
    ArrayList<Integer> readLater = new ArrayList<Integer>();
    ArrayList<Integer> printingCourseFuture = new ArrayList<>();
    ArrayList<Integer> printingCourseWeek = new ArrayList<>();
    //String ArrayList's
    ArrayList<String> datesAll = new ArrayList<>();
    ArrayList<String> datesWeek = new ArrayList<>();
    ArrayList<String> knownDates = new ArrayList<>();
    ArrayList<String> descriptionsAll = new ArrayList<String>();
    ArrayList<String> descriptionsWeek = new ArrayList<String>();
    ArrayList<String> detailsAll = new ArrayList<String>();
    ArrayList<String> detailsWeek = new ArrayList<String>();
    ArrayList<String> printingListFuture = new ArrayList<>();
    ArrayList<String> printingListWeek = new ArrayList<>();
    ArrayList<String> emner = new ArrayList<String>();
    ArrayList<String> emnerAll = new ArrayList<String>();
    ArrayList<String> emnerDone = new ArrayList<String>();
    ArrayList<String> emnerReadLater = new ArrayList<String>();
    ArrayList<String> weekDays = new ArrayList<>();
    ArrayList<Integer> daysOfMonths = new ArrayList<>();

    public ArrayDatabase() {

        weekDays.add("Monday");
        weekDays.add("Tuesday");
        weekDays.add("Wednesday");
        weekDays.add("Thursday");
        weekDays.add("Friday");
        weekDays.add("Saturday");
        weekDays.add("Sunday");

        //første index er for at hvert index nr passer til sin måneds nr
        daysOfMonths.add(0);
        daysOfMonths.add(31);
        daysOfMonths.add(28);
        daysOfMonths.add(31);
        daysOfMonths.add(30);
        daysOfMonths.add(31);
        daysOfMonths.add(30);
        daysOfMonths.add(31);
        daysOfMonths.add(31);
        daysOfMonths.add(30);
        daysOfMonths.add(31);
        daysOfMonths.add(30);
        daysOfMonths.add(31);

        if(firstCreate){
            homeworkAll = Login_frag.db.getHomeworkList();
            SimpleDateFormat dateFormater = new SimpleDateFormat("dd/MM/yyyy");
            Date date = new Date();
            String currentDate = dateFormater.format(date);
            String[] dayMonthYear = currentDate.split("/");
            int currentDay = Integer.parseInt(dayMonthYear[0]);
            int currentMonth = Integer.parseInt(dayMonthYear[1]);
            int currentYear = Integer.parseInt(dayMonthYear[2]);
            int extraDay = 0;
            // hvis vi er i et skudår har februar 29 dage
            if(currentMonth==2 && currentYear%4==0) extraDay = 1;

            int arrayIndex = 0;
            for(int i = 0; currentMonth >= getMonthNumber(homeworkAll.get(i).date); i++){
                if(currentMonth > getMonthNumber(homeworkAll.get(i).date)) {
                    oldHomework.add(homeworkAll.get(i));
                    homeworkAll.remove(i);
                    i--;
                }
                else if(currentMonth == getMonthNumber(homeworkAll.get(i).date) && currentDay > getDayNumber(homeworkAll.get(i).date)) {
                    oldHomework.add(homeworkAll.get(i));
                    homeworkAll.remove(i);
                    i--;
                }

            }
            homeworkFuture = homeworkAll;
            if(currentDay+7 > daysOfMonths.get(currentMonth)+extraDay){
                int stopdato = currentDay+7 - daysOfMonths.get(currentMonth)+extraDay;
                for(int i = arrayIndex; i < homeworkFuture.size(); i++){
                    arrayIndex = i;
                    int homeworkDate = getDayNumber(homeworkFuture.get(i).date);
                    if(homeworkDate >= currentDay && homeworkDate <= daysOfMonths.get(currentMonth)+extraDay) {
                        homeworkWeek.add(homeworkFuture.get(i));
                    }else if(homeworkDate < stopdato){
                        homeworkWeek.add(homeworkFuture.get(i));
                    }
                    else if(homeworkDate > stopdato) break;
                }
            } else {
                for(int i = arrayIndex; i < homeworkFuture.size(); i++){
                    int homeworkDay = getDayNumber(homeworkFuture.get(i).date);
                    if(homeworkDay >= currentDay && homeworkDay < currentDay+7) homeworkWeek.add(homeworkFuture.get(i));
                    if(homeworkDay > currentDay+8) break;
                }
            }
            //printingListFuture
            for(int i = 0; i < homeworkFuture.size(); i++){
                if(!knownDates.contains(homeworkFuture.get(i).date)){
                    knownDates.add(homeworkFuture.get(i).date);
                    printingListFuture.add("date" + homeworkFuture.get(i).date);
                    printingCourseFuture.add(R.drawable.blank);
                }
                printingListFuture.add(homeworkFuture.get(i).description);
                printingCourseFuture.add(homeworkFuture.get(i).course);
            }
            knownDates.clear();
            //printingListWeek
            for(int i = 0; i < homeworkWeek.size(); i++){
                if(!knownDates.contains(homeworkWeek.get(i).date)){
                    knownDates.add(homeworkWeek.get(i).date);
                    printingListWeek.add("date" + homeworkWeek.get(i).date);
                    printingCourseWeek.add(R.drawable.blank);
                }
                printingListWeek.add(homeworkWeek.get(i).description);
                printingCourseWeek.add(homeworkWeek.get(i).course);
            }
            doneHomework = Login_frag.db.getDoneHomeworkList();
            laterHomework = Login_frag.db.getLaterHomeworkList();
            for(int i = 0; i < doneHomework.size(); i++){
                homeworkDAO.updateDoneHomework(doneHomework.get(i));
            }
            for(int i = 0; i < laterHomework.size(); i++){
                homeworkDAO.updateLaterHomework(laterHomework.get(i));
            }
            firstCreate = false;
        }
    }

    public int getDayNumber(String date){
        if(date.startsWith("Monday")) date = date.substring(9,11);
        else if(date.startsWith("Tuesday")) date = date.substring(10,12);
        else if(date.startsWith("Wednesday")) date = date.substring(12,14);
        else if(date.startsWith("Thursday")) date = date.substring(11,13);
        else if(date.startsWith("Friday")) date = date.substring(9,11);
        else if(date.startsWith("Saturday")) date = date.substring(11,13);
        else if(date.startsWith("Sunday")) date = date.substring(9,11);
        return Integer.parseInt(date);
    }

    public int getMonthNumber(String date){
        int monthNumber = 0;
        if(date.contains("Jan")) monthNumber = 1;
        else if(date.contains("Feb")) monthNumber = 2;
        else if(date.contains("Mar")) monthNumber = 3;
        else if(date.contains("Apr")) monthNumber = 4;
        else if(date.contains("May")) monthNumber = 5;
        else if(date.contains("Jun")) monthNumber = 6;
        else if(date.contains("Jul")) monthNumber = 7;
        else if(date.contains("Aug")) monthNumber = 8;
        else if(date.contains("Sep")) monthNumber = 9;
        else if(date.contains("Okt")) monthNumber = 10;
        else if(date.contains("Nov")) monthNumber = 11;
        else if(date.contains("Dec")) monthNumber = 12;
        return monthNumber;
    }

//All getters

    //Other Getter's
    public ArrayList<StudentDTO> getStudentList() {
        return studentList;
    }

    public ArrayList<HomeworkDTO> getHomeworkAllList() { return homeworkAll; }

    public ArrayList<HomeworkDTO> getHomeworkWeekList() { return homeworkWeek; }

    public static ArrayList<HomeworkDTO> getOldHomeworkList() {
        return oldHomework;
    }

    public static ArrayList<HomeworkDTO> getHomeworkFutureList() {
        return homeworkFuture;
    }

    //Integer Getter's
    public ArrayList<Integer> getCoursesAll() {
        return coursesAll;
    }

    public ArrayList<Integer> getCoursesWeek() {
        return coursesWeek;
    }

    public ArrayList<Integer> getDone() {
        return done;
    }

    public ArrayList<Integer> getGroups() {
        return groups;
    }

    public ArrayList<Integer> getGroupsAll() {
        return groupsAll;
    }

    public ArrayList<Integer> getReadLater() {
        return readLater;
    }

    public ArrayList<Integer> getPrintingCourseFuture() {
        return printingCourseFuture;
    }

    public ArrayList<Integer> getPrintingCourseWeek() {
        return printingCourseWeek;
    }

    //String Getter's
    public ArrayList<String> getDescriptionAll() {
        return descriptionsAll;
    }

    public ArrayList<String> getDescriptionsWeek() {
        return descriptionsWeek;
    }

    public ArrayList<String> getDetailsAll() { return detailsAll; }

    public ArrayList<String> getPrintingListFuture() {
        return printingListFuture;
    }

    public ArrayList<String> getPrintingListWeek() {
        return printingListWeek;
    }

    public ArrayList<String> getEmner() {
        return emner;
    }

    public ArrayList<String> getEmnerAll() {
        return emnerAll;
    }

    public ArrayList<String> getEmnerDone() {
        return emnerDone;
    }

    public ArrayList<String> getemnerReadLater() { return emnerReadLater; }

//All Adders

    public void addStudentList(int a, String b, String c) {
        studentList.add(new StudentDTO(a, b, c));
    }

    //Integer adder's
    public void addCoursesAll(int a) {
        coursesAll.add(a);
    }

    public void addCoursesWeek(int a) {
        coursesWeek.add(a);
    }

    public void addDone(int a) {
        done.add(a);
    }

    public void addGroups(int a) {
        groups.add(a);
    }

    public void addGroupsAll(int a) {
        groupsAll.add(a);
    }

    public void addReadLater(int a) {
        readLater.add(a);
    }

    //String adder's
    public void addDescriptionsAll(String a) {
        descriptionsAll.add(a);
    }

    public void addDescriptionsWeek(String a) {
        descriptionsWeek.add(a);
    }

    public void addDetailsAll(String a) {
        detailsAll.add(a);
    }

    public void addEmner(String a) {
        emner.add(a);
    }

    public void addEmnerAll(String a) {
        emnerAll.add(a);
    }

    public void addEmnerDone(String a) {
        emnerDone.add(a);
    }

    public void addEmnerReadLater(String a) {
        emnerReadLater.add(a);
    }

//All Removers

    //Other Remover's
    public void removeStudentList(int position) {
        studentList.remove(position);
    }

    //Integer Remover's
    public void removeCoursesAll(int position) {
        coursesAll.remove(position);
    }

    public void removeCoursesWeek(int position) {
        coursesWeek.remove(position);
    }

    public void removeDone(int position) {
        done.remove(position);
    }

    public void removeGroups(int position) {
        groups.remove(position);
    }

    public void removeGroupsAll(int position) {
        groupsAll.remove(position);
    }

    public void removeReadLater(int position) {
        readLater.remove(position);
    }

    //String Remover's
    public void removeDescriptionsAll(String position) {
        descriptionsAll.remove(position);
    }

    public void removeDescriptionsWeek(String position) {
        descriptionsWeek.remove(position);
    }

    public void removeDetailsAll(String position) {
        detailsAll.remove(position);
    }

    public void removeEmner(String position) {
        emner.remove(position);
    }

    public void removeEmnerAll(String position) {
        emnerAll.remove(position);
    }

    public void removeEmnerDone(String position) {
        emnerDone.remove(position);
    }

    public void removeEmnerReadLater(String position) {
        emnerReadLater.remove(position);
    }

}