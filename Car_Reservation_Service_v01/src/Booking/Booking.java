package Booking;

public abstract class Booking {
	
//	private Body body;
//	private BookingType bookingType;
//	private Footer footer;
//	private double price;
//	private Head head;
	
//    String getHead();
//    String getBody();
//    String getFooter();
	
	//constructor
	public Booking() {}
	
	public abstract void setBody(Body body) ;
	
	public abstract void setFooter(Footer footer) ;
	
	public abstract void setHead(Head head) ;
	
	public abstract Body getBody();
	
	public abstract Footer getFooter();
	
	public abstract Head getHead();
	
	public abstract double getPrice();
}
