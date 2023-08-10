package Authentication;

import Person.Person;
import java.util.Scanner;

public class NaturalUser extends Subject {
	private boolean authenticationPossible;
	private AuthenticationService authenticationservice;
	private PasswordStrategy password = new PasswordStrategy();
	private FingerPrintStrategy fingerprint = new FingerPrintStrategy();
	private EyeScanStrategy eyescan = new EyeScanStrategy();
	public boolean isAuthenticationPossible() {
        return authenticationPossible;
    }

    public void setAuthenticationPossible(boolean authenticationPossible) {
        this.authenticationPossible = authenticationPossible;
    }
    
	@Override
	public void authenticateSubject() {
		
		
	}
	
	public void checkID () {
		//check Input PersonID via COnsole and check for not null
		//set boolean true/false after check of Person ID
		
		Person person = db.getPerson(id);
		if (person != null) 
			//&& person.getClass().equals(person.getClass()))
		{
			authenticationPossible = true; 
			return;}
		else {
			if (this.retry()) 
			{
				this.authenticateSubject();
				return;
			} 
			else
				authenticationPossible = false;
				return;} 
	}
	public int getCredentialType()
    {
        Scanner CredentialTypeScan = new Scanner(System.in);
        System.out.println("Choose One of the listed Authentication Choices" + "\n" 
        + "Username with Password: 1" + "\n" 
        + "Fingerprint: 2" + "\n" 
        + "Eyescanner: 3" + "\n" 
        + "Go back to MainMenu: 4");
        int credentialType = CredentialTypeScan.nextInt();

        return credentialType;
    }	
		
	public void executeCredentialType(Person person)
	//switch case to get number 1 to 4 from CLI by Scanner
	
	{		
		int credentialType = getCredentialType(); 
		
		switch (credentialType){
		
		case 1: 
		
			if(password.runStrategy(person))
//				if(PasswordStrategy)
			{
			authenticationservice.setAuthenticated(true);
			//notification.getSuccessNotification();
			}
			else 	
			{
				System.out.println("Username or password is wrong!");
				executeCredentialType(person);
				return; 
			}
			break; 
		case 2: 
		{
		if(fingerprint.runStrategy(person))
		{
			authenticationservice.setAuthenticated(true);
//			AuthenticateService.class.
		
		}
		else
			{
				System.out.println("Invalid Fingerprint.");
				executeCredentialType(person);
				return;
			} 
			break;
			
		}
		case 3: {
			if(eyescan.runStrategy(person)) 
			{
				authenticationservice.setAuthenticated(true);
				
			}
			else 
			{
			 System.out.println("Ivalid Eyescan.");
			 executeCredentialType(person);
			 return;
			}
			break; 
		}
		case 4: 
			authenticationservice.setAuthenticated(false);
			break; 
		default: 
		{
			System.out.println("Invalid input. Please choose again."); 
			this.authenticateSubject();
		}
		}
	
	}

}
