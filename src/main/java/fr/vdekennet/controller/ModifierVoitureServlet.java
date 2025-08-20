package fr.vdekennet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.vdekennet.model.Voiture;
import fr.vdekennet.repository.VoitureDAO;

/**
 * Servlet implementation class ModifierVoitureServlet
 */
@WebServlet("/ModifierVoitureServlet")
public class ModifierVoitureServlet extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ModifierVoitureServlet - doGet");
		
		request.getRequestDispatcher("modifier.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ModifierVoitureServlet - doPost");
		String trouveMatricule;
		//trouveMatricule = (String) request.getParameter("matricule");
		trouveMatricule = (String) request.getParameter("matricule");
		
		String marque = request.getParameter("VoitureMarque");
		String modele = request.getParameter("VoitureModele");
		String etat = request.getParameter("VoitureEtat");
		
		System.out.println("Valeurs : " + trouveMatricule + "| Marque : " + marque + " " + modele + "| etat : " + etat);
		
		if (trouveMatricule!=null) {
			VoitureDAO.modifier(trouveMatricule, marque, modele, etat);
			System.out.println("Voiture modifiée. Affichage en cours. ");
		}
		
		
		/*
		if (voiture!=null) {
			VoitureDAO.modifier(voiture.getMatricule(), voiture.getMarque(), voiture.getModele(), voiture.getEtat().toString());
		}
		*/
		
		request.getRequestDispatcher("AfficherVoitureServlet").forward(request, response);
	}

}
