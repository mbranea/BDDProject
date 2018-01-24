package cardManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import CurrentClient.CurrentAccount;

public class CardDeleter {

	 // JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:postgresql://192.168.0.104:5432/internal_database";

	   //  Database credentials
	   static final String USER = "postgres";
	   static final String PASS = "root";
	public static void deleteCard(int nr) 
	{

		CurrentAccount account = CurrentAccount.getInstance();
		int id = account.getId();
		
	
		   Connection conn = null;
		   PreparedStatement stmt = null;
		   try{
		      //STEP 2: Register JDBC driver
			   Class.forName("org.postgresql.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);

		      //STEP 4: Execute a query
		      System.out.println("Creating statement...");
		      
		      String sql;
		      sql = "DELETE FROM internal_schema.info_card WHERE id_card = ? AND id_client = ?;";
		      stmt = conn.prepareStatement(sql);
		      stmt.setInt(1, nr);
		      stmt.setInt(2, id);
		     
		      stmt.executeUpdate();
		     

		      //STEP 5: Extract data from result set
		      
		      //STEP 6: Clean-up environment
		      
		      stmt.close();
		      conn.close();
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		      }// nothing we can do
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		   System.out.println("Goodbye!");
		}//end main
		//end FirstExample
	}