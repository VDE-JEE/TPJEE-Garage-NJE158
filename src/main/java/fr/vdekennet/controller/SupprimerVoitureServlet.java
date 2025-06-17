package fr.vdekennet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.vdekennet.repository.VoitureDAO;

/**
 * Servlet implementation class SupprimerVoitureServlet
 */
@WebServlet("/SupprimerVoitureServlet")
public class SupprimerVoitureServlet extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SupprimerVoitureServlet - doGet");
		request.getRequestDispatcher("supprimer.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SupprimerVoitureServlet - doPost");
		
		String trouveMatricule = (String) request.getAttribute("matricule");
		System.out.println("Matricule à delete : " + trouveMatricule);
		
		if (trouveMatricule!=null) {
			VoitureDAO.supprimer(trouveMatricule);
			System.out.println("Suppression effectuée.");
		} else System.out.println("Suppression NON effectuée.");
		
		
		request.getRequestDispatcher("supprimer.jsp").forward(request, response);
	}

}
