package accountManagement;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import CurrentClient.CurrentAccount;
import CurrentClient.CurrentClientUpdater;
import accountCreation.WrongDataEnteredException;
import login.AccountLogin;

public class testingClass {


public static void main(String args[]) throws ClassNotFoundException, WrongDataEnteredException, SQLException, NoSuchAlgorithmException, UnsupportedEncodingException 
{
	AccountLogin accountLogin = new AccountLogin();
	
		System.out.println(accountLogin.verifyLogin("steve1","stevepass"));
	System.out.println("Current Logged In");
	System.out.println(CurrentAccount.getInstance().toString());
	
	
	
	InfoChanger.changeInfo("Stevedoi", "Stevedoi", "1234567890", "steve@gmail.com");
	CurrentClientUpdater.updateClient(CurrentAccount.getInstance().getUsername());
	System.out.println("Current Logged In");
	System.out.println(CurrentAccount.getInstance().toString());
	
	
	
}

}
