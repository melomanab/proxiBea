package presentation;

import domaine.Conseiller;
import service.ConseillerService;

public class Main_test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Conseiller conseillerFromLogin = new Conseiller ("login3", "password3");
		ConseillerService cs = new ConseillerService();
		boolean res = cs.authentification(conseillerFromLogin);
		
		System.out.println(res);		
		System.out.println(conseillerFromLogin.getIdConseiller());
	}

}
