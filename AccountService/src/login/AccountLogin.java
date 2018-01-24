package login;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import CurrentClient.CurrentClientUpdater;
import accountCreation.WrongDataEnteredException;
import validation.EmptyValidation;
import validation.SQLValidation;

public class AccountLogin {

	public String verifyLogin(String username,String password) throws WrongDataEnteredException, NoSuchAlgorithmException, UnsupportedEncodingException  
	{
		EmptyValidation emptyValidation = new EmptyValidation();
		SQLValidation sqlValidation = new SQLValidation();
		if(emptyValidation.validate(username)||emptyValidation.validate(username)) 
		{
			if(sqlValidation.validate(username,password))
			{
				
				CurrentClientUpdater.updateClient(username);
				
				return "Login Successfull";
				
			}else {return "Password does not match username";}
			
		}else {return "Write both username and password";}
	}
	
}
