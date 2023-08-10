package Ressource;

import java.util.Scanner;

public class ResourceService {
	
	public int getSelectedResource() {
		
		try (Scanner RessourceScan = new Scanner(System.in)) {
			System.out.println("Choose your ressource according to your preferences" + "\n" 
			+ "Car: 1" + "\n" 
			+ "Child Seat: 2" + "\n" 
			+ "Set Topbox: 3" + "\n" 
			+ "Go back to MainMenu: 4");
			int ressourceType = RessourceScan.nextInt();
			
			return ressourceType;
		}
	}

}
