package fr.vdekennet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.vdekennet.model.EtatVoiture;
import fr.vdekennet.model.Voiture;
import fr.vdekennet.repository.VoitureDAO;

/**
 * Servlet implementation class AjouterVoitureServlet
 */
@WebServlet("/AjouterVoitureServlet")
public class AjouterVoitureServlet extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AjouterVoituresServlet - doGet");
		
		request.getRequestDispatcher("/ajouter.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AjouterVoituresServlet - doPost");
		String matricule = (String) request.getParameter("matriculeV");
		String marque = (String) request.getParameter("marqueV");
		String modele = (String) request.getParameter("modeleV");
		String etatStr = (String) request.getParameter("etatV");
		System.out.println("Voiture " + matricule + " " + marque + " " + modele + " " + etatStr );
		VoitureDAO.ajouter(matricule, marque, modele, etatStr);
		request.getRequestDispatcher("/AfficherVoitureServlet").forward(request, response);
	}

}
