package Booking;

public class BookingService {
    public void createBooking() {
        BookingBuilder bookingBuilder = new BookingBuilder();
        Booking germanBooking = bookingBuilder.setHead("Kopf")
                                       .setBody("Körper")
                                       .setFooter("Fußzeile")
                                       .buildGermanBooking();

        Booking englishBooking = bookingBuilder.setHead("Header")
                                        .setBody("Body")
                                        .setFooter("Footer")
                                        .buildEnglishBooking();

        System.out.println(germanBooking.getHead());
        
        System.out.println(englishBooking.getHead());
    }
}

