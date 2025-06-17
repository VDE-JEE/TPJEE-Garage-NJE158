package fr.vdekennet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		String trouveMatricule = (String) request.getAttribute("matricule");
		String marque = (String) request.getAttribute("VoitureMarque");
		String modele = (String) request.getAttribute("VoitureModele");
		String etat = (String) request.getAttribute("VoitureEtat");
		System.out.println("Valeurs : " + trouveMatricule + " Marque " + marque + " " + modele + " etat " + etat);
		
		if (trouveMatricule!=null) {
			VoitureDAO.modifier(trouveMatricule, marque, modele, etat);
			System.out.println("Modification effectuée.");
		}
		
		
		request.getRequestDispatcher("modifier.jsp").forward(request, response);
	}

}
