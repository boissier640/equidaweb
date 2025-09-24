package test;

import model.Cheval;
import model.Race;
import model.Lot;

public class TestCheval {

    public static void main (String args[]){

        // création d'une instance de cheval nommée c
        Cheval c = new Cheval();
        c.setId(2);
        c.setNom("Houri");

        // création d'une instance de race nommée r
        Race r = new Race();
        r.setId(1);
        r.setNom("pur-sang");

        //affectation de  la race au cheval grâce à la relation ManyToOne
        c.setRace(r);

        // Affichage des informations dans la console
        //voir notamment du nom de la race du cheval
        System.out.println("Cheval : " + c.getId() + " " + c.getNom() + " "
                + c.getRace().getId() + " " + c.getRace().getNom());
    
        // instantiation d'une race
        c.setId(4);
        c.setNom("Gold Ship");

        // instanciation de 2 chevaux c1 et c2
        // ajout des chevaux c1 et c2 à l'arraylist des chevaux grâce
        // à la relation OneToMany
        Lot l1 = new Lot();
        l1.setId(1);
        l1.setPrixDepart(15000.00);
        c.addLot(l1);

        Lot l2 = new Lot();
        l2.setId(7);
        l2.setPrixDepart(15000.00);
        c.addLot(l2);

        //Affichage des informations de la race
        System.out.println("Le cheval " + c.getId() + " " + c.getNom() + " est présent dans " + c.getLesLots().size() + " Lot " );
        System.out.println("Liste des lots contenant ce cheval : ");

		// Affichage des informations sur chevaux liées à la race
        for (Lot l : c.getLesLots()){
            System.out.println("Lot numero : " + l.getId() + " " + l.getPrixDepart());
        }
    }  
}
