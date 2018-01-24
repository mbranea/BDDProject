package validation;



import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import accountCreation.WrongDataEnteredException;

public class EMailValidation {
	
	public boolean validate(String eMail) throws WrongDataEnteredException 
	{ try {
		InternetAddress emailAddr = new InternetAddress(eMail);
	   
			emailAddr.validate();
		} catch (AddressException e) {
			throw new WrongDataEnteredException();
		}
	    return true;
		
	}

}
