package Authentication;

import java.util.Scanner;

import Person.Person;

public class FingerPrintStrategy implements LoginStrategy {

	@Override
	public boolean runStrategy(Person person) {
		{
			boolean authenticated = false; 
			String fingerPrint = getFingerPrint();
			if(fingerPrint.equals("y")) authenticated = true; 
			else if(fingerPrint.equals("n")) {
				authenticated = false; 
			}
			else 
			{
				this.runStrategy(person);
			}
			return authenticated;
		}}
		
	public String getFingerPrint()
		{
			Scanner FingerPrintScan = new Scanner(System.in);
			System.out.println("Is your Finger on the Scanner! Yes(y) No(n)");
			String fingerprint = FingerPrintScan.next();
			
			return fingerprint;
		}
	}
	

