package domaine;

/**
 * @author Stagiaire
 *
 */
public class Client {

	private int idClient;
	private String nom; 
	private String prenom;
	private String email; 
	private String numeroVoie;
	private String voie;
	private String codePostal;
	private String ville;
	private int idConseiller;
	
	public Client(int idClient, String nom, String prenom, String email, String numeroVoie, String voie,
			String codePostal, String ville, int idConseiller) {
		super();
		this.idClient = idClient;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.numeroVoie = numeroVoie;
		this.voie = voie;
		this.codePostal = codePostal;
		this.ville = ville;
		this.idConseiller = idConseiller;
	}


	public Client(String nom, String prenom, String email, String numeroVoie, String voie, String codePostal,
			String ville, int idConseiller) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.numeroVoie = numeroVoie;
		this.voie = voie;
		this.codePostal = codePostal;
		this.ville = ville;
		this.idConseiller = idConseiller;
	}


	public Client() {
		super();
	}


	public int getIdClient() {
		return idClient;
	}


	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getNumeroVoie() {
		return numeroVoie;
	}


	public void setNumeroVoie(String numeroVoie) {
		this.numeroVoie = numeroVoie;
	}


	public String getVoie() {
		return voie;
	}


	public void setVoie(String voie) {
		this.voie = voie;
	}


	public String getCodePostal() {
		return codePostal;
	}


	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}


	public int getIdConseiller() {
		return idConseiller;
	}


	public void setIdConseiller(int idConseiller) {
		this.idConseiller = idConseiller;
	}
	
	
	
	
	
	
	
 } 