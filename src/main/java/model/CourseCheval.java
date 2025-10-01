/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Time;

/**
 *
 * @author sio2
 */
public class CourseCheval {
    private Time temp;
    private String position;

    private Cheval cheval ;
    private Course course;

    public CourseCheval() {
    }

    public Time getTemp() {
        return temp;
    }

    public String getPosition() {
        return position;
    }

    public Cheval getCheval() {
        return cheval;
    }

    public void setTemp(Time temp) {
        this.temp = temp;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setCheval(Cheval cheval) {
        this.cheval = cheval;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
    
}
