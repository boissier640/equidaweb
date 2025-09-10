/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import model.Lieu;
import model.Vente;
/**
 *
 * @author sio2
 */
public class TestLieu {
  public static void main (String args[]){
        // instantiation d'une race
        Lieu l = new Lieu();
        l.setId(4);
        l.setLibelle("Tokyo sall");

        // instanciation de 2 chevaux c1 et c2
        // ajout des chevaux c1 et c2 à l'arraylist des chevaux grâce
        // à la relation OneToMany
        Vente v1 = new Vente();
        v1.setId(1);
        v1.setNom("ete");
        l.addVente(v1);

        Vente v2 = new Vente();
        v2.setId(7);
        v2.setNom("d'hiver");
        l.addVente(v2);

        //Affichage des informations de la race
        System.out.println("Dans le lieu " + l.getId() + " " + l.getLibelle() + " se tiendrons " + l.getLesVentes().size() + " ventes " );
        System.out.println("Liste des ventes se tenant dans ce lieu : ");

		// Affichage des informations sur chevaux liées à la race
        for (Vente c : l.getLesVentes()){
            System.out.println("Ventes numéro : " + c.getId() + " " + c.getNom());
        }
    }  
}
