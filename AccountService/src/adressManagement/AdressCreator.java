package adressManagement;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;



public class AdressCreator {
	public AdressCreator() {}
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/client-side";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "1234";
	   
	   
	  
	   
	   public boolean registerAdress(AdressInfo info) throws ClassNotFoundException, SQLException 
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
	      sql1 = "INSERT INTO adrese_inregistrate (id_cartier, id_client, nume_adresa, nr_strada, tip_adresa, id_oras)\r\n" + 
	      		"VALUES (?,?,?,?,?,?)";
	      stmt = conn.prepareStatement(sql1);
	      stmt.setInt(1, info.getArea_id());
	      stmt.setInt(2, info.getClient_id());
	      stmt.setString(3, info.getName());
	      stmt.setInt(4, info.getStreet_nr());
	      stmt.setString(5, info.getAdress_type());
	      stmt.setInt(6, info.getCityId());
	     
	      stmt.executeUpdate();
	      
	      
	     
	      stmt.close();
	      conn.close();
	   
	   System.out.println("Goodbye!");
	   return true;

}
	
	   public static List<Vector<Object>> getAdressesById(int client_id) throws ClassNotFoundException, SQLException 
	   {
		   List<Vector<Object>> list = new ArrayList<Vector<Object>>();
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
	      sql1 = "SELECT id_cartier, nume_adresa, nr_strada, tip_adresa, id_oras FROM adrese_inregistrate WHERE id_client = ?"
	      		;
	      stmt = conn.prepareStatement(sql1);
	      stmt.setInt(1, client_id);
	      
	      ResultSet rs = stmt.executeQuery();
	      while(rs.next()) {
	    	  Vector<Object> vector = new Vector<>();
	    	  vector.add(rs.getInt("id_cartier"));
	    	  vector.add(rs.getString("nume_adresa"));
	    	  vector.add(rs.getInt("nr_strada"));
	    	  vector.add(rs.getString("tip_adresa"));
	    	  vector.add(rs.getInt("id_oras"));
	    	  list.add(vector);
	    	  
	      }
	      
	      
	      
	     
	      stmt.close();
	      conn.close();
	   
	   System.out.println("Goodbye!");
	   return list;

}
	
}


