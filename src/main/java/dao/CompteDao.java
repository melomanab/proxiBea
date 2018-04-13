package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;

import domaine.Compte;
public class CompteDao   {

	ConnexionMySql con;
	Connection maConexion;
	
	public CompteDao() {
		super();
		this.con = new ConnexionMySql();
		this.maConexion =con.getConnexionMySQL("proxibanque");
	}
	public boolean create( Compte compte ) {
		boolean reponse = false; // Cr�ation de la variable de sortie
		Statement stmt ;
		try {
			System.out.println(compte);
			
			stmt = maConexion.createStatement();
			String sql = "INSERT INTO `client`("
					+ "`numeroCompte`,"
					+ " `typeCompte`,"
					+ "`solde`, "
					+ "`idClient` ) VALUES ('" + 
					compte.getNumeroCompte()
			+ "', '" + compte.getTypeCompte() 
			+ "', " + compte.getSolde() 
			+ ", "+ compte.getIdClient() + ");";
			
			int result = stmt.executeUpdate(sql); // Ex�cution de la requ�te
			if (result > 0) { // Lecture des r�sultats
				reponse = true;
			} else {
				reponse = false;
			}
			return reponse; // retour de la r�ponse
		} catch (SQLException e) {
			System.out.println("Probl�me lors de la cr�ation du client !");
			e.printStackTrace();
			return reponse;
		}
		
	}


	public Compte get(int id) {
		Compte compte = new Compte(); // Cr�ation de la variable de sortie
		Statement stmt;
		try {
			stmt = maConexion.createStatement();
			String sql = "SELECT * FROM `client` WHERE idClient = "
					+ id; 
			ResultSet result = stmt.executeQuery(sql); // Ex�cution de la requ�te
			result.next();
			compte.setIdCompte(result.getInt("idCompte")); // R�cup�ration des donn�es
			compte.setNumeroCompte(result.getString("numeroCompte"));
			compte.setTypeCompte(result.getString("typeCompte"));
			compte.setIdClient(result.getInt("idClient"));

			
			return compte; // retour de la r�ponse
		} catch (SQLException e) {
			System.out.println("Probl�me lors de la r�cup�ration du client !");
			e.printStackTrace();
			return compte;
		}
	}
	public Compte get(String numCompte) {
		Compte compte = new Compte(); // Cr�ation de la variable de sortie
		Statement stmt;
		try {
			stmt = maConexion.createStatement();
			String sql = "SELECT * FROM `client` WHERE sumeroCompte = "
					+ numCompte; 
			ResultSet result = stmt.executeQuery(sql); // Ex�cution de la requ�te
			result.next();
			compte.setIdCompte(result.getInt("idCompte")); // R�cup�ration des donn�es
			compte.setNumeroCompte(result.getString("numeroCompte"));
			compte.setTypeCompte(result.getString("typeCompte"));
			compte.setIdClient(result.getInt("idClient"));

			
			return compte; // retour de la r�ponse
		} catch (SQLException e) {
			System.out.println("Probl�me lors de la r�cup�ration du client !");
			e.printStackTrace();
			return compte;
		}
	}

	public Compte update(Compte compte, String numeroCompte) {
		Statement stmt;
		try {
			stmt = maConexion.createStatement();
			String sql = "UPDATE `compte` SET `solde` = " + compte.getSolde() +" WHERE numeroCompte="+numeroCompte;
			int result = stmt.executeUpdate(sql); // Ex�cution de la requ�te
			if (result > 0) {
				return compte; // retour de la r�ponse
			} else {
				System.out.println("Un probl�me est survenu lors de la modification du client.");
				return compte;// retour de la r�ponse
			}
		} catch (SQLException e) {
			System.out.println("Probl�me lors de la modification du client !");
			e.printStackTrace();
			return compte;// retour de la r�ponse
		}
	}


	public boolean delete(Compte compte) {
		boolean reponse = false; // Cr�ation variable de retour
		Statement stmt;
		try {
			stmt = maConexion.createStatement();
			String sql = "DELETE FROM compte WHERE `idCompte` = " + compte.getIdCompte();

			int result = stmt.executeUpdate(sql); // Ex�cution de la requ�te
			if (result > 0) { // Lecture des r�sultats
				reponse = true;
			} else {
				reponse = false;
			}
			return reponse; // retour de la r�ponse
		} catch (SQLException e) {
			System.out.println("Probl�me lors de la suppression du client !");
			e.printStackTrace();
			return reponse;
		}
	}


	public List getAll() {
		List<Compte> listCompte = new ArrayList<Compte>();
		Statement stmt;
		try {
			stmt = maConexion.createStatement();
			String sql = "SELECT * FROM `compte`;";
			ResultSet result = stmt.executeQuery(sql); // Ex�cution de la requ�te
			while (result.next()) {
				Compte compte = new Compte(); // Cr�ation de la variable de sortie
				compte.setIdCompte(result.getInt("idCompte")); // R�cup�ration des donn�es
				compte.setNumeroCompte(result.getString("numCompte"));
				compte.setTypeCompte(result.getString("typeCompte"));
				compte.setIdClient(result.getInt("idClient"));
				
				listCompte.add(compte);
			}
			return listCompte; // retour de la r�ponse
		} catch (SQLException e) {
			System.out.println("Probl�me lors de la r�cup�ration des client !");
			e.printStackTrace();
			return listCompte;
		}
	}

	
}
