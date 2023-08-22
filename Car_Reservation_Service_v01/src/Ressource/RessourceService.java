package Ressource;

import java.util.Scanner;

public class RessourceService {

	private Ressource car;

	public Ressource getSelectedRessource() {		

		int ressourceType = chooseRessourceType();
		
		if (ressourceType == 1) {
			car = new ChildSeatDecorator(new Car());
			System.out.println("You chose a car with child seat.");
		}
		else if (ressourceType == 2) {
			car = new SetTopBoxDecorator(new Car());
			System.out.println("You chose a car with SetTopBox.");
		}
		else if (ressourceType == 3) {
			car = new Car();
			// spring zurück ins Menü
		}
		else {
			System.out.println("Your input is invalid. Please choose 1 for Child Seat, 2 for SetTopBox.");
			getSelectedRessource();
		}
		return car;
	}
		
	public int chooseRessourceType() {
		// TODO childseat und andere Extras nach erster Eingabe auswählen
		Scanner RessourceTypeScan = new Scanner(System.in);
		System.out.println("Choose your extra ressource according to your preferences" + "\n" 
				+ "Child Seat: 1" + "\n" 
				+ "Set Topbox: 2" + "\n" 
				+ "No extras needed. Proceed: 3");
		int ressourceType = RessourceTypeScan.nextInt();
		return ressourceType;
	}
}

//Alternative mit Do-While:
//do {
//    resourceType = chooseResourceType();
//
//    if (resourceType == 1) {
//        car = new ChildSeatDecorator(new Car());
//        System.out.println("You chose a car with a child seat.");
//    } else if (resourceType == 2) {
//        car = new SetTopBoxDecorator(new Car());
//        System.out.println("You chose a car with a SetTopBox.");
//    } else if (resourceType == 3) {
//        System.out.println("Going back to MainMenu.");
//        break;
//    } else {
//        System.out.println("Your input is invalid. Please choose 1 for Child Seat, 2 for SetTopBox.");
//    }
//} while (resourceType != 1 && resourceType != 2 && resourceType != 3);

