/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.CategVente;
import model.Vente;
import model.Lieu;
import model.Lot;
import model.Cheval;


/**
 *
 * @author sio2
 */
public class DaoVente {
    static PreparedStatement requeteSql = null;
    static ResultSet resultatRequete = null;

    /**
     * Récupère toutes les races présentes dans la base de données
     * @param cnx La connexion active à la base de données
     * @return ArrayList<Vente> La liste de toutes les ventes trouvées
     */
    public static ArrayList<Vente> getLesVentes(Connection cnx) {
        ArrayList<Vente> lesVentes = new ArrayList<Vente>();
        try {
            requeteSql = cnx.prepareStatement(
                "SELECT v.id as v_id, v.nom as v_nom, v.dateDebut as v_dateDebut, v.dateFin as v_dateFin, v.objectifMessage as v_objectifMessage, v.corpsMessage as v_corpsMessage, l.libelle as l_libelle, cv.libelle as cv_libelle FROM vente v INNER JOIN lieu l ON v.lieu = l.id INNER JOIN categorieVente cv ON v.categorie = cv.id ORDER BY v.id"
            );
            resultatRequete = requeteSql.executeQuery();
            while (resultatRequete.next()) {
                Vente vente = new Vente();
                vente.setId(resultatRequete.getInt("v_id"));
                vente.setNom(resultatRequete.getString("v_nom"));
                vente.setDateDebutVente(resultatRequete.getDate("v_dateDebut").toLocalDate());
                vente.setDateFinVente(resultatRequete.getDate("v_dateFin").toLocalDate());
                vente.setObjectifMessage(resultatRequete.getString("v_objectifMessage"));
                vente.setCorpsMessage(resultatRequete.getString("v_corpsMessage"));
                Lieu lieu = new Lieu();
                lieu.setLibelle(resultatRequete.getString("l_libelle"));
                vente.setLieu(lieu);
                CategVente categVente = new CategVente();
                categVente.setLibelle(resultatRequete.getString("cv_libelle"));
                vente.setCategVente(categVente);
                
                lesVentes.add(vente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("La requête de getLesVentes a généré une exception SQL");
        }
        return lesVentes;
    }

    /**
     * Récupère une race spécifique par son identifiant
     * @param cnx La connexion active à la base de données
     * @param id L'identifiant de la race recherchée
     * @return Race La race trouvée ou null si non trouvée
     */
    public static Vente getLaVente(Connection cnx, int id) {
        ArrayList<Lot> lesLots = new ArrayList<Lot>();
        Vente v = null;
        try {
            requeteSql = cnx.prepareStatement(
                "SELECT v.id as v_id, v.nom as v_nom, v.dateDebut as v_dateDebut, v.dateFin as v_dateFin, v.objectifMessage as v_objectifMessage, v.corpsMessage as v_corpsMessage, l.libelle as l_libelle, cv.libelle as cv_libelle, lt.id as lt_id, lt.prixDepart as lt_prixDepart, c.nom as c_nom FROM vente v INNER JOIN lieu l ON v.lieu = l.id INNER JOIN lot lt ON lt.numVente = v.id INNER JOIN categorieVente cv ON v.categorie = cv.id INNER JOIN cheval c ON lt.numCheval = c.id WHERE v.id = ?");
            requeteSql.setInt(1, id);
            resultatRequete = requeteSql.executeQuery();
            if (resultatRequete.next()) {
                v = new Vente();
                v.setId(resultatRequete.getInt("v_id"));
                v.setNom(resultatRequete.getString("v_nom"));
                v.setDateDebutVente(resultatRequete.getDate("v_dateDebut").toLocalDate());
                v.setDateFinVente(resultatRequete.getDate("v_dateFin").toLocalDate());
                v.setObjectifMessage(resultatRequete.getString("v_objectifMessage"));
                v.setCorpsMessage(resultatRequete.getString("v_corpsMessage"));
                Lieu l = new Lieu();
                l.setLibelle(resultatRequete.getString("l_libelle"));
                v.setLieu(l);
                CategVente c = new CategVente();
                c.setLibelle(resultatRequete.getString("cv_libelle"));
                v.setCategVente(c);
                 }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("La requête de getLaVente a généré une exception SQL");
        }
        return v;
    }
                
    public static Vente getLesLots(Connection cnx, int id) {
        ArrayList<Lot> lesLots = new ArrayList<Lot>();
        Vente v = null;
        try {
            requeteSql = cnx.prepareStatement(
                "SELECT v.id as v_id, v.nom as v_nom, v.dateDebut as v_dateDebut, v.dateFin as v_dateFin, v.objectifMessage as v_objectifMessage, v.corpsMessage as v_corpsMessage, l.libelle as l_libelle, cv.libelle as cv_libelle, lt.id as lt_id, lt.prixDepart as lt_prixDepart, c.nom as c_nom FROM vente v INNER JOIN lieu l ON v.lieu = l.id INNER JOIN lot lt ON lt.numVente = v.id INNER JOIN categorieVente cv ON v.categorie = cv.id INNER JOIN cheval c ON lt.numCheval = c.id WHERE v.id = ?");
            requeteSql.setInt(1, id);
            resultatRequete = requeteSql.executeQuery();
            if (resultatRequete.next()) {
                Lot lt = new Lot();
                
                
                 }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("La requête de getLaVente a généré une exception SQL");
        }
        return v;
    }
}
