package login;

import CurrentClient.CurrentClientUpdater;

public class AccountLogout {

	public static void logout()
	{
		 
		 CurrentClientUpdater.updateClient("logout");
	}
	
	
}
