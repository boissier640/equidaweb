/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author sio2
 */
public class Vente {
    private int id;
    private String nom;
    private LocalDate dateDebutVente;
    private LocalDate dateFinVente; 
    private String objectifMessage;
    private String corpsMessage;
    
    private Lieu lieu;
    private CategVente categVente;
    private ArrayList<Lot> lesLots ;

    public Vente() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public LocalDate getDateDebutVente() {
        return dateDebutVente;
    }

    public void setDateDebutVente(LocalDate dateDebutVente) {
        this.dateDebutVente = dateDebutVente;
    }
    
    public LocalDate getDateFinVente() {
        return dateFinVente;
    }

    public void setDateFinVente(LocalDate dateFinVente) {
        this.dateFinVente = dateFinVente;
    }
    
     public String getObjectifMessage() {
        return objectifMessage;
    }
    
    public void setObjectifMessage(String objectifMessage) {
        this.objectifMessage = objectifMessage;
    }

     public String getCorpsMessage() {
        return corpsMessage;
    }
    
    public void setCorpsMessage(String corpsMessage) {
        this.corpsMessage = corpsMessage;
    }
    
    public Lieu getLieu() {
        return lieu;
    }
    public void setLieu(Lieu lieu) {
        this.lieu = lieu;
    }
    
    public CategVente getCategVente() {
        return categVente;
    }
    public void setCategVente(CategVente categVente) {
        this.categVente = categVente;
    }

    public void setDateDebutVente(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public ArrayList<Lot> getLesLots() {
        return lesLots;
    }
    public void setLesLots(ArrayList<Lot> lesLots) {
        this.lesLots = lesLots;
    }

    public void addLot(Lot unLot){
        if (lesLots ==null ){
            lesLots = new ArrayList<Lot>();
        }
        lesLots.add(unLot);
    }
}


