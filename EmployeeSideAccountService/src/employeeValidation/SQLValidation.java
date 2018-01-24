package employeeValidation;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import accountCreation.AccountInfo;



public class SQLValidation {
	static final String JDBC_DRIVER = "org.postgresql.Driver";  
	   static final String DB_URL = "jdbc:postgresql://127.168.1.1:5432/internal_database";

	   //  Database credentials
	   static final String USER = "postgres";
	   static final String PASS = "1234";
	
	public boolean validateEmployee(String username,String password) throws NoSuchAlgorithmException, UnsupportedEncodingException  {
		
		   Connection conn = null;
		   PreparedStatement stmt = null;
		
		      //STEP 2: Register JDBC driver
		     
				try {
					Class.forName(JDBC_DRIVER);
				
			

		      //STEP 3: Open a connection
		      System.out.println("Connecting to database...");
		    
				conn = DriverManager.getConnection(DB_URL,USER,PASS);
			

		      //STEP 4: Execute a query
		      System.out.println("Creating statement...");
		    
		      String sql1;
		      sql1 = "SELECT password FROM internal_schema.cont_angajat WHERE(username = ?)";
		  
				stmt = conn.prepareStatement(sql1);
				stmt.setString(1, username);
				ResultSet rs = stmt.executeQuery();
				if(rs.next()) {
				
				String passwordToCheck = rs.getString("password");
				   System.out.println(AccountInfo.passwordHash(password));
				   System.out.println(AccountInfo.passwordHash(passwordToCheck));
				if(passwordToCheck.equals(AccountInfo.passwordHash(password)))
				{
					   System.out.println(AccountInfo.passwordHash(password));
				      stmt.close();
				      conn.close();
				   
				   System.out.println("Goodbye!");

					return true;
				}
				
				}else return false;
				
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
				   
			      try {
					stmt.close();
				
			      conn.close();
			      } catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			   System.out.println("Goodbye!");

		return false;
	}

}
