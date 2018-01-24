package cardManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import CurrentClient.CurrentAccount;

public class CardAdder {
	 // JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:postgresql://127.168.1.1:5432/internal_database";

	   //  Database credentials
	   static final String USER = "postgres";
	   static final String PASS = "1234";
	public void addCard(String nr,String expirationDate) throws SQLException 
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
		      sql = "INSERT INTO internal_schema.info_card (id_client,nr_card,expiration_date) VALUES (?,?,?);";
		      stmt = conn.prepareStatement(sql);
		      stmt.setInt(1, id);
		      stmt.setString(2, nr);
		      stmt.setString(3,  expirationDate);
		      stmt.executeUpdate();
		     

		      //STEP 5: Extract data from result set
		      
		      //STEP 6: Clean-up environment
		      
		      stmt.close();
		      conn.close();
		   }catch(SQLException se){
		      //Handle errors for JDBC
		     throw new SQLException();
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
		
	public static String[] getCardNumbers() throws SQLException, ClassNotFoundException
	{
		int id = CurrentAccount.getInstance().getId();
	
	   List<String> list = new ArrayList<String>();
	   Connection conn = null;
	   PreparedStatement stmt = null;
	
	      //STEP 2: Register JDBC driver
	      Class.forName("org.postgresql.Driver");

	      //STEP 3: Open a connection
	      System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);

	      //STEP 4: Execute a query
	      System.out.println("Creating statement...");
	    
	      String sql1;
	      sql1 = "SELECT nr_card FROM  internal_schema.info_card WHERE id_client = ?"
	      		;
	      stmt = conn.prepareStatement(sql1);
	      stmt.setInt(1, id);
	      
	      ResultSet rs = stmt.executeQuery();
	     while(rs.next())
	     {
	    	 list.add(rs.getString("nr_card"));
	     }
	      
	      
	      
	     
	      stmt.close();
	      conn.close();
	   
	   System.out.println("Goodbye!");
	   return list.toArray(new String[list.size()]);
	//end FirstExample
	}
}



	
	

