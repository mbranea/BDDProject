package accountCreation;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class testingClass {

	
	public static void main(String args[]) throws ClassNotFoundException, SQLException, WrongDataEnteredException, NoSuchAlgorithmException, UnsupportedEncodingException 
	{
		AccountInfo info = new AccountInfo();
		info.initialiseAccountInfoObject("steve1", "stevepass", "steve@gmail.com", "Steve", "Steve", "1234567890");
				
		
		AccountCreator creator = new AccountCreator();
	//	creator.registerAccount(info);
		System.out.println(AccountInfo.passwordHash("employeepass"));
	}
	
}
