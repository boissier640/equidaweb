/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

/**
 *
 * @author sio2
 */
import model.Lieu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoLieu {
    static PreparedStatement requeteSql = null;
    static ResultSet resultatRequete = null;

    /**
     * Récupère toutes les races présentes dans la base de données
     * @param cnx La connexion active à lai base de données
     * @return ArrayList<Lieu> La liste de toutes les races trouvées
     */
    public static ArrayList<Lieu> getLesLieux(Connection cnx) {
        ArrayList<Lieu> lesLieux = new ArrayList<Lieu>();
        try {
            requeteSql = cnx.prepareStatement(
                "SELECT id, libelle, nb_boxes, commentaire FROM lieu ORDER BY libelle"
            );
            resultatRequete = requeteSql.executeQuery();
            while (resultatRequete.next()) {
                Lieu lieu = new Lieu();
                lieu.setId(resultatRequete.getInt("id"));
                lieu.setLibelle(resultatRequete.getString("libelle"));
                lieu.setNbBoxes(resultatRequete.getInt("nb_boxes"));
                lieu.setCommentaire(resultatRequete.getString("commentaire"));
                lesLieux.add(lieu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("La requête de getLesLieux a généré une exception SQL");
        }
        return lesLieux;
    }

    /**
     * Récupère une race spécifique par son identifiant
     * @param cnx La connexion active à la base de données
     * @param id L'identifiant de la race recherchée
     * @return Race La race trouvée ou null si non trouvée
     */
    public static Lieu getRaceById(Connection cnx, int id) {
        Lieu l = null;
        try {
            requeteSql = cnx.prepareStatement(
                "SELECT id, libelle, nb_boxes, commentaire FROM lieu WHERE id = ?"
            );
            requeteSql.setInt(1, id);
            resultatRequete = requeteSql.executeQuery();
            if (resultatRequete.next()) {
                l = new Lieu();
                l.setId(resultatRequete.getInt("id"));
                l.setLibelle(resultatRequete.getString("libelle"));
                l.setNbBoxes(resultatRequete.getInt("nb_boxes"));
                l.setCommentaire(resultatRequete.getString("commentaire"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("La requête de getLieuById a généré une exception SQL");
        }
        return l;
    }
}
