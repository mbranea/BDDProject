package CurrentEmployee;

import CurrentClient.CurrentAccount;

public class CurrentEmployee {
	private int id;
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


	private String username;
	private String eMail;
	
	
 private static final CurrentEmployee INSTANCE = new CurrentEmployee();
	 
 public void initialiseCurrentEmployee(int id, String username) 
	{
		this.id = id;
		this.username = username;
		
		
	}

 
	 public static CurrentEmployee getInstance() {
	        
		 return INSTANCE;
	    }
	
	 
	private CurrentEmployee() {
		super();
	}
	
	
	
}
