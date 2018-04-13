package domaine;

public class Compte {

	private int idCompte;
	private String  numeroCompte;
	private String typeCompte;
	private double solde;
	private int idClient;
	
	public Compte(int idCompte, String numeroCompte, String typeCompte, double solde, int idClient) {
		super();
		this.idCompte = idCompte;
		this.numeroCompte = numeroCompte;
		this.typeCompte = typeCompte;
		this.solde = solde;
		this.idClient = idClient;
	}

	public Compte(String numeroCompte, String typeCompte, double solde, int idClient) {
		super();
		this.numeroCompte = numeroCompte;
		this.typeCompte = typeCompte;
		this.solde = solde;
		this.idClient = idClient;
	}
	

	public Compte() {
		super();
	}

	public int getIdCompte() {
		return idCompte;
	}

	public void setIdCompte(int idCompte) {
		this.idCompte = idCompte;
	}

	public String getNumeroCompte() {
		return numeroCompte;
	}

	public void setNumeroCompte(String numeroCompte) {
		this.numeroCompte = numeroCompte;
	}

	public String getTypeCompte() {
		return typeCompte;
	}

	public void setTypeCompte(String typeCompte) {
		this.typeCompte = typeCompte;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	
	
	
	
	
	
}
