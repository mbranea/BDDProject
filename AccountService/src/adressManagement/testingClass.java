package adressManagement;

import java.sql.SQLException;

public class testingClass {

public static void main(String args[]) throws ClassNotFoundException, SQLException 
{
	AdressInfo info = new AdressInfo("MyAdress2", 2, 11, 3, "Home",1);
	 AdressCreator creator = new AdressCreator();
	creator.getAdressesById(11);
	}
}
