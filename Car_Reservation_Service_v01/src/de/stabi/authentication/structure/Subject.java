package de.stabi.authentication.structure;

import java.util.Scanner;

import de.stabi.database.DataBase;
import de.stabi.person.structure.Person;

public abstract class Subject {

    protected DataBase dataBase = DataBase.getInstance();
    protected Person person;

    public abstract boolean authenticateSubject();

    public Person getPerson() {
        return this.person;
    }
    public void setPerson(Person person) {
        this.person = person;
    }
    public boolean retry() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.print("Invalid input. Would you like to try again? (y/n): ");System.out.println();
        String response = scanner.nextLine();
        return response.equalsIgnoreCase("y");
    }



    public boolean authenticate() {
        Scanner scanner = new Scanner(System.in);
        
        while(true) {
            printSectionHeader("Login");
            
            System.out.println("Please select the type of person:");
            System.out.println("(n) Natural Person");
            System.out.println("(l) Legal Person");
            System.out.print("> ");
            String personType = scanner.nextLine().trim().toLowerCase();

            if (!personType.equals("n") && !personType.equals("l")) {
                System.out.println("[Error] Invalid input. Please enter 'n' for natural person or 'l' for legal person.");
                continue;
            }

            if ("n".equalsIgnoreCase(personType)) {
                printSectionHeader("Natural Person");
            } else {
                printSectionHeader("Legal Person");
            }
            
            System.out.print("Please enter your ID: \n> ");
            String id = scanner.nextLine();

            if ("n".equalsIgnoreCase(personType)) {
                id = "N" + id;
            } else if ("l".equalsIgnoreCase(personType)) {
                id = "L" + id;
            } else {
            	System.out.println();
                System.out.println("Invalid person type. Please retry.");System.out.println();
                if(!retry()) {
                    return false;
                }
                continue;
            }

            Person person = dataBase.getPersonById(id, personType);
            if (person == null) {
                System.out.println("[Error] No person found with this ID. Please try again.");
                continue;
            } 

            // Überprüfen Sie den eingegebenen Personentyp und führen Sie die entsprechende Authentifizierung durch
            Subject subject;
            if ("n".equalsIgnoreCase(personType)) {
                subject = new NaturalUser();
            } else if ("l".equalsIgnoreCase(personType)) {
                subject = new SoftwareSystem();
            } else {
            	System.out.println();System.out.println("=====================");
                System.out.println("Invalid person type. Please retry.");System.out.println();
                if(!retry()) {
                    return false;
                }
                continue;
            }

            subject.setPerson(person);
            boolean success = subject.authenticateSubject();
            if(success) {
                System.out.println("[Success] Authentication successful! Welcome back.");
                return true;
            } else {
                System.out.println("[Error] Authentication failed. Please try again.");
            }
        }
    }
    private void printSectionHeader(String headerText) {
        System.out.println("\n=================");
        System.out.println("  " + headerText);
        System.out.println("=================");
    }

}