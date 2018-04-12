package presentation;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domaine.Conseiller;
import services.ConseillerService;

/**
 * Servlet implementation class ServletLogin
 */
// === SOURTOUT NE PAS DECOMMENTER ====
// @WebServlet("/servletlogin")
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
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		System.out.println("doGet de la servlet /ServletLogin");
		response.getWriter().append("doGet de la servlet /ServletLogin").append(request.getContextPath());

		this.getServletContext().getRequestDispatcher("/liste-clients.jsp").forward(request, response);

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

		// 1.--Recup infos formulaire 
		String login = request.getParameter("login");
		String password = request.getParameter("password");


		// Instantiation conseiller a partir des parametres rentrés
		// par l'utilisater
		Conseiller conseillerFromLogin = new Conseiller(login, password);

		// 2.--Appel service

		// Instantiation conseiller Service
		ConseillerService cs = new ConseillerService();
		// Appel methode authentification de ConseillerService
		boolean conseillerExistant = cs.authentification(conseillerFromLogin);

		// boolean conseillerExistant = (password.equals("PASSWORD"));

		// 3.-- Page a renvoyer
		
		
		// Données dynamiques
		request.setAttribute("login", conseillerFromLogin.getLogin());
		request.setAttribute("password", conseillerFromLogin.getPassword());
		
		RequestDispatcher distpatcher;

		if (conseillerExistant) {
			HttpSession session = request.getSession();
			session.setAttribute("conseillerSession", conseillerFromLogin);
			// Appel ConseillerService methode listeDeClients(Conseiller c): ArrayList<Client>
			// ====================
//			ArrayList<Client> listeClientsConseiller = cs.listeDeClients(conseillerFromLogin);
//			
//			request.setAttribute("listeClients", listeClientsConseiller);

			distpatcher = request.getRequestDispatcher("/ServletListeClients");
			distpatcher.forward(request, response);

		} else {
			distpatcher = request.getRequestDispatcher("erreur-authentification.jsp");
			distpatcher.forward(request, response);
		}

		// out.close();

		// distpatcher.forward(request, response);

	}

}
