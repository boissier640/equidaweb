/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

/**
 *
 * @author sio2
 */
import model.CategVente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoCategVente {
    static PreparedStatement requeteSql = null;
    static ResultSet resultatRequete = null;

    /**
     * Récupère toutes les races présentes dans la base de données
     * @param cnx La connexion active à lai base de données
     * @return ArrayList<CategVente> La liste de toutes les races trouvées
     */
    public static ArrayList<CategVente> getLesCategVentes(Connection cnx) {
        ArrayList<CategVente> lesCategVentes = new ArrayList<CategVente>();
        try {
            requeteSql = cnx.prepareStatement(
                "SELECT id, libelle FROM categorievente ORDER BY libelle"
            );
            resultatRequete = requeteSql.executeQuery();
            while (resultatRequete.next()) {
                CategVente cv = new CategVente();
                cv.setId(resultatRequete.getInt("id"));
                cv.setLibelle(resultatRequete.getString("libelle"));
                lesCategVentes.add(cv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("La requête de getLesCategVentes a généré une exception SQL");
        }
        return lesCategVentes;
    }

    /**
     * Récupère une race spécifique par son identifiant
     * @param cnx La connexion active à la base de données
     * @param id L'identifiant de la race recherchée
     * @return Race La race trouvée ou null si non trouvée
     */
    public static CategVente getRaceById(Connection cnx, int id) {
        CategVente cv = null;
        try {
            requeteSql = cnx.prepareStatement(
                "SELECT id, libelle FROM categorievente WHERE id = ?"
            );
            requeteSql.setInt(1, id);
            resultatRequete = requeteSql.executeQuery();
            if (resultatRequete.next()) {
                cv = new CategVente();
                cv.setId(resultatRequete.getInt("id"));
                cv.setLibelle(resultatRequete.getString("libelle"));
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("La requête de getCategVenteById a généré une exception SQL");
        }
        return cv;
    }
}
