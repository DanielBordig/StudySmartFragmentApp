package com.example.danielbordig.studyssmartfragment;

public class StudentDTO {

    String name, password;
    int id;

    public StudentDTO(int id, String name, String password) {
        this.name = name;
        this.password = password;
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }
}
