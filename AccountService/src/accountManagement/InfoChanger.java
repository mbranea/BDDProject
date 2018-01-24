package accountManagement;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import CurrentClient.CurrentAccount;
import accountCreation.AccountInfo;
import accountCreation.WrongDataEnteredException;

public class InfoChanger {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/client-side";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "1234";
	  
	 
	public static void changeInfo(String nume,String prenume,String telefon,String eMail) throws WrongDataEnteredException, SQLException, ClassNotFoundException, NoSuchAlgorithmException, UnsupportedEncodingException 
	{     CurrentAccount account = CurrentAccount.getInstance();
		  int id = account.getId();
		
		
		AccountInfo validationInfo = new AccountInfo();
		validationInfo.initialiseAccountInfoObject("validationUser", "validationPassword", eMail, nume, prenume, telefon);
		
		
		   
		   Connection conn = null;
		   PreparedStatement stmt = null;
		
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);

		      //STEP 4: Execute a query
		      System.out.println("Creating statement...");
		    
		      String sql1;
		      sql1 = "UPDATE client_info\r\n" + 
		      		"		SET Nume = ?, Prenume = ?, EMail = ?, Telefon = ? WHERE id_client = ?;" ;
		      
		      stmt = conn.prepareStatement(sql1);
		      
		      stmt.setString(1, nume);
		      
		      stmt.setString(2, prenume);
		      
		      stmt.setString(3, eMail);
		      
		      stmt.setString(4, telefon);
		      
		      stmt.setInt(5, id);
		      
		     stmt.executeUpdate();
		      
		     
		      stmt.close();
		      conn.close();
		   
		   System.out.println("Goodbye!");
		   
		
	}
	
	
}
