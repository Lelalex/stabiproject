package Content;

import Booking.Booking;

public class File extends Content {
    private String contentDetails;
    private Booking booking;
    private PaymentReceipt paymentReceipt;

    public File(String name, String contentDetails, String booking, String paymentReceipt) {
        super(name);
        this.contentDetails = contentDetails;
        this.booking = booking;
        this.paymentReceipt = paymentReceipt;
    }

    @Override
    public void displayContentDetails() {
        System.out.println("File Name: " + this.name);
        System.out.println("Content: " + this.contentDetails);
    }


//    public void operation() {
//        String formatString;
//        // Berechnen des Formatstrings fuer die Ausgabe von
//        // Leerzeichen entsprechend der erreichten Ebene
//        formatString = "%" + (level * 2) + "s";
//        // Ausgabe der Leerzeichen
//        System.out.printf(formatString, "");
//        // Ausgabe eines Minuszeichens gefolgt vom Namen des Knotens
//        System.out.println(" - " + super.getName());
//    }
//
//    public Booking getBooking() {
//        return booking;
//    }
//
//    public PaymentReceipt getPaymentReceipt() {
//        return paymentReceipt;
    }