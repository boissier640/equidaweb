/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import java.time.LocalDate;
import model.Vente;
import model.Lot;
import model.Cheval;
/**
 *
 * @author sio2
 */
public class TestVente {

    public static void main (String args[]){

        // création d'une instance de cheval nommée c
        Vente v = new Vente();
        v.setId(2);
        v.setNom("été");
        v.setDateDebutVente(LocalDate.MIN);
        v.setDateFinVente(LocalDate.MIN);
        // création d'une instance de race nommée r
        Lot l = new Lot();
        l.setId(1);
        l.setPrixDepart(15000.0);

        //affectation de  la race au cheval grâce à la relation ManyToOne
        Cheval c = new Cheval ();
        c.setId(2);
        c.setNom ("Gold-ship");
        
        l.setCheval(c);
        l.setVente (v);

        // Affichage des informations dans la console
        //voir notamment du nom de la race du cheval
        System.out.println("Le lot " + l.getId() + " contenant le cheval " + l.getCheval().getNom() + " sera vendu lors de la vente "
                + l.getVente().getNom());
    }
}

