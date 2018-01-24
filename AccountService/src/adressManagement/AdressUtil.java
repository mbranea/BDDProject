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
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Vector;

public class AdressUtil {
	private final static HashMap<String,Integer> idCityMap ;
	static
    {
		idCityMap = new HashMap<String,Integer>();
		idCityMap.put("Brasov",1);
		idCityMap.put("Cluj",2 );
		idCityMap.put("Deva",3 );			
    }
	public static HashMap<String, Integer> getIdCityMap() {
		return idCityMap;
	}
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/client-side";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "1234";
	
	public static HashMap<Integer,String> areasFromCity(int cityCode) throws SQLException, ClassNotFoundException 
	{
		HashMap<Integer,String> map = new HashMap<Integer,String>();
		 
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
		      sql1 = "SELECT id_cartier,nume FROM cartiere WHERE id_oras = ?";
		      		
		      stmt = conn.prepareStatement(sql1);
		      stmt.setInt(1, cityCode);
		      
		     ResultSet results = stmt.executeQuery();
		     List<Integer> ids = new ArrayList<Integer>();
		     List<String> names = new ArrayList<String>();
		     while(results.next()) {
		     ids.add(results.getInt("id_cartier"));
		     names.add(results.getString("nume"));
		     }
		   
		    
		     
		     for(int i=0;i<=ids.size()-1;i++) 
		     {
		    	 map.put(ids.get(i), names.get(i));
		     }
		     
		      stmt.close();
		      conn.close();
		   
		   System.out.println("Goodbye!");
		   return map;
	}   
	
	public static Integer getIntegerKeyFromValue(HashMap<Integer,String> map,String value) 
	{
		for(int key : map.keySet())
		{
			if(map.get(key).equals(value))
			{
				return key;
			}
		}
		return null;
	}
	public static String getStringKeyFromValue(HashMap<String,Integer> map,int value) 
	{
		for(String key : map.keySet())
		{
			
				if(map.get(key).equals(value))
				{
					return  key;
				}
			
		}
		return null;
	}

	public static List<Vector<Object>> convertVector(List<Vector<Object>> adressesById) throws ClassNotFoundException, SQLException {
		List<Vector<Object>> newList = new ArrayList<Vector<Object>>();
		for(Vector vector:adressesById)
		{
			
			Vector<Object> newVector= new Vector<>();
			newVector.add(vector.get(3));
			newVector.add(vector.get(1)); 
			newVector.add(AdressUtil.getStringKeyFromValue(AdressUtil.getIdCityMap(),(int)vector.get(4))); 
			newVector.add(areasFromCity((int)vector.get(4)).get(vector.get(0)));
			newVector.add(vector.get(2));
		
			newList.add(newVector);
			
		}
		return newList;
	}
	
}
