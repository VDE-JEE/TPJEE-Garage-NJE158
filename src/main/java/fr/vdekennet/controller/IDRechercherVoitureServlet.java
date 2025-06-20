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
 * Servlet implementation class IDRechercherVoitureServlet
 */
@WebServlet("/IDRechercherVoitureServlet")
public class IDRechercherVoitureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("IDRechercherVoituresServlet - doGet");
		request.getRequestDispatcher("/rechercherid.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("IDRechercherVoituresServlet - doPost");
		
		String trouve = request.getParameter("aTrouver");
		
		System.out.println("Voiture à rechercher par ID: " + trouve);
		Voiture Voiture = VoitureDAO.rechercherID(trouve);
		
		if (Voiture!=null) {
			request.setAttribute("Voitures", Voiture);
			System.out.println("Voiture trouvée par ID récupérée en attribut.");
		} else { 
			request.setAttribute("Voitures", null);
			System.out.println("Echec de la récupération de la Voiture trouvée par ID.");
		}
		String alter = request.getParameter("alter");
		System.out.println("choix du user : " + alter);
		String matriculeT = Voiture.getMatricule();
		request.setAttribute("matricule", matriculeT);
		request.setAttribute("voiture", Voiture);
		if ("modifier".equals(alter)) {
			request.getRequestDispatcher("modifier.jsp").forward(request, response);
		}
		else {
			if ("supprimer".equals(alter)) {
				request.getRequestDispatcher("supprimer.jsp").forward(request, response);
			}
		}
		
	}

}
