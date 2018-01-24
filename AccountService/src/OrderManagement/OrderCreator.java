package OrderManagement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import CurrentClient.CurrentAccount;
import accountCreation.AccountInfo;

public class OrderCreator {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/client-side";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "1234";
	   
	   
	  
	   
	   public boolean registerOrder(OrderInfo info) throws ClassNotFoundException, SQLException 
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
	      sql1 = "INSERT INTO comanda (id_client, id_angajat, start_time,start_loc,end_time,end_loc,distance,payment)\r\n" + 
	      		"VALUES (?,?,?,?,?,?,?,?)";
	      stmt = conn.prepareStatement(sql1);
	     
	      stmt.setInt(1,  CurrentAccount.getInstance().getId());
	      stmt.setInt(2, info.getEmployee_id());
	      stmt.setString(3, info.getStart_time());
	      stmt.setString(5, info.getEnd_time());
	      stmt.setInt(4, info.getStart_loc());
	      stmt.setInt(6, info.getEnd_loc());
	      stmt.setInt(7, info.getDistance());
	      stmt.setInt(8, info.getPayment());
	      stmt.executeUpdate();
	      
	      
	     
	      stmt.close();
	      conn.close();
	   
	   System.out.println("Goodbye!");
	   return true;

}
	   public boolean updateOrderEmplyee(OrderInfo info,int order_id) throws SQLException, ClassNotFoundException 
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
		      sql1 = "UPDATE comanda\r\n" + 
			      		"		SET end_time = ?, end_loc = ?, distance = ?, payment = ? WHERE id_comanda = ?;" ;
		     
		      stmt = conn.prepareStatement(sql1);
		     
		    
		      
		      stmt.setInt(5, order_id);
		      stmt.setString(1, info.getEnd_time());
		      
		      stmt.setInt(2, info.getEnd_loc());
		      stmt.setInt(3, info.getDistance());
		      stmt.setInt(4, info.getPayment());
		      stmt.executeUpdate();
		      
		      
		     
		      stmt.close();
		      conn.close();
		   
		   System.out.println("Goodbye!");
		return true;

	   }
}
