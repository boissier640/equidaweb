/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author sio2
 */
public class Course {
    private int id;
    private String nom;
    private String Lieu;
    private Date date;


    public Course() {
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getLieu() {
        return Lieu;
    }

    public Date getDate() {
        return date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setLieu(String Lieu) {
        this.Lieu = Lieu;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    }
