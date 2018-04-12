package services;

import java.util.ArrayList;

import domaine.Conseiller;

public class ConseillerService {

	// TO-DO Declaration Dao
	// ConseillerDao conseillerDao;

	/**
	 * @param conseillerFromLogin
	 * @return
	 */
	public boolean authentification(Conseiller conseillerFromLogin) {
		boolean conseillerExistant = false;

		// TO-DO recuperation liste conseillers
		// listeConseillers = conseillerDao.getAll()
		ArrayList<Conseiller> listeConseillers = new ArrayList<Conseiller>();
		listeConseillers.add(new Conseiller(1, "login1", "password1"));
		listeConseillers.add(new Conseiller(2, "login2", "password2"));
		listeConseillers.add(new Conseiller(3, "login3", "password3"));

		String login = conseillerFromLogin.getLogin();
		String password = conseillerFromLogin.getPassword();

		// Pour chaque conseiller de la BD, 
		// si une entree coincide avec le login et password 
		// saisis par l'utilisateur, l'ID conseiller est
		// rajouté au conseiller entrée en paramètre de la methode
		for (Conseiller conseiller : listeConseillers) {

			if (login.equals(conseiller.getLogin())) {
				if (password.equals(conseiller.getPassword())) {					
					int idConseillerFromBD= conseiller.getIdConseiller();
					conseillerFromLogin.setIdConseiller(idConseillerFromBD);
					return true;
				}

			}
		}

		return conseillerExistant;
	}

}
