package Authentication;

import java.util.Scanner;

import Person.Person;

public class FingerPrintStrategy implements LoginStrategy {
    @Override
    public boolean runStrategy(Person person) {
        boolean authenticated = false; 
        while(true) {
            String fingerPrint = getFingerPrint();
            if(fingerPrint.equals("y")) {
                authenticated = true;
                break; 
            } else if(fingerPrint.equals("n")) {
                authenticated = false;
                break; 
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }
        return authenticated;
    }

    public String getFingerPrint() {
        Scanner FingerPrintScan = new Scanner(System.in);
        System.out.println("Is your Finger on the Scanner! Yes(y) No(n)");
        return FingerPrintScan.next();
    }
}



