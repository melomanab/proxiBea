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
		boolean reponse = false; // Création de la variable de sortie
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
			
			int result = stmt.executeUpdate(sql); // Exécution de la requête
			if (result > 0) { // Lecture des résultats
				reponse = true;
			} else {
				reponse = false;
			}
			return reponse; // retour de la réponse
		} catch (SQLException e) {
			System.out.println("Problème lors de la création du client !");
			e.printStackTrace();
			return reponse;
		}
		
	}


	public Compte get(int id) {
		Compte compte = new Compte(); // Création de la variable de sortie
		Statement stmt;
		try {
			stmt = maConexion.createStatement();
			String sql = "SELECT * FROM `client` WHERE idClient = "
					+ id; 
			ResultSet result = stmt.executeQuery(sql); // Exécution de la requête
			result.next();
			compte.setIdCompte(result.getInt("idCompte")); // Récupération des données
			compte.setNumeroCompte(result.getString("numeroCompte"));
			compte.setTypeCompte(result.getString("typeCompte"));
			compte.setIdClient(result.getInt("idClient"));

			
			return compte; // retour de la réponse
		} catch (SQLException e) {
			System.out.println("Problème lors de la récupération du client !");
			e.printStackTrace();
			return compte;
		}
	}
	public Compte get(String numCompte) {
		Compte compte = new Compte(); // Création de la variable de sortie
		Statement stmt;
		try {
			stmt = maConexion.createStatement();
			String sql = "SELECT * FROM `client` WHERE sumeroCompte = "
					+ numCompte; 
			ResultSet result = stmt.executeQuery(sql); // Exécution de la requête
			result.next();
			compte.setIdCompte(result.getInt("idCompte")); // Récupération des données
			compte.setNumeroCompte(result.getString("numeroCompte"));
			compte.setTypeCompte(result.getString("typeCompte"));
			compte.setIdClient(result.getInt("idClient"));

			
			return compte; // retour de la réponse
		} catch (SQLException e) {
			System.out.println("Problème lors de la récupération du client !");
			e.printStackTrace();
			return compte;
		}
	}

	public Compte update(Compte compte, String numeroCompte) {
		Statement stmt;
		try {
			stmt = maConexion.createStatement();
			String sql = "UPDATE `compte` SET `solde` = " + compte.getSolde() +" WHERE numeroCompte="+numeroCompte;
			int result = stmt.executeUpdate(sql); // Exécution de la requête
			if (result > 0) {
				return compte; // retour de la réponse
			} else {
				System.out.println("Un problème est survenu lors de la modification du client.");
				return compte;// retour de la réponse
			}
		} catch (SQLException e) {
			System.out.println("Problème lors de la modification du client !");
			e.printStackTrace();
			return compte;// retour de la réponse
		}
	}


	public boolean delete(Compte compte) {
		boolean reponse = false; // Création variable de retour
		Statement stmt;
		try {
			stmt = maConexion.createStatement();
			String sql = "DELETE FROM compte WHERE `idCompte` = " + compte.getIdCompte();

			int result = stmt.executeUpdate(sql); // Exécution de la requête
			if (result > 0) { // Lecture des résultats
				reponse = true;
			} else {
				reponse = false;
			}
			return reponse; // retour de la réponse
		} catch (SQLException e) {
			System.out.println("Problème lors de la suppression du client !");
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
			ResultSet result = stmt.executeQuery(sql); // Exécution de la requête
			while (result.next()) {
				Compte compte = new Compte(); // Création de la variable de sortie
				compte.setIdCompte(result.getInt("idCompte")); // Récupération des données
				compte.setNumeroCompte(result.getString("numCompte"));
				compte.setTypeCompte(result.getString("typeCompte"));
				compte.setIdClient(result.getInt("idClient"));
				
				listCompte.add(compte);
			}
			return listCompte; // retour de la réponse
		} catch (SQLException e) {
			System.out.println("Problème lors de la récupération des client !");
			e.printStackTrace();
			return listCompte;
		}
	}

	
}
