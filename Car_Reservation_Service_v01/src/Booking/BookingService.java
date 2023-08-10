package Booking;

public class BookingService {
    public void createBooking() {
        BookingBuilder builder = new BookingBuilder();
        Booking germanBooking = builder.setHead("Kopf")
                                       .setBody("Körper")
                                       .setFooter("Fußzeile")
                                       .buildGermanBooking();

        Booking englishBooking = builder.setHead("Header")
                                        .setBody("Body")
                                        .setFooter("Footer")
                                        .buildEnglishBooking();

        System.out.println(germanBooking.getHead());
        
        System.out.println(englishBooking.getHead());
    }
}

