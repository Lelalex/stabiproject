package Authentication;

import java.util.Scanner;

import Person.Person;

public class EyeScanStrategy implements LoginStrategy {
    @Override
    public boolean runStrategy(Person person) {
		{
			boolean authenticated = false; 
			String eyeScan = getEyeScan();
			if(eyeScan.equals("y")) authenticated = true; 
			else if(eyeScan.equals("n")) {
				authenticated = false; 
			}
			else 
			{
				this.runStrategy(person);
			}
			return authenticated;
		}}
		
	public String getEyeScan()
		{
			Scanner EyeScanScan = new Scanner(System.in);
			System.out.println("Is your Eye on the Scanner! Yes(y) No(n)");
			String eyeScan = EyeScanScan.next();
			
			return eyeScan;
		}
	}
	

