package fr.vdekennet.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.vdekennet.model.Voiture;
import fr.vdekennet.repository.VoitureDAO;

/**
 * Servlet implementation class AfficherVoitureServlet
 */
@WebServlet(description = "affiche les voitures de la Base de données", urlPatterns = { "/AfficherVoitureServlet" })
public class AfficherVoitureServlet extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AfficherVoituresServlet - doGet");
		doPost(request, response);
		request.getRequestDispatcher("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AfficherVoituresServlet - doPost");
		
		List<Voiture> listeVoitures = VoitureDAO.afficher();
		
		if (listeVoitures!=null) {
			request.setAttribute("Voitures", listeVoitures);
			System.out.println("Liste voiture récupérée en attribut.");
		} else { 
			request.setAttribute("Voitures", null);
			System.out.println("Echec de la récupération de la liste.");
		}
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
