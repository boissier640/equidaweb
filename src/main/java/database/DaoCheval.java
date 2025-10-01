package database;

import model.Cheval;
import model.Race;
import model.CourseCheval;
import model.Course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class DaoCheval {
    Connection cnx;
    static PreparedStatement requeteSql = null;
    static ResultSet resultatRequete = null;

    /**
     * Récupère tous les chevaux présents dans la base de données avec leurs races associées
     * @param cnx La connexion active à la base de données
     * @return ArrayList<Cheval> La liste de tous les chevaux trouvés
     */
    public static ArrayList<Cheval> getLesChevaux(Connection cnx) {
        ArrayList<Cheval> lesChevaux = new ArrayList<Cheval>();
        try {
            requeteSql = cnx.prepareStatement(
                "SELECT c.id as c_id, c.nom as c_nom, " +
                "r.id as r_id, r.nom as r_nom " +
                "FROM cheval c " +
                "INNER JOIN race r ON c.race_id = r.id"
            );
            resultatRequete = requeteSql.executeQuery();
            while (resultatRequete.next()) {
                Cheval c = new Cheval();
                c.setId(resultatRequete.getInt("c_id"));
                c.setNom(resultatRequete.getString("c_nom"));
                Race r = new Race();
                r.setId(resultatRequete.getInt("r_id"));
                r.setNom(resultatRequete.getString("r_nom"));
                c.setRace(r);
                lesChevaux.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("La requête de getLesChevaux a généré une exception SQL");
        }
        return lesChevaux;
    }

    /**
     * Récupère un cheval spécifique par son identifiant
     * @param cnx La connexion active à la base de données
     * @param id L'identifiant du cheval recherché
     * @return Cheval Le cheval trouvé ou null si non trouvé
     */
    public static Cheval getLeCheval(Connection cnx, int idCheval) {
        Cheval cheval = null;
        try {
            requeteSql = cnx.prepareStatement(
                "SELECT c.id as c_id, c.nom as c_nom, r.id as r_id, r.nom as r_nom, cpere.nom as cpere_nom, cmere.nom as cmere_nom FROM cheval c INNER JOIN race r ON c.race_id = r.id INNER JOIN cheval cpere ON c.pere = cpere.id INNER JOIN cheval cmere ON c.mere = cmere.id WHERE c.id = ?");
            requeteSql.setInt(1, idCheval);
            resultatRequete = requeteSql.executeQuery();
            if (resultatRequete.next()) {
                cheval = new Cheval();
                cheval.setId(resultatRequete.getInt("c_id"));
                cheval.setNom(resultatRequete.getString("c_nom"));
                Race race = new Race();
                race.setId(resultatRequete.getInt("r_id"));
                race.setNom(resultatRequete.getString("r_nom"));
                cheval.setRace(race);
                Cheval cp = new Cheval();
                cp.setId(resultatRequete.getInt("cpere_id"));
                cp.setNom(resultatRequete.getString("cpere_nom"));
                cheval.setChevalPere(cp);
                Cheval cm = new Cheval();
                cm.setId(resultatRequete.getInt("cmere_id"));
                cm.setNom(resultatRequete.getString("cmere_nom"));
                cheval.setChevalMere(cm);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("La requête de getLeCheval a généré une exception SQL");
        }
        return cheval;
    }
    /**
     * Ajoute un nouveau cheval dans la base de données
     * @param cnx La connexion active à la base de données
     * @param cheval Le cheval à ajouter
     * @return boolean true si l'ajout a réussi, false sinon
     */
    public static boolean ajouterCheval(Connection cnx, Cheval cheval) {
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
    public static ArrayList<CourseCheval> getLesCoursesChevauxById(Connection cnx, int id) {
        ArrayList<CourseCheval> lesCousesChevaux = new ArrayList<CourseCheval>();
        try {
            requeteSql = cnx.prepareStatement("SELECT cc.position as cc_position, cc.temps as cc_temps, c.nom as c_nom, c.lieu as c_lieu, c.date as c_date FROM courseCheval cc INNER JOIN course c ON cc.course = c.id INNER JOIN cheval ch ON cc.cheval = ch.id WHERE ch.id = ?");
            requeteSql.setInt(1, id);
            resultatRequete = requeteSql.executeQuery();
            while (resultatRequete.next()) {
                CourseCheval cc = new CourseCheval();
                cc.setPosition(resultatRequete.getString("cc_position"));
                cc.setTemp(resultatRequete.getTime("cc_temps"));
                Course c = new Course();
                c.setNom(resultatRequete.getString("c_nom"));
                c.setLieu(resultatRequete.getString("c_lieu"));
                c.setDate(resultatRequete.getDate("c_date"));
                cc.setCourse(c);
                lesCousesChevaux.add(cc);
                 }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("La requête de getLesLots a généré une exception SQL");
        }
        return lesCousesChevaux;
    }
}