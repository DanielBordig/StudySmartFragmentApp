package com.example.danielbordig.studyssmartfragment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Nicklas Jensen on 07-01-2016.
 */
public class ArrayDatabase {
    static boolean firstCreate = true;

    //Other ArrayList'
    ArrayList<StudentDTO> studentList = new ArrayList<>();
    static ArrayList<HomeworkDTO> oldHomework = new ArrayList<>();
    static ArrayList<HomeworkDTO> homeworkWeek = new ArrayList<>();
    static ArrayList<HomeworkDTO> homeworkFuture = new ArrayList<>();
    static ArrayList<HomeworkDTO> homeworkAll = new ArrayList<>();
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
        //Array's containing different types
        //student info
        studentList.add(new StudentDTO(1, "Daniel", "qwert"));
        studentList.add(new StudentDTO(2, "Zohra", "12345"));
        studentList.add(new StudentDTO(3, "Geziena", "asdf"));
        studentList.add(new StudentDTO(4, "Nicklas", "zxcv"));
        studentList.add(new StudentDTO(5, "Bob", "trewq"));
        studentList.add(new StudentDTO(6, "q", "q"));
        //Array's containing Integers
        //coursesAll
        coursesAll.add(R.drawable.bmp);
        coursesAll.add(R.drawable.ns);
        coursesAll.add(R.drawable.bmp);
        coursesAll.add(R.drawable.ns);
        coursesAll.add(R.drawable.bmp);
        coursesAll.add(R.drawable.bmp);
        coursesAll.add(R.drawable.ns);
        coursesAll.add(R.drawable.bmp);
        coursesAll.add(R.drawable.bmp);
        coursesAll.add(R.drawable.ns);
        coursesAll.add(R.drawable.ns);
        //coursesWeek
        coursesWeek.add(R.drawable.bmp);
        coursesWeek.add(R.drawable.ns);
        coursesWeek.add(R.drawable.bmp);
        //Done
        done.add(R.drawable.bmp);
        done.add(R.drawable.ns);
        done.add(R.drawable.bmp);
        done.add(R.drawable.ns);
        done.add(R.drawable.bmp);
        done.add(R.drawable.bmp);
        done.add(R.drawable.ns);
        done.add(R.drawable.bmp);
        done.add(R.drawable.bmp);
        done.add(R.drawable.ns);
        done.add(R.drawable.ns);
        //groups
        groups.add(R.drawable.bmp);
        groups.add(R.drawable.ns);
        groups.add(R.drawable.bmp);
        groups.add(R.drawable.ns);
        groups.add(R.drawable.bmp);
        groups.add(R.drawable.bmp);
        groups.add(R.drawable.ns);
        groups.add(R.drawable.bmp);
        groups.add(R.drawable.bmp);
        groups.add(R.drawable.ns);
        groups.add(R.drawable.ns);
        //GroupsAll
        groupsAll.add(R.drawable.bmp);
        groupsAll.add(R.drawable.ns);
        //ReadLater
        readLater.add(R.drawable.bmp);
        readLater.add(R.drawable.ns);
        readLater.add(R.drawable.bmp);
        readLater.add(R.drawable.ns);
        readLater.add(R.drawable.bmp);
        readLater.add(R.drawable.bmp);
        readLater.add(R.drawable.ns);
        readLater.add(R.drawable.bmp);
        readLater.add(R.drawable.bmp);
        readLater.add(R.drawable.ns);
        readLater.add(R.drawable.ns);
        //Array 's containing Strings
        //DatesAll
        datesAll.add("Monday - 11 Jan.");
        datesAll.add("Wednesday - 13 Jan.");
        datesAll.add("Friday - 15 Jan.");
        datesAll.add("Friday - 15 Jan.");
        datesAll.add("Friday - 15 Jan.");
        datesAll.add("Friday - 15 Jan.");
        datesAll.add("Friday - 15 Jan.");
        datesAll.add("Friday - 15 Jan.");
        datesAll.add("Friday - 15 Jan.");
        datesAll.add("Friday - 15 Jan.");
        datesAll.add("Friday - 15 Jan.");
        //DatesWeek
        datesWeek.add("Monday - 11 Jan.");
        datesWeek.add("Wednesday - 13 Jan.");
        datesWeek.add("Friday - 15 Jan.");
        //DescriptionAll
        descriptionsAll.add("Session 3 - 13682 pages");
        descriptionsAll.add("Session 6 - 583 pages");
        descriptionsAll.add("Missing description 0");
        descriptionsAll.add("Missing description 1");
        descriptionsAll.add("Missing description 2");
        descriptionsAll.add("Missing description 3");
        descriptionsAll.add("Missing description 4");
        descriptionsAll.add("Missing description 5");
        descriptionsAll.add("Missing description 6");
        descriptionsAll.add("Missing description 7");
        descriptionsAll.add("Missing description 8");
        //DescriptionWeek
        descriptionsWeek.add("Monday - 39 Aug.\n" + "Session 3 - 13682 pages");
        descriptionsWeek.add("Wednesday - 56 Okt.\n" + "Session 6 - 583 pages");
        descriptionsWeek.add("Missing description 0");
        //DetailsAll
        detailsAll.add("This homework is awesome, you better read it.\nBook: Naruto 1-72");
        detailsAll.add("This homework sucks, and is not recommended as necessary.\nBook: Fifty Shades of Grey");
        detailsAll.add("Missing details 0");
        detailsAll.add("Missing details 1");
        detailsAll.add("Missing details 2");
        detailsAll.add("Missing details 3");
        detailsAll.add("Missing details 4");
        detailsAll.add("Missing details 5");
        detailsAll.add("Missing details 6");
        detailsAll.add("Missing details 7");
        detailsAll.add("Missing details 8");
        //DetailsWeek
        detailsWeek.add("This homework is awesome, you better read it.\nBook: Naruto 1-72");
        detailsWeek.add("This homework sucks, and is not recommended as necessary.\nBook: Fifty Shades of Grey");
        detailsWeek.add("Missing details 0");
        //Emner
        emner.add("Monday - 39 Aug.\n" + "Session 3 - 13682 pages");
        emner.add("Wednesday - 56 Okt.\n" + "Session 6 - 583 pages");
        emner.add("Missing description 0");
        emner.add("Missing description 1");
        emner.add("Missing description 2");
        emner.add("Missing description 3");
        emner.add("Missing description 4");
        emner.add("Missing description 5");
        emner.add("Missing description 6");
        emner.add("Missing description 7");
        emner.add("Missing description 8");
        //EmnerAll
        emnerAll.add("This homework is awesome, you better read it.\nBook: Naruto 1-72");
        emnerAll.add("This homework sucks, and is not recommended as necessary.\nBook: Fifty Shades of Grey");
        //EmnerDone
        emnerDone.add("Monday - 39 Aug.\n" + "Session 3 - 13682 pages");
        emnerDone.add("Wednesday - 56 Okt.\n" + "Session 6 - 583 pages");
        emnerDone.add("Missing description 0");
        emnerDone.add("Missing description 1");
        emnerDone.add("Missing description 2");
        emnerDone.add("Missing description 3");
        emnerDone.add("Missing description 4");
        emnerDone.add("Missing description 5");
        emnerDone.add("Missing description 6");
        emnerDone.add("Missing description 7");
        emnerDone.add("Missing description 8");
        //EmnerReadLater
        emnerReadLater.add("Monday - 39 Aug.\n" + "Session 3 - 13682 pages");
        emnerReadLater.add("Wednesday - 56 Okt.\n" + "Session 6 - 583 pages");
        emnerReadLater.add("Missing description 0");
        emnerReadLater.add("Missing description 1");
        emnerReadLater.add("Missing description 2");
        emnerReadLater.add("Missing description 3");
        emnerReadLater.add("Missing description 4");
        emnerReadLater.add("Missing description 5");
        emnerReadLater.add("Missing description 6");
        emnerReadLater.add("Missing description 7");
        emnerReadLater.add("Missing description 8");

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