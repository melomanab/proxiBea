package service;

import java.util.ArrayList;

import dao.ClientDao;
import dao.CompteDao;
import domaine.Client;
import domaine.Compte;

public class ClientService {

	// Declaration DaoS + rajout Constructeur qui l'instancient
	ClientDao clientDao;
	CompteDao compteDao;

	public ClientService() {
		super();
		this.clientDao = new ClientDao();
		this.compteDao = new CompteDao();
	}

	// Recupere client de la BD a partir de l'ID client
	// A utiliser dans le DoGet
	public Client recupererClient(int idClientFromUser) {
		Client clientFromDB = new Client();

		clientFromDB = this.clientDao.get(idClientFromUser);

		return clientFromDB;
	}

	// Update client en fonction des infos introduites sur ecran n°3
	// A utiliser dans le DoPost
	// Bonne signature update ????????????????
	public boolean modificationClient(Client clientFromUser) {

		boolean clientModifie=false;
		Client client = this.clientDao.update(clientFromUser);

		if (!clientFromUser.getNom().isEmpty()) {
			clientModifie = true;
		}
		return clientModifie;
	}
	
	public ArrayList<Compte> comptesClient (Client clientFromUser){
		
		ArrayList<Compte> listeComptes = new ArrayList<Compte>();
		
		// Recup comptes DB
		ArrayList<Compte> allComptes = (ArrayList<Compte>) this.compteDao.getAll();
		System.out.println(allComptes.isEmpty());
		
		for (Compte compte : allComptes) {			
			System.out.println("compte:" + compte.getNumeroCompte());
			
			if (compte.getIdClient() == clientFromUser.getIdClient()) {
				listeComptes.add(compte);
				System.out.println("compte rajouté");
			}
		}
		return listeComptes;
		
	}

}
