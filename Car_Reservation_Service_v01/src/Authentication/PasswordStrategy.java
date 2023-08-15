package Authentication;

import java.util.Scanner;

import Person.Person;

public class PasswordStrategy implements LoginStrategy {

	@Override
	public boolean runStrategy(Person person) {
		{
			boolean authenticated = false; 
			String password = getPassword();
			String userName = getUserName();
			if(userName != null && password != null) {
				authenticated = true; 
			}
			else {
				authenticated = false; 
				}
				
//			else 
//			{
//				this.runStrategy(person);
//			}
			return authenticated;
		}
			}
		
	private String getUserName() {
		System.out.println("Enter username");
		Scanner UserNameScan = new Scanner(System.in);
		String userName = UserNameScan.next();
		
		return userName;
	}
	private String getPassword() {
		System.out.println("Enter password");
		Scanner PasswordScan = new Scanner(System.in);
		String password = PasswordScan.next();
		
		return password;
	}
	
	}

////Abfrage von Username und Password
//@Override
//public boolean runStrategy(Person person) 
//{
////Person person = person;
//boolean authenticated = false; 
//
//if(dataView.getUserName().equals(person.getUserName()) && dataView.getPassword().equals(person.getPassword())) 
//	authenticated = true; 
//	return authenticated; 

