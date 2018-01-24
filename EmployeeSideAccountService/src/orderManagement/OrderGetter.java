package orderManagement;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import CurrentClient.CurrentAccount;
import CurrentEmployee.CurrentEmployee;
import OrderManagement.OrderInfo;
import accountCreation.AccountInfo;

public class OrderGetter {
	
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/client-side";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "1234";
	   
	   public boolean registerAccount(AccountInfo info) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException, UnsupportedEncodingException 
	   {
		   
	   Connection conn = null;
	   PreparedStatement stmt = null;
	
	      //STEP 2: Register JDBC driver
	      Class.forName("org.postgresql.Driver");

	      //STEP 3: Open a connection
	      System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection("jdbc:postgresql://127.168.1.1:5432/internal_database","postgres","1234");

	      //STEP 4: Execute a query
	      System.out.println("Creating statement...");
	    
	      String sql2;
	      sql2 = "INSERT INTO internal_schema.cont_angajat (username, password,id_angajat)\r\n VALUES (?,?,?)";
	     
	      stmt = conn.prepareStatement(sql2);
	      stmt.setString(1, "employeeUser");
	      stmt.setString(2, AccountInfo.passwordHash("employeepass"));
	      stmt.setInt(3, 2);
	      stmt.executeUpdate();
	      
	     
	      stmt.close();
	      conn.close();
	   
	   System.out.println("Goodbye!");
	   return true;

}

	   public List<Vector<Object>> getOrders() throws ClassNotFoundException, SQLException 
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
	      sql1 = "SELECT cartiere.nume,comanda.start_time,comanda.end_time FROM cartiere INNER JOIN comanda ON comanda.start_loc=cartiere.id_cartier WHERE comanda.id_angajat = ?";
	      stmt = conn.prepareStatement(sql1);
	     
	      stmt.setInt(1,  CurrentEmployee.getInstance().getId());
	      
	     
	      ResultSet rs =  stmt.executeQuery();
	      while(rs.next()) {
	    	  Vector<Object> vector = new Vector<>();
	    	  vector.add(rs.getString("nume"));
	    	  vector.add(rs.getString("start_time"));
	    	  
	    	  list.add(vector);
	    	  
	      }
	     
	      stmt.close();
	      conn.close();
	   
	   System.out.println("Goodbye!");
	   return list;

}
}
