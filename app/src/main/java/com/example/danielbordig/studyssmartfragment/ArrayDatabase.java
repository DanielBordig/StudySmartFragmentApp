package com.example.danielbordig.studyssmartfragment;

import java.util.ArrayList;

/**
 * Created by Nicklas Jensen on 07-01-2016.
 */
public class ArrayDatabase {

    int[] coursesWeek = new int[]{
            R.drawable.bmp,
            R.drawable.ns,
            R.drawable.bmp
    };

    int[] coursesAll = new int[]{
            R.drawable.bmp,
            R.drawable.ns,
            R.drawable.bmp,
            R.drawable.ns,
            R.drawable.bmp,
            R.drawable.bmp,
            R.drawable.ns,
            R.drawable.bmp,
            R.drawable.bmp,
            R.drawable.ns,
            R.drawable.ns
    };

    int[] GroupsAll = {
            R.drawable.bmp,
            R.drawable.ns,
    };

    int[] Groups = {
            R.drawable.bmp,
            R.drawable.ns,
            R.drawable.bmp,
            R.drawable.ns,
            R.drawable.bmp,
            R.drawable.bmp,
            R.drawable.ns,
            R.drawable.bmp,
            R.drawable.bmp,
            R.drawable.ns,
            R.drawable.ns,
    };

    int[] GroupsDone = {
            R.drawable.bmp,
            R.drawable.ns,
            R.drawable.bmp,
            R.drawable.ns,
            R.drawable.bmp,
            R.drawable.bmp,
            R.drawable.ns,
            R.drawable.bmp,
            R.drawable.bmp,
            R.drawable.ns,
            R.drawable.ns,
    };

    int[] GroupsReadLater = {
            R.drawable.bmp,
            R.drawable.ns,
            R.drawable.bmp,
            R.drawable.ns,
            R.drawable.bmp,
            R.drawable.bmp,
            R.drawable.ns,
            R.drawable.bmp,
            R.drawable.bmp,
            R.drawable.ns,
            R.drawable.ns,
    };

    // Array of strings storing descriptions for one week of homework
    String[] descriptionsWeek = new String[] {
            "Monday - 39 Aug.\n" +
                    "Session 3 - 13682 pages",
            "Wednesday - 56 Okt.\n" +
                    "Session 6 - 583 pages",
            "Missing description 0"
    };

    // Array of strings storing descriptions all homework
    String[] descriptionAll = new String[] {
            "Monday - 39 Aug.\n" +
                    "Session 3 - 13682 pages",
            "Wednesday - 56 Okt.\n" +
                    "Session 6 - 583 pages",
            "Missing description 0",
            "Missing description 1",
            "Missing description 2",
            "Missing description 3",
            "Missing description 4",
            "Missing description 5",
            "Missing description 6",
            "Missing description 7",
            "Missing description 8"
    };

    // Array of strings storing details for one week of homework
    String[] detailsAll = new String[] {
            "This homework is awesome, you better read it.\nBook: Naruto 1-72",
            "This homework sucks, and is not recommended as necessary.\nBook: Fifty Shades of Grey",
            "Missing details 0",
            "Missing details 1",
            "Missing details 2",
            "Missing details 3",
            "Missing details 4",
            "Missing details 5",
            "Missing details 6",
            "Missing details 7",
            "Missing details 8"
    };

    String[] EmneAll = {
            " ",
            " ",
    };

    String[] Emne = {
            "Monday - 39 Aug.\n" +
                    "Session 3 - 13682 pages",
            "Wednesday - 56 Okt.\n" +
                    "Session 6 - 583 pages",
            "Missing description 0",
            "Missing description 1",
            "Missing description 2",
            "Missing description 3",
            "Missing description 4",
            "Missing description 5",
            "Missing description 6",
            "Missing description 7",
            "Missing description 8",
    };

    String[] EmneDone = {
            "Monday - 39 Aug.\n" +
                    "Session 3 - 13682 pages",
            "Wednesday - 56 Okt.\n" +
                    "Session 6 - 583 pages",
            "Missing description 0",
            "Missing description 1",
            "Missing description 2",
            "Missing description 3",
            "Missing description 4",
            "Missing description 5",
            "Missing description 6",
            "Missing description 7",
            "Missing description 8",
    };

    String[] EmneReadLater = {
            "Monday - 39 Aug.\n" +
                    "Session 3 - 13682 pages",
            "Wednesday - 56 Okt.\n" +
                    "Session 6 - 583 pages",
            "Missing description 0",
            "Missing description 1",
            "Missing description 2",
            "Missing description 3",
            "Missing description 4",
            "Missing description 5",
            "Missing description 6",
            "Missing description 7",
            "Missing description 8",
    };

    ArrayList<StudentDTO> studentList;

    public void Students(){
        studentList = new ArrayList<StudentDTO>();
        studentList.add(new StudentDTO(1, "Daniel", "qwert"));
        studentList.add(new StudentDTO(2, "Zohra", "12345"));
        studentList.add(new StudentDTO(3, "Geziena", "asdf"));
        studentList.add(new StudentDTO(4, "Nicklas", "zxcv"));
        studentList.add(new StudentDTO(5, "Bob", "trewq"));
        studentList.add(new StudentDTO(6, "q", "q"));
    };

//All getters

    public int[] getCoursesWeek() {
        return coursesWeek;
    }

    public int[] getGroupsAll() {
        return GroupsAll;
    }

    public int[] getCoursesAll() {
        return coursesAll;
    }

    public int[] getGroups() {
        return Groups;
    }

    public int[] getGroupsDone() {
        return GroupsDone;
    }

    public int[] getGroupsReadLater() {
        return GroupsReadLater;
    }

    public String[] getDescriptionAll() {
        return descriptionAll;
    }

    public String[] getDescriptionsWeek() {
        return descriptionsWeek;
    }

    public String[] getDetailsAll() {
        return detailsAll;
    }

    public String[] getEmne() {
        return Emne;
    }

    public String[] getEmneAll() {
        return EmneAll;
    }

    public String[] getEmneDone() {
        return EmneDone;
    }

    public String[] getEmneReadLater() {
        return EmneReadLater;
    }

    public ArrayList<StudentDTO> getStudentList() {
        return studentList;
    }
}
