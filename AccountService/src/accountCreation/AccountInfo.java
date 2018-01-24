package accountCreation;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import validation.EMailValidation;
import validation.EmptyValidation;
import validation.NoNumbersValidation;
import validation.PhoneValidation;

public class AccountInfo {

	private String username;
	private String password;
	private String email;
	private String Nume;
	private String Prenume;
	private String telefon;
	
	
	
	
	public  void initialiseAccountInfoObject(String username, String password, String email, String nume, String prenume, String telefon) throws WrongDataEnteredException, NoSuchAlgorithmException, UnsupportedEncodingException {
		EmptyValidation emptyValidation = new EmptyValidation();
		EMailValidation eMailValidation = new EMailValidation();
		NoNumbersValidation noNumberValidation = new NoNumbersValidation();
		PhoneValidation phoneValidation = new PhoneValidation();
		
			emptyValidation.validate(username);
			emptyValidation.validate(password);
			emptyValidation.validate(email);
			emptyValidation.validate(nume);
			emptyValidation.validate(prenume);
			emptyValidation.validate(telefon);
			 noNumberValidation.validate(nume);
			 noNumberValidation.validate(prenume);
			 phoneValidation.validate(telefon);
			 eMailValidation.validate(email);
			
		
		
		
		this.Nume=nume;
		this.Prenume=prenume;
		this.email=email;
		this.telefon=telefon;
		this.username=username;
		this.password=passwordHash(password);
	}

	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNume() {
		return Nume;
	}

	public void setNume(String nume) {
		Nume = nume;
	}

	public String getPrenume() {
		return Prenume;
	}

	public void setPrenume(String prenume) {
		Prenume = prenume;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	
	public static String passwordHash(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException 
	{

		 MessageDigest digest = java.security.MessageDigest.getInstance("SHA-256");
		
		 byte[] bytePassword = password.getBytes(StandardCharsets.UTF_8); 
		    digest.update(bytePassword);
		    byte[] hash = digest.digest();
		    return new String(hash,"UTF-8");
	}
	
}
