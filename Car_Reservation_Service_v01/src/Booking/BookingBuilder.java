package Booking;

import Person.Person;
import Ressource.Car;

public abstract class BookingBuilder {
	protected Person person;
	protected Car car;
	protected int duration;
	protected String startDay;

	public BookingBuilder(Person person, Car car, int duration, String startDay) 
	{
		this.person = person; 
		this.car = car; 
		this.duration = duration; 
		this.startDay = startDay; 
	}
	
	public BookingBuilder setPerson(Person person) {
		this.person = person;
		return this;
	}
	
	public BookingBuilder setCar(Car car) {
		this.car = car;
		return this;
	}

	public BookingBuilder setDuration(int duration) {
		this.duration = duration;
		return this;
	}

	public BookingBuilder setStartDay(String startDay) {
		this.startDay = startDay;
		return this;
	}




	protected abstract void buildHead();
	
	protected abstract void buildBody();
	
	protected abstract void buildFooter();
	
	protected abstract Booking buildBooking();
	
}