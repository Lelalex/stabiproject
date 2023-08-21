package Booking;

import java.util.Scanner;

public class BookingService {
	public int bookingLanguage = chooseBookingLanguage();
	
    public void createBooking() {
        BookingBuilder bookingBuilder;
    	Booking booking;
               
        
        switch(bookingLanguage) {
        case 1:
        	bookingBuilder = new GermanBookingBuilder ();
        	break;
        case 2: 
        	bookingBuilder = new EnglishBookingBuilder ();
        	break;
    	default:
    		System.out.println("Invalid Entry. Wählen Sie zur Buchung 1 für Deutsch / Choose 2 to book in English.");
    		return;
		}

//        Booking germanBooking = bookingBuilder.setHead("Kopf")
//                                       .setBody("Körper")
//                                       .setFooter("Fußzeile")
//                                       .buildGermanBooking();
//
//        Booking englishBooking = bookingBuilder.setHead("Header")
//                                        .setBody("Body")
//                                        .setFooter("Footer")
//                                        .buildEnglishBooking();

        booking = bookingBuilder
        		.setPerson()
        		.setCar()
        		.setDuration()
        		.setStartDay()
        		.buildBooking();
        
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

