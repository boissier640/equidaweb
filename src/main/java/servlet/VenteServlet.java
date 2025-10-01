/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servlet;

/**
 *
 * @author sio2
 */

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import database.DaoVente;
import database.DaoLieu;
import database.DaoLot;
import database.DaoCategVente;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Vente;
import model.Lieu;
import model.CategVente;
import model.Lot;
import java.time.LocalDate;

@WebServlet(name = "venteServlet", value = "/vente-servlet/*")
public class VenteServlet extends HttpServlet {

    Connection cnx;
    
    @Override
    public void init() {
        ServletContext servletContext = getServletContext();
        cnx = (Connection)servletContext.getAttribute("connection");
        try {
            System.out.println("INIT SERVLET=" + cnx.getSchema());
        } catch (SQLException ex) {
            Logger.getLogger(VenteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String path = request.getPathInfo();
        System.out.println("PathInfo: " + path);

        if ("/list".equals(path)) {
            ArrayList<Vente> lesVentes = DaoVente.getLesVentes(cnx);
            request.setAttribute("pLesVentes", lesVentes);
            this.getServletContext().getRequestDispatcher("/WEB-INF/views/vente/list.jsp").forward(request, response);
        }
        if ("/show".equals(path)) {
            try {
                int idVente = Integer.parseInt(request.getParameter("idVente"));
                Vente laVente = DaoVente.getLaVente(cnx, idVente);

                if (laVente != null) {
                    request.setAttribute("pLaVente", laVente);
                    this.getServletContext().getRequestDispatcher("/WEB-INF/views/vente/show.jsp").forward(request, response);
                } else {
                    response.sendRedirect(request.getContextPath() + "/vente-servlet/lister");
                }
            } catch (NumberFormatException e) {
                System.out.println("Erreur : l'id de la vente n'est pas un nombre valide");
                response.sendRedirect(request.getContextPath() + "/vente-servlet/lister");
            }

        }

       /* if ("/add".equals(path)) {
            ArrayList<Lieu> lesLieux = DaoLieu.getLesLieux(cnx);
            request.setAttribute("pLesLieux", lesLieux);
            this.getServletContext().getRequestDispatcher("/WEB-INF/views/vente/add.jsp").forward(request, response);
        }*/


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getPathInfo();

        if ("/add".equals(path)) {
            try {
                /* // Récupération des données du formulaire
                String nom = request.getParameter("nom");
                String dateNaissanceStr = request.getParameter("dateNaissance");
                int raceId = Integer.parseInt(request.getParameter("race"));

                // Création d'un nouveau cheval
                Vente nouveauCheval = new Vente();
                nouveauCheval.setNom(nom);

                // Gestion de la date de naissance
                if (dateNaissanceStr != null && !dateNaissanceStr.isEmpty()) {
                    LocalDate dateNaissance = LocalDate.parse(dateNaissanceStr);
                    nouveauCheval.setDateNaissance(dateNaissance);
                }

                // Récupération et attribution de la race
                Race race = DaoRace.getRaceById(cnx, raceId);
                if (race != null) {
                    nouveauCheval.setRace(race);
                } else {
                    throw new Exception("La race sélectionnée n'existe pas");
                }

                // Tentative d'ajout en base de données
                if (DaoCheval.ajouterCheval(cnx, nouveauCheval)) {
                    // Redirection vers la page de consultation du cheval nouvellement créé
                    response.sendRedirect(request.getContextPath() + "/cheval-servlet/show?idCheval=" + nouveauCheval.getId());
                } else {
                    throw new Exception("Erreur lors de l'enregistrement du cheval");
                }*/
                   
            } catch (NumberFormatException e) {
                request.setAttribute("message", "Erreur : la race sélectionnée n'est pas valide");
                request.setAttribute("pLesLieux", DaoLieu.getLesLieux(cnx));
                this.getServletContext().getRequestDispatcher("/WEB-INF/views/vente/add.jsp").forward(request, response);
            } catch (Exception e) {
                request.setAttribute("message", "Erreur : " + e.getMessage());
                request.setAttribute("pLesLieux", DaoLieu.getLesLieux(cnx));
                this.getServletContext().getRequestDispatcher("/WEB-INF/views/vente/add.jsp").forward(request, response);
            }
        }
    }

    public void destroy() {
    }
}