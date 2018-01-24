package validation;

import accountCreation.WrongDataEnteredException;

public class PhoneValidation {
	 public void validate(final String cs) throws WrongDataEnteredException {
	      
	        final int sz = cs.length();
	        if(sz!=10) {throw new WrongDataEnteredException();}
	        for (int i = 0; i < sz; i++) {
	            if (!Character.isDigit(cs.charAt(i))) {
	            	throw new WrongDataEnteredException();
	            }
	        }
	      
	    }
}
