package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Cheval {

    private int id;
    private String nom;
    private LocalDate dateNaissance;
    
    private ArrayList<Lot> lesLots ;
    private ArrayList<CourseCheval> lesCoursesChevaux ;
    private Cheval chevalPere;
    private Cheval chevalMere;
    private Race race;

    public Cheval() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
    public Race getRace() {
        return race;
    }
    public void setRace(Race race) {
        this.race = race;
    }
    public ArrayList<Lot> getLesLots() {
        return lesLots;
    }
    public void setLesLots(ArrayList<Lot> lesLots) {
        this.lesLots = lesLots;
    }
    
    public void addLot(Lot unLot){
        if (lesLots ==null ){
            lesLots = new ArrayList<Lot>();
        }
        lesLots.add(unLot);
    }

    public Cheval getChevalPere() {
        return chevalPere;
    }

    public Cheval getChevalMere() {
        return chevalMere;
    }   

    public void setChevalPere(Cheval chevalPere) {
        this.chevalPere = chevalPere;
    }

    public void setChevalMere(Cheval chevalMere) {
        this.chevalMere = chevalMere;
    }
    
    public ArrayList<CourseCheval> getLesCoursesChevaux() {
        return lesCoursesChevaux;
    }
    public void setLesCoursesChevaux(ArrayList<CourseCheval> lesCoursesChevaux) {
        this.lesCoursesChevaux = lesCoursesChevaux;
    }
    
    public void addCourseCheval(CourseCheval uneCourseCheval){
        if (lesCoursesChevaux ==null ){
            lesCoursesChevaux = new ArrayList<CourseCheval>();
        }
        lesCoursesChevaux.add(uneCourseCheval);
    }
}
