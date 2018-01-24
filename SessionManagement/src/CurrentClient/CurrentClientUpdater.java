package CurrentClient;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CurrentClientUpdater {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/client-side";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "1234";
	   
	   public static void updateClient(String username)
	   {CurrentAccount account = CurrentAccount.getInstance();
		   if(username.equals("logout"))
	   {
		   account.initialiseCurrentAccount(0, "", "", "", "", "");
		   
	   }else {
		   
		   Connection conn = null;
		   PreparedStatement stmt = null;
		
		      //STEP 2: Register JDBC driver
		     
				try {
					Class.forName("com.mysql.jdbc.Driver");
				
			

		      //STEP 3: Open a connection
		      System.out.println("Connecting to database...");
		    
				conn = DriverManager.getConnection(DB_URL,USER,PASS);
			

		      //STEP 4: Execute a query
		      System.out.println("Creating statement...");
		    
		      String sql;
		      sql = "SELECT client_id  FROM cont_client WHERE(username = ?)";
		  
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, username);
				ResultSet rs = stmt.executeQuery();
				if(rs.next()) {
				
				int id_client = rs.getInt("client_id");
				
				sql = "SELECT Nume, Prenume,Email,Telefon FROM client_info WHERE(id_client = ?)";
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, id_client);
				ResultSet rs2 = stmt.executeQuery();
				if(rs2.next()) 
				{
					String nume = rs2.getString("Nume");
					String prenume = rs2.getString("Prenume");
					String email = rs2.getString("Email");
					String telefon = rs2.getString("Telefon");
					account.initialiseCurrentAccount(id_client, username, email, nume, prenume, telefon);
				}
				
				
				
				}
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
	   }
	   }
	   
	
}
