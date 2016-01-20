package com.example.danielbordig.studyssmartfragment;

/**
 * Created by Daniel Bordig on 07-01-2016.
 */
public class HomeworkDTO {

    int dbId, course;
    String date, description, detail;

    public HomeworkDTO(int dbId, String date, int course, String description, String detail){
        this.dbId = dbId;
        this.date = date;
        this.course = course;
        this.description = description;
        this.detail = detail;
    }

    public int getDbId() {return dbId;}

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCourse(){return course;}

    public void setCourse(int course){this.course = course;}

    public String getDescription(){return description;}

    public void setDescription(String description){this.description = description;}

    public String getDetail(){return detail;}

    public void setDetail(String detail){this.detail = detail;}
}
