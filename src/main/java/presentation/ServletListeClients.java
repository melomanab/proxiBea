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
import domaine.Conseiller;
import service.ConseillerService;

/**
 * Servlet implementation class ServletListeClients
 */
public class ServletListeClients extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletListeClients() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

//		System.out.println("doGet de la servlet /ServletLogin");
//		response.getWriter().append("doGet de la servlet /ServletLogin").append(request.getContextPath());
//
//		this.getServletContext().getRequestDispatcher("/liste-clients.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		// System.out.println("doGet de la servlet /ServletLogin");
		// PrintWriter out = response.getWriter();
		// out.append("doPost de la servlet /ServletLogin");
		// out.append(request.getContextPath());
		/*
		 
		 */
		// 1.--Recup infos de SESSION
		HttpSession session = request.getSession();
		Conseiller conseiller = (Conseiller) session.getAttribute("conseillerSession");

		// 2.--Appel service

		// Instantiation conseiller Service
		ConseillerService cs = new ConseillerService();

		// Appel ConseillerService methode listeDeClients(Conseiller c):
		// ArrayList<Client>
		// ====================
		ArrayList<Client> listeClientsConseiller = cs.listeDeClients(conseiller);

		// 3.-- Page a renvoyer
		// HttpSession maSession = request.getSession();

		// Données dynamiques
		request.setAttribute("listeClients", listeClientsConseiller);

		RequestDispatcher distpatcher;

		distpatcher = request.getRequestDispatcher("/liste-clients.jsp");
		distpatcher.forward(request, response);

		// out.close();

		// distpatcher.forward(request, response);

	}
}
