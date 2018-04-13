package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;

import domaine.Client;
public class ClientDao   {

	ConnexionMySql con;
	Connection maConexion;
	
	public ClientDao() {
		super();
		this.con = new ConnexionMySql();
		this.maConexion =con.getConnexionMySQL("proxibanque");
	}
	public boolean create( Client client ) {
		boolean reponse = false; // Cr�ation de la variable de sortie
		Statement stmt ;
		try {
			System.out.println(client);
			
			stmt = maConexion.createStatement();
			String sql = "INSERT INTO `client`("
					+ "`nom`,"
					+ " `prenom`,"
					+ "`idConseiller`, "
					+ "`voie`,"
					+ "`numeroVoie`,"
					+ "`ville`,"
					+ "`codePostal`,"
					+ "`email` ) VALUES ('" + 
					client.getNom()
			+ "', '" + client.getPrenom() 
			+ "', " + client.getIdConseiller() 
			+ ", '"+ client.getVoie() + "', '"
			+ client.getNumeroVoie() + "', '"
			+ client.getVille() + "', '"
			+ client.getCodePostal() + "', '"
			+ client.getEmail() + "');";
			
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


	public Client get(int id) {
		Client monClient = new Client(); // Cr�ation de la variable de sortie
		Statement stmt;
		try {
			stmt = maConexion.createStatement();
			String sql = "SELECT * FROM `client` WHERE idClient = "
					+ id; 
			ResultSet result = stmt.executeQuery(sql); // Ex�cution de la requ�te
			result.next();
			monClient.setIdClient(result.getInt("idClient")); // R�cup�ration des donn�es
			monClient.setNom(result.getString("nom"));
			monClient.setPrenom(result.getString("prenom"));
			monClient.setEmail(result.getString("email"));
			monClient.setIdConseiller(result.getInt("idConseiller"));
			monClient.setVoie(result.getString("voie"));
			monClient.setCodePostal(result.getString("codepostal"));
			monClient.setVille(result.getString("ville"));
			monClient.setNumeroVoie(result.getString("numeroVoie"));
			
			return monClient; // retour de la r�ponse
		} catch (SQLException e) {
			System.out.println("Probl�me lors de la r�cup�ration du client !");
			e.printStackTrace();
			return monClient;
		}
	}


	public Client update(Client monClient) {
		Statement stmt;
		try {
			stmt = maConexion.createStatement();
			String sql = "UPDATE `client` SET `nom` = '" + monClient.getNom() + "', `prenom` = '"
					+ monClient.getPrenom() + "', `email` = '" + monClient.getEmail() + "', `numeroVoie` = '"
					+ monClient.getNumeroVoie() + "',`voie`='"+monClient.getVoie()+"',`ville`='"+monClient.getVille()+"',`codePostal`='"+monClient.getCodePostal()+"' WHERE `idClient` = " + monClient.getIdClient();			
			int result = stmt.executeUpdate(sql); // Ex�cution de la requ�te
			if (result > 0) {
				return monClient; // retour de la r�ponse
			} else {
				System.out.println("Un probl�me est survenu lors de la modification du client.");
				return monClient;// retour de la r�ponse
			}
		} catch (SQLException e) {
			System.out.println("Probl�me lors de la modification du client !");
			e.printStackTrace();
			return monClient;// retour de la r�ponse
		}
	}


	public boolean delete(Client monClient) {
		boolean reponse = false; // Cr�ation variable de retour
		Statement stmt;
		try {
			stmt = maConexion.createStatement();
			String sql = "DELETE FROM client WHERE `idClient` = " + monClient.getIdClient();

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
		List<Client> listClient = new ArrayList<Client>();
		Statement stmt;
		try {
			stmt = maConexion.createStatement();
			String sql = "SELECT * FROM `client`;";
			ResultSet result = stmt.executeQuery(sql); // Ex�cution de la requ�te
			while (result.next()) {
				Client monClient = new Client(); // Cr�ation de la variable de sortie
				monClient.setIdClient(result.getInt("idClient")); // R�cup�ration des donn�es
				monClient.setNom(result.getString("nom"));
				monClient.setPrenom(result.getString("prenom"));
				monClient.setEmail(result.getString("email"));
				monClient.setNumeroVoie(result.getString("numeroVoie"));
				monClient.setVoie(result.getString("voie"));
				monClient.setVille(result.getString("ville"));
				monClient.setCodePostal(result.getString("codePostal"));
				monClient.setIdConseiller(result.getInt("idConseiller"));
				listClient.add(monClient);
			}
			return listClient; // retour de la r�ponse
		} catch (SQLException e) {
			System.out.println("Probl�me lors de la r�cup�ration des client !");
			e.printStackTrace();
			return listClient;
		}
	}

	
}
