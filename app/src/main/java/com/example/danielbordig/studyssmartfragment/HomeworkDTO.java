package com.example.danielbordig.studyssmartfragment;

/**
 * Created by Daniel Bordig on 07-01-2016.
 */
public class HomeworkDTO {

    int course;
    String description, detail;

    public HomeworkDTO(int course, String description, String detail){
        this.course = course;
        this.description = description;
        this.detail = detail;
    }

    public int getCourse(){return course;}

    public void setCourse(int course){this.course = course;}

    public String getDescription(){return description;}

    public void setDescription(String description){this.description = description;}

    public String getDetail(){return detail;}

    public void setDetail(String detail){this.detail = detail;}
}
