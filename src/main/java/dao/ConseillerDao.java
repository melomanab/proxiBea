package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;

import domaine.Client;
import domaine.Conseiller;
public class ConseillerDao   {

	ConnexionMySql con;
	Connection maConexion;
	
	public ConseillerDao() {
		super();
		this.con = new ConnexionMySql();
		this.maConexion =con.getConnexionMySQL("proxibanque");
	}



	public Conseiller get(int id) {
		Conseiller conseiller = new Conseiller(); // Cr�ation de la variable de sortie
		Statement stmt;
		try {
			stmt = maConexion.createStatement();
			String sql = "SELECT * FROM `client` WHERE idClient = "
					+ id; 
			ResultSet result = stmt.executeQuery(sql); // Ex�cution de la requ�te
			result.next();
			conseiller.setIdConseiller(result.getInt("idConseiller")); // R�cup�ration des donn�es
			conseiller.setLogin(result.getString("Login"));
			conseiller.setPassword(result.getString("password"));
			
			
			return conseiller; // retour de la r�ponse
		} catch (SQLException e) {
			System.out.println("Probl�me lors de la r�cup�ration du client !");
			e.printStackTrace();
			return conseiller;
		}
	}
	
	public List getAll() {
		List<Conseiller> listConseillers = new ArrayList<Conseiller>();
		Statement stmt;
		try {
			stmt = maConexion.createStatement();
			String sql = "SELECT * FROM `conseiller`;";
			ResultSet result = stmt.executeQuery(sql); // Ex�cution de la requ�te
			while (result.next()) {
				Conseiller monConseiller = new Conseiller(); // Cr�ation de la variable de sortie
				monConseiller.setIdConseiller(result.getInt("idConseiller")); // R�cup�ration des donn�es
				monConseiller.setLogin(result.getString("login"));
				monConseiller.setPassword(result.getString("password"));

				listConseillers.add(monConseiller);
			}
			return listConseillers; // retour de la r�ponse
		
		} catch (SQLException e) {
			System.out.println("Probl�me lors de la r�cup�ration des client !");
			e.printStackTrace();
			return listConseillers;
		}
	}



	
	
}
