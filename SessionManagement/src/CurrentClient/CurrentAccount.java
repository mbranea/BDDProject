package CurrentClient;

public class CurrentAccount {

	 private static final CurrentAccount INSTANCE = new CurrentAccount();
	 
	 public static CurrentAccount getInstance() {
	        
		 return INSTANCE;
	    }
	 @Override
	 public String toString() 
	 {
		 return this.id+this.username+this.eMail+this.nume+this.prenume+this.telefon;
	 }
	 
	private CurrentAccount() {
		super();
	}

	private int id;
	private String username;
	private String eMail;
	private String nume;
	private String prenume;
	private String telefon;

	public void initialiseCurrentAccount(int id, String username, String eMail, String nume, String prenume,
			String telefon) 
	{
		this.id = id;
		this.username = username;
		this.eMail = eMail;
		this.nume = nume;
		this.prenume = prenume;
		this.telefon = telefon;
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getPrenume() {
		return prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

}
