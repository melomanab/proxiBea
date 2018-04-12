package presentation;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domaine.Client;

/**
 * Servlet implementation class ServletLogin
 */

public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);


		
		// 1.--Recup infos formulaire
		String login = request.getParameter("login");
		String password = request.getParameter("password");

		// 2.--Passer les infos couche service

		// TO-DO ==============
		// boolean conseillerExistant = ServiceConseiller.authentification();
		// ====================

		boolean conseillerExistant = true;

		// 3.-- Page à renvoyer
		request.setAttribute("login", login);
		request.setAttribute("password", password);

		HttpSession maSession = request.getSession();
		RequestDispatcher distpatcher;
		
		if (conseillerExistant) {


			// TO-DO ==============
			// appel à listeDeClients(Conseiller c): ArrayList<Client>
			// ====================
			ArrayList<Client> maListeClients = new ArrayList<Client>();
			Client clientBD = new Client("nom", "prenom", "email", "numeroVoie", "voie", "codePostal", "ville", 1);

			maListeClients.add(clientBD);
			request.setAttribute("listeClients", maListeClients);

			
			distpatcher = request.getRequestDispatcher("/liste-clients-TEST.html");

		} else {

			
		
			distpatcher=request.getRequestDispatcher("/erreur-authentification.jsp");
		}

		
		distpatcher.forward(request, response);

	}

}
