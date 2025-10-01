/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import database.Connexionbdd;
import database.DaoVente;
import java.sql.Connection;

/**
 *
 * @author sio2
 */

public class TestDaoVente {

    public static void main (String args[]) {
        
        Connection cnx = Connexionbdd.ouvrirConnexion();
        System.out.println ("nombre de vente = " + DaoVente.getLesVentes(cnx).size());
        System.out.println ("La vente" + DaoVente.getLaVente(cnx, 1).getId() + " est " + DaoVente.getLaVente(cnx, 1).getNom() + " de categorie " + DaoVente.getLaVente(cnx, 1).getCategVente().getLibelle() + " aura lieu à " + DaoVente.getLaVente(cnx, 1).getLieu().getLibelle());
        System.out.println ("Le nombre de lot afilié à la vente est de " + DaoVente.getLesLotsById(cnx, 1).size());
    }
}

