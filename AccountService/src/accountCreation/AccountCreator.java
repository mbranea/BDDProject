package accountCreation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class AccountCreator {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/client-side";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "1234";
	   
	   
	  
	   
	   public boolean registerAccount(AccountInfo info) throws ClassNotFoundException, SQLException 
	   {
		   
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
	      sql1 = "INSERT INTO client_info (Nume, Prenume, EMail, Telefon)\r\n" + 
	      		"VALUES (?,?,?,?)";
	      stmt = conn.prepareStatement(sql1);
	      stmt.setString(1, info.getNume());
	      stmt.setString(2, info.getPrenume());
	      stmt.setString(3, info.getEmail());
	      stmt.setString(4, info.getTelefon());
	      stmt.executeUpdate();
	      String sql2;
	      sql2 = "INSERT INTO cont_client (username, password,client_id)\r\n VALUES (?,?,(SELECT id_client FROM client_info ORDER BY id_client DESC LIMIT 1))";
	     
	      stmt = conn.prepareStatement(sql2);
	      stmt.setString(1, info.getUsername());
	      stmt.setString(2, info.getPassword());
	      stmt.executeUpdate();
	      
	     
	      stmt.close();
	      conn.close();
	   
	   System.out.println("Goodbye!");
	   return true;

}}
