package Booking;

import java.util.Scanner;

import Person.Person;
import Ressource.Car;

public class BookingService {
	public int bookingLanguage = chooseBookingLanguage();
	
//    public void createBooking() {
//        BookingBuilder bookingBuilder;
//    	Booking booking;
//    	
//		Person person;
//		Car car;
//		int duration;
//		String startDay;
        
        public void createBooking() {
            BookingBuilder bookingBuilder = null; // Hier initialisieren bookingBuilder
            Person person = null;                // Hier initialisieren person
            Car car = null;                      // Hier initialisieren car
            String startDay = null;              // Hier initialisieren startDay
            int duration = 0;  
            
        int bookingLanguage = chooseBookingLanguage();    
        switch(bookingLanguage) {
        case 1:
//        	bookingBuilder = new GermanBookingBuilder ();
        	GermanBookingBuilder germanBuilder = new GermanBookingBuilder(person, car, duration, startDay);

        	break;
        case 2: 

//        	bookingBuilder = new EnglishBookingBuilder ();
        	EnglishBookingBuilder englishBuilder = new EnglishBookingBuilder(person, car, duration, startDay);

        	break;
    	default:
    		System.out.println("Invalid Entry. Wählen Sie zur Buchung 1 für Deutsch / Choose 2 to book in English.");
    		return;
		}
        
      
            
			
			
//        GermanBookingBuilder() brauch noch einen Konstruktor oder BookingBuilder Konstruktor muss geändert werden
//        Body, Head, Footer Klassen auf Vollständigkeit überprüfen


        
//        Booking germanBooking = bookingBuilder.setHead("Kopf")
//                                       .setBody("Körper")
//                                       .setFooter("Fußzeile")
//                                       .buildGermanBooking();
//
//        Booking englishBooking = bookingBuilder.setHead("Header")
//                                        .setBody("Body")
//                                        .setFooter("Footer")
//                                        .buildEnglishBooking();

//        booking = bookingBuilder
//        		.setPerson()
//        		.setCar()
//        		.setDuration()
//        		.setStartDay()
//        		.buildBooking();
//        
        
        
Booking booking = bookingBuilder.buildBooking();    

		booking = bookingBuilder
        	    .setPerson(person)       
        	    .setCar(car)             
        	    .setDuration(duration) 
        	    .setStartDay(startDay)   
        	    .buildBooking();
		
		
		  if (booking != null) {
	            System.out.println(booking.getHead());
	        }
	    
        
        System.out.println(booking.getHead());
    }
    
    public int chooseBookingLanguage() {
    	Scanner bookingScan = new Scanner(System.in);
        System.out.println("Wählen Sie ihre Buchungssprache / Choose language of booking:");
        System.out.println("Wählen Sie 1 für Deutsch / Choose 2 for English.");
        int bookingLanguage = bookingScan.nextInt();
        
        return bookingLanguage;
    }
}

