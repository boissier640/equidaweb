/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

/**
 *
 * @author sio2
 */
import model.Cheval;
import model.Lot;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoLot {
    Connection cnx;
    static PreparedStatement requeteSql = null;
    static ResultSet resultatRequete = null;

    /**
     * Récupère tous les chevaux présents dans la base de données avec leurs races associées
     * @param cnx La connexion active à la base de données
     * @return ArrayList<Lot> La liste de tous les chevaux trouvés
     */
    public static ArrayList<Lot> getLesLots(Connection cnx) {
        ArrayList<Lot> lesLots = new ArrayList<Lot>();
        try {
            requeteSql = cnx.prepareStatement(
                "SELECT l.id as l_id, l.prixDepart  as l_prixDepart , c.nom as c_nom , v.vente as v_vente" +
                "FROM lot l " +
                "INNER JOIN cheval c ON l.numCheval = c.id"
            );
            resultatRequete = requeteSql.executeQuery();
            while (resultatRequete.next()) {
                Lot l = new Lot();
                l.setId(resultatRequete.getInt("l_id"));
                l.setPrixDepart(resultatRequete.getDouble("l_prixDepart"));
                Cheval c = new Cheval();
                c.setId(resultatRequete.getInt("c_id"));
                c.setNom(resultatRequete.getString("c_nom"));
                l.setCheval(c);
                lesLots.add(l);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("La requête de getLesLots a généré une exception SQL");
        }
        return lesLots;
    }

    /**
     * Récupère un cheval spécifique par son identifiant
     * @param cnx La connexion active à la base de données
     * @param id L'identifiant du cheval recherché
     * @return Cheval Le cheval trouvé ou null si non trouvé
     */
    public static Lot getLeLot(Connection cnx, int idLot) {
        Lot l = null;
        try {
            requeteSql = cnx.prepareStatement(
                "SELECT l.id as l_id, l.prixDepart  as l_prixDepart , c.nom as c_nom , v.vente as v_vente" +
                "FROM lot l " +
                "INNER JOIN cheval c ON l.numCheval = c.id" +
                "WHERE c.id = ?"
            );
            requeteSql.setInt(1, idLot);
            resultatRequete = requeteSql.executeQuery();
            if (resultatRequete.next()) {
                l = new Lot();
                l.setId(resultatRequete.getInt("l_id"));
                l.setPrixDepart(resultatRequete.getDouble("l_prixDepart"));
                Cheval c = new Cheval();
                c.setId(resultatRequete.getInt("c_id"));
                c.setNom(resultatRequete.getString("c_nom"));
                l.setCheval(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("La requête de getLeLot a généré une exception SQL");
        }
        return l;
    }
    /**
     * Ajoute un nouveau cheval dans la base de données
     * @param cnx La connexion active à la base de données
     * @param cheval Le cheval à ajouter
     * @return boolean true si l'ajout a réussi, false sinon
     */
    public static boolean ajouterLot(Connection cnx, Cheval cheval) {
    try {
        requeteSql = cnx.prepareStatement(
            "INSERT INTO cheval (nom, date_naissance, race_id) VALUES (?, ?, ?)",
            PreparedStatement.RETURN_GENERATED_KEYS
        );
        requeteSql.setString(1, cheval.getNom());
        
        // Gestion de la date de naissance
        if (cheval.getDateNaissance() != null) {
            requeteSql.setDate(2, java.sql.Date.valueOf(cheval.getDateNaissance()));
        } else {
            requeteSql.setNull(2, java.sql.Types.DATE);
        }
        
        requeteSql.setInt(3, cheval.getRace().getId());
        
        int result = requeteSql.executeUpdate();
        
        if (result == 1) {
            // Récupération de l'id auto-généré
            ResultSet rs = requeteSql.getGeneratedKeys();
            if (rs.next()) {
                cheval.setId(rs.getInt(1));
            }
            return true;
        }
        return false;
        
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Erreur lors de l'ajout du cheval");
        return false;
    }
}
}
