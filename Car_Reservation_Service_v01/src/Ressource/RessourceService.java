package Ressource;

import java.util.Scanner;

public class RessourceService {

    private Ressource car;

    public Ressource getSelectedRessource() {
        car = chooseCarType();
        car = chooseChildSeat(car);
        car = chooseSetTopBox(car);
        car = chooseGPS(car);
        car = chooseWifi(car);
        
        System.out.println(car.getDescription());
        return car;
    }


    private Ressource chooseCarType() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Car Choice");
        System.out.println("1. VW Bus");
        System.out.println("2. Smart");
        System.out.println("3. Suv");
        int choice = scanner.nextInt();

        Ressource car;
        switch(choice) {
            case 1: 
                car = new Car("VW Bus", "LG XX 45", "white", 70.0);
                break;
            case 2: 
                car = new Car("Smart", "LG XX 46", "red", 80.0);
                break;
            case 3:
                car = new Car("Suv", "LG XX 47", "black", 90.0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                car = chooseCarType();
        }
        return car;
    }

    private Ressource chooseChildSeat(Ressource car) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Childseat Yes(Y) or No(N): ");
        String choice = scanner.next();
        if (choice.equalsIgnoreCase("Y")) {
            car = new ChildSeatDecorator(car);
        }
        return car;
    }

    private Ressource chooseSetTopBox(Ressource car) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("TopBox Yes(Y) or No(N): ");
        String choice = scanner.next();
        if (choice.equalsIgnoreCase("Y")) {
            car = new SetTopBoxDecorator(car);
        }
        return car;
    }
    private Ressource chooseGPS(Ressource car) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("GPS Yes(Y) or No(N): ");
        String choice = scanner.next();
        if (choice.equalsIgnoreCase("Y")) {
            car = new GPSDecorator(car);
        }
        return car;
    }

    private Ressource chooseWifi(Ressource car) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wifi Yes(Y) or No(N): ");
        String choice = scanner.next();
        if (choice.equalsIgnoreCase("Y")) {
            car = new WifiDecorator(car);
        }
        return car;
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
