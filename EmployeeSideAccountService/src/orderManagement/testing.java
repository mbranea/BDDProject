package orderManagement;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class testing {

	public static void main(String args[]) throws ClassNotFoundException, NoSuchAlgorithmException, UnsupportedEncodingException, SQLException
	{
		(new OrderGetter()).registerAccount(null);
	}
	
}
