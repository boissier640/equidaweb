/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author sio2
 */
public class Lot {
    private int id;
    private double prixDepart;
    
    private Vente vente;
    private Cheval cheval;

    public Lot() {
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public double getPrixDepart() {
        return prixDepart;
    }

    public void setPrixDepart(Double prixDepart) {
        this.prixDepart = prixDepart;
    }

    public Cheval getCheval() {
        return cheval;
    }
    
    public void setCheval(Cheval cheval) {
        this.cheval = cheval;
    }
    
    public Vente getVente() {
        return vente;
    }
    
    public void setVente(Vente vente) {
        this.vente = vente;
    }

}

