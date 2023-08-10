package Booking;

public class BookingBuilder {
    private String head;
    private String body;
    private String footer;

    public BookingBuilder setHead(String head) {
        this.head = head;
        return this;
    }

    public BookingBuilder setBody(String body) {
        this.body = body;
        return this;
    }

    public BookingBuilder setFooter(String footer) {
        this.footer = footer;
        return this;
    }

//    public GermanBooking buildGermanBooking() {
//        return new GermanBooking(head, body, footer);
//    }
//
//    public Booking buildEnglishBooking() {
//        return new EnglishBooking(head, body, footer);
//    }

	
}
