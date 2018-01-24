package validation;

import accountCreation.WrongDataEnteredException;

public class NoNumbersValidation {

    public void validate(final String cs) throws WrongDataEnteredException {
      
        final int sz = cs.length();
        for (int i = 0; i < sz; i++) {
            if (Character.isDigit(cs.charAt(i))) {
            	throw new WrongDataEnteredException();
            }
        }
      
    }
	
	
}
