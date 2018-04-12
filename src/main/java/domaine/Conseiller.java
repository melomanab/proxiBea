package domaine;

public class Conseiller {
		
	private int idConseiller;
	private String  login;
	private String password;
	
	public Conseiller(int idConseiller, String login, String password) {
		super();
		this.idConseiller = idConseiller;
		this.login = login;
		this.password = password;
	}


	public Conseiller(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}

	public int getIdConseiller() {
		return idConseiller;
	}

	public void setIdConseiller(int idConseiller) {
		this.idConseiller = idConseiller;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	

}
