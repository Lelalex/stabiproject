package Booking;

import Person.Person;

public abstract class BookingBuilder {
	protected Person person;
	protected CarConfiguration car;
	protected int duration;
	protected String startDay;

	public BookingBuilder setPerson(Person person) {
		this.person = person;
		return this;
	}
	
	public BookingBuilder setCar(CarConfiguration car) {
		this.car = car;
	}

	public BookingBuilder setDuration(int duration) {
		this.duration = duration;
	}

	public BookingBuilder setStartDay(String startDay) {
		this.startDay = startDay;
	}


//    public BookingBuilder(Person person, CarConfiguration car, int duration, String startDay) 
//    {
//        this.person = person; 
//        this.car = car; 
//        this.duration = duration; 
//        this.startDay = startDay; 
//    }


	protected abstract void buildHead();
	
	protected abstract void buildBody();
	
	protected abstract void buildFooter();
	
	protected abstract Booking buildBooking();
	
}