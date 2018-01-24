package employeeLogin;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;


import CurrentEmployee.CurrentEmployeeUpdater;
import accountCreation.WrongDataEnteredException;
import employeeValidation.SQLValidation;
import validation.EmptyValidation;

public class EmployeeLogin {

	public String verifyLogin(String username,String password) throws WrongDataEnteredException, NoSuchAlgorithmException, UnsupportedEncodingException  
	{
		EmptyValidation emptyValidation = new EmptyValidation();
		SQLValidation sqlValidation = new SQLValidation();
		if(emptyValidation.validate(username)||emptyValidation.validate(password)) 
		{
			if(sqlValidation.validateEmployee(username,password))
			{
				
				CurrentEmployeeUpdater.updateClient(username);
				
				return "Login Successfull";
				
			}else {return "Password does not match username";}
			
		}else {return "Write both username and password";}
	}
	
}
