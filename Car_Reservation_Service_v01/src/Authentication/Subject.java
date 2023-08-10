package Authentication;

import java.util.Scanner;

public abstract class Subject {

	public void authenticateSubject() {
		// get ID for the natural user and verify authentication
		// save to DB
	}

	public boolean retry() {
		boolean retry = false;
		String again = getRetryOrExit();
		if (again.equals("r"))
			retry = true;
		else if (again.equals("e"))
			retry = false;
		else
			this.retry();
		return retry;
	}

	// Scanner to get ID and Retry-Command from CLI, get CredentialType (type for method of authentication)
	public int getId() {
		Scanner idScan = new Scanner(System.in);
		System.out.println("Enter ID: ");
		int id = idScan.nextInt();

		return id;
	}

	public String getRetryOrExit() {
		Scanner retryOrExitScan = new Scanner(System.in);
		System.out.println("Invalid ID. Retry (r) or Exit (e)");
		String retryOrExit = retryOrExitScan.next();
		return retryOrExit;
	}

	public int getCredentialType()
	{
		Scanner CredentialTypeScan = new Scanner(System.in);
		System.out.println("Choose One of the listed Autehtication Choices" + "\n" 
		+ "Username with Password: 1" + "\n" 
		+ "Fingerprint: 2" + "\n" 
		+ "Eyescanner: 3" + "\n" 
		+ "Go back to MainMenu: 4");
		int credential = CredentialTypeScan.nextInt();
		
		return credential;
	}
}
