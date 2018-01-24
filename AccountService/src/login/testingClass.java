package login;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import CurrentClient.CurrentAccount;
import accountCreation.AccountInfo;
import accountCreation.WrongDataEnteredException;

public class testingClass {

	public static void main(String args[]) throws NoSuchAlgorithmException, UnsupportedEncodingException {
	
	
	AccountLogin accountLogin = new AccountLogin();
	try {
		System.out.println(accountLogin.verifyLogin("steve1","stevepass"));
	} catch (WrongDataEnteredException e) {
		System.out.println("Empty Login attempted");
	}
	 
	System.out.println("Current Logged In");
	System.out.println(CurrentAccount.getInstance().toString());
	}
}
