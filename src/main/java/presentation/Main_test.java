package presentation;

import java.util.ArrayList;

import dao.ClientDao;
import domaine.Client;
import domaine.Compte;
import domaine.Conseiller;
import service.ClientService;
import service.ConseillerService;

public class Main_test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("--ConseillerService:");
		ConseillerService cs = new ConseillerService();
		Conseiller conseillerFromLogin = new Conseiller ("haricot", "blanc");
		
		System.out.println("--ConseillerService: authentification");	
		boolean res = cs.authentification(conseillerFromLogin);		
		System.out.println(res);		
		System.out.println(conseillerFromLogin.getIdConseiller());
		
		
		System.out.println("--ConseillerService: listeClients");	
		ArrayList<Client> clientsDuConseiller = (ArrayList<Client>) cs.listeDeClients(conseillerFromLogin);
		for (Client c: clientsDuConseiller) {
			System.out.println(c.getIdClient());
		}
		
		System.out.println("--ClientService:");
		ClientService clientServ = new ClientService();
		System.out.println("--ClientService: recupererClient");	
		
		int idFromUser= 11;
		Client clientFromBD = clientServ.recupererClient(idFromUser);
		
		// Test si client existant en DB
		if(clientFromBD.getNom()!=null) {
		System.out.println(clientFromBD.getIdClient());	
		System.out.println(clientFromBD.getNom());	
		System.out.println(clientFromBD.getVille());
		}
		
		System.out.println("--ClientService: modifierClient");	
		Client monClient = clientServ.recupererClient(idFromUser);
		
		// modif mannuelle
		monClient.setNom("MORENOOOOOOOOOOOOOO");
		
		boolean clientModifie = clientServ.modificationClient(monClient);
		System.out.println(clientModifie);
		System.out.println(monClient.getNom());	
		
		
		System.out.println("--ClientService: comptesClient");
	
		monClient.setIdClient(11);
		ArrayList<Compte> comptesClient = (ArrayList<Compte>) clientServ.comptesClient(monClient);
		for (Compte compte: comptesClient) {
			System.out.println(compte.getNumeroCompte());
		}


				
					
	}

}
