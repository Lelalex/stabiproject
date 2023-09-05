package Booking;


//public abstract class ConcreteBooking extends Booking {
//    
//    private String bookingDetails;
//    
//    public ConcreteBooking(String bookingDetails) {
//        this.bookingDetails = bookingDetails;
//    }
//    
//    public String getBookingDetails() {
//        return bookingDetails;
//    }
//}




public abstract class ConcreteBooking extends Booking {
    private int bookingId;
    private String bookingDetails;

    public ConcreteBooking(int bookingId, String bookingDetails) {
        this.bookingId = bookingId;
        this.bookingDetails = bookingDetails;
    }

    public int getBookingId() {
        return bookingId;
    }

    public String getBookingDetails() {
        return bookingDetails;
    }
}
