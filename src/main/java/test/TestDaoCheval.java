/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import database.Connexionbdd;
import database.DaoCheval;
import java.sql.Connection;

/**
 *
 * @author sio2
 */
public class TestDaoCheval {
    public static void main (String args[]) {
        
        Connection cnx = Connexionbdd.ouvrirConnexion();
        System.out.println ("Le cheval " + DaoCheval.getLeCheval(cnx, 11).getId() + " est " + DaoCheval.getLeCheval(cnx, 11).getNom() + " et est de race " + DaoCheval.getLeCheval(cnx, 11).getRace().getNom());


    }
}
