package com.example.danielbordig.studyssmartfragment;

import java.util.ArrayList;

public class StudentDAO {

    ArrayList<StudentDTO> studentList;

    public StudentDAO() {
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
