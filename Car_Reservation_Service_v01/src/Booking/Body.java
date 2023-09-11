package Booking;

import Ressource.Ressource;

public class Body {

	private Ressource car;
//    private int duration;
//    private double price;
//    private Date startDay;

	// constructor with default valuees
	public Body() {
		car = null;
	}

	public void setBody(Ressource car) {
		this.car = car;
	}
}
