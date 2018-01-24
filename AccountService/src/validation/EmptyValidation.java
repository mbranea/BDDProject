package validation;


import accountCreation.WrongDataEnteredException;




public class EmptyValidation {

	  
		public boolean validate(String input) throws WrongDataEnteredException {
		    
		    {
			if(input==null||input.equals("")) {
				throw new WrongDataEnteredException();
			}
			return true;
		   
		}
	   }
		}
	   
	
	
	

   
