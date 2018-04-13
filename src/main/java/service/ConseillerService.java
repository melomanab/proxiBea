package service;

import java.util.ArrayList;

import dao.ClientDao;
import dao.ConseillerDao;
import domaine.Client;
import domaine.Conseiller;

public class ConseillerService {

	// TODO Decommenter apres rajout des classes daos
	//// Declaration DaoS + rajout Constructeur qui l'instancient
	 ConseillerDao conseillerDao;
	 ClientDao clientDao;
	  

	public ConseillerService() {
		super();
		this.conseillerDao = new ConseillerDao();
		this.clientDao = new ClientDao();
	}

	public boolean authentification(Conseiller conseillerFromLogin) {
		boolean conseillerExistant = false;

		// TODO recuperation liste conseillers
		ArrayList<Conseiller> allConseillers =(ArrayList<Conseiller>) this.conseillerDao.getAll();

		/*
		// TODO effacer liste provisoire
		ArrayList<Conseiller> allConseillers = new ArrayList<Conseiller>();
		allConseillers.add(new Conseiller(1, "login1", "password1"));
		allConseillers.add(new Conseiller(2, "login2", "password2"));
		allConseillers.add(new Conseiller(3, "login3", "password3"));
		*/

		String login = conseillerFromLogin.getLogin();
		String password = conseillerFromLogin.getPassword();

		// Pour chaque conseiller de la BD, 
		// si une entree coincide avec le login et password 
		// saisis par l'utilisateur, l'ID conseiller est
		// rajouté au conseiller entrée en paramètre de la methode
		for (Conseiller conseiller : allConseillers) {

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
	
	public ArrayList<Client> listeDeClients(Conseiller conseillerFromLogin){
		
		ArrayList<Client> listeClientsConseiller = new ArrayList<Client>();
		
		//TODO appel dao client pour recuperation liste clients
		ArrayList<Client> allClients = (ArrayList<Client>) this.clientDao.getAll();
				
		//TODO effacer liste allClients provisoire
		// new Client("nom", "prenom", "email", "numeroVoie", "voie", "codePostal", "ville", 1);
/*		ArrayList<Client> allClients = new ArrayList<Client>();
		allClients.add(new Client(1, "nom1", "prenom1", "email1", "numeroVoie1", "voie1", "codePostal1", "ville1", 1));
		allClients.add(new Client(2, "nom2", "prenom2", "email2", "numeroVoie2", "voie2", "codePostal2", "ville2", 2));
		allClients.add(new Client(3, "nom3", "prenom3", "email3", "numeroVoie3", "voie3", "codePostal3", "ville3", 1));
		allClients.add(new Client(4, "nom4", "prenom4", "email4", "numeroVoie4", "voie4", "codePostal4", "ville4", 2));
*/		
		for (Client cl : allClients) {
			if (cl.getIdConseiller() == conseillerFromLogin.getIdConseiller()){
				listeClientsConseiller.add(cl);
			}
		}
		
		return listeClientsConseiller;
	}

}
