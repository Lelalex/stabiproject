package Booking;


public class GermanBooking implements Booking {
    private String head;
    private String body;
    private String footer;

    public GermanBooking(String head, String body, String footer) {
        this.head = head;
        this.body = body;
        this.footer = footer;
    }

    @Override
    public String getHead() { return head; }

    @Override
    public String getBody() { return body; }

    @Override
    public String getFooter() { return footer; }
}
