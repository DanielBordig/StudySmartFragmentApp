package com.example.danielbordig.studyssmartfragment;

import java.util.ArrayList;

/**
 * Created by Daniel Bordig on 30-11-2015.
 */
public class StudentDAO {

    ArrayList<StudentDTO> studentList;

    public StudentDAO() {
        studentList = new ArrayList<StudentDTO>();
        studentList.add(new StudentDTO(1, "Daniel", "qwert"));
        studentList.add(new StudentDTO(2, "Zohra", "12345"));
        studentList.add(new StudentDTO(3, "Geziena", "asdf"));
        studentList.add(new StudentDTO(4, "Nicklas", "zxcv"));
        studentList.add(new StudentDTO(5, "Bob", "trewq"));
        studentList.add(new StudentDTO(6, "q", "q"));
    }

    public ArrayList<StudentDTO> getStudents(){
        return studentList;
    }

    public String Login(String name, String password){
        String returnName = "";
        for(int i = 0; i < studentList.size(); i++) {
        if(studentList.get(i).name.equals(name)){
            returnName = "trueName";
            if(studentList.get(i).password.equals(password)){
                return "true";
            }
        }
    }
        if(!returnName.isEmpty()) return returnName;
        else return "falseUser";
    }
}
