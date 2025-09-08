/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author sio2
 */
public class Lieu {
   private int id;
   private String libelle;
   private int nbBoxes;
   private String commentaire;


    public Lieu() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String nom) {
        this.libelle = libelle;
    }
    
    public int getNbBoxes() {
        return nbBoxes;
    }

    public void setNbBoxes(int nbBoxes) {
        this.nbBoxes = nbBoxes;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String nom) {
        this.commentaire = commentaire;
    }
}
