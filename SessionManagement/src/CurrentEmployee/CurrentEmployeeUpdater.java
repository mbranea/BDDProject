package CurrentEmployee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class CurrentEmployeeUpdater {


	static final String JDBC_DRIVER = "org.postgresql.Driver";  
	   static final String DB_URL = "jdbc:postgresql://127.168.1.1:5432/internal_database";

	   //  Database credentials
	   static final String USER = "postgres";
	   static final String PASS = "1234";
	   
	   
	   
	   
	   
	   public static void updateClient(String username)
	   {CurrentEmployee account = CurrentEmployee.getInstance();
		   if(username.equals("logout"))
	   {
		   account.initialiseCurrentEmployee(0, "");
		   
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
		      sql = "SELECT id_angajat  FROM internal_schema.cont_angajat WHERE(username = ?)";
		  
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, username);
				ResultSet rs = stmt.executeQuery();
				if(rs.next()) {
				
				int id_client = rs.getInt("id_angajat");
				
				
					account.initialiseCurrentEmployee(id_client, username);
				
				
				
				
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
