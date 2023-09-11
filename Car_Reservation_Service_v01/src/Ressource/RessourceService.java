package Ressource;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        System.out.println("Choose your car: ");
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
        System.out.println("How long do you want to rent this car? Please enter number of days.");
        int duration = scanner.nextInt();
        car.setDuration(duration);
        System.out.println("When do you want to rent your car? Please use format YYYY-MM-DD.");
        String startDayString = scanner.next();
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDay;
        try {
            startDay = dateFormat.parse(startDayString);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use yyyy-MM-dd.");
            return chooseCarType();
        }
        // Set the start date in car
        car.setStartDay(startDay);
        
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
