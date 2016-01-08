package com.example.danielbordig.studyssmartfragment;

import java.util.ArrayList;

/**
 * Created by Nicklas Jensen on 07-01-2016.
 */
public class ArrayDatabase {


    //Other ArrayList's
    ArrayList<StudentDTO> studentList;
    //Integer ArrayList's
    ArrayList<Integer> coursesAll = new ArrayList<Integer>();
    ArrayList<Integer> coursesWeek = new ArrayList<Integer>();
    ArrayList<Integer> done = new ArrayList<Integer>();
    ArrayList<Integer> groups = new ArrayList<Integer>();
    ArrayList<Integer> groupsAll = new ArrayList<Integer>();
    ArrayList<Integer> readLater = new ArrayList<Integer>();
    //String ArrayList's
    ArrayList<String> descriptionsAll = new ArrayList<String>();
    ArrayList<String> descriptionsWeek = new ArrayList<String>();
    ArrayList<String> detailsAll = new ArrayList<String>();
    ArrayList<String> emner = new ArrayList<String>();
    ArrayList<String> emnerAll = new ArrayList<String>();
    ArrayList<String> emnerDone = new ArrayList<String>();
    ArrayList<String> emnerReadLater = new ArrayList<String>();


    public void AllArrays() {
        //Array's containing different types
        //student info
        studentList = new ArrayList<StudentDTO>();
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
        //Groups
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
        //Array's containing Strings
        //DescriptionAll
        descriptionsAll.add("Monday - 39 Aug.\n" + "Session 3 - 13682 pages");
        descriptionsAll.add("Wednesday - 56 Okt.\n" + "Session 6 - 583 pages");
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

    }

    ;


//All getters
    //Other Getter's

    public ArrayList<StudentDTO> getStudentList() {
        return studentList;
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

    //String Getter's

    public ArrayList<String> getDescriptionAll() {
        return descriptionsAll;
    }

    public ArrayList<String> getDescriptionsWeek() {
        return descriptionsWeek;
    }

    public ArrayList<String> getDetailsAll() {
        return detailsAll;
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

    public ArrayList<String> getemnerReadLater() {
        return emnerReadLater;
    }

//All Adders

    public void addStudentList(int a, String b, String c) {
        studentList.add(new StudentDTO(a, b, c));
    }

//All Removers

    public void removeStudentList(int a, String b, String c) {
        studentList.remove(new StudentDTO(a, b, c));
    }

}