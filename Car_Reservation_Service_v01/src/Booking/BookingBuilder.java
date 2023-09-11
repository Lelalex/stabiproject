package Booking;

import java.util.Date;

import Person.Person;
import Ressource.Car;
import Ressource.Ressource;

public abstract class BookingBuilder {
	protected Person person;
	protected Ressource car;
	protected int duration;
//	protected Date startDay;

	public BookingBuilder(Person person, Ressource car, int duration) 
	{
		this.person = person; 
		this.car = car; 
		this.duration = duration;
	}
	
	public BookingBuilder setPerson(Person person) {
		this.person = person;
		return this;
	}
	
	public BookingBuilder setCar(Ressource car) {
		this.car = car;
		return this;
	}
	
	public BookingBuilder setCar(int duration) {
		this.duration = duration;
		return this;
	}

	protected abstract void buildHead();
	
	protected abstract void buildBody();
	
	protected abstract void buildFooter();
	
	protected abstract Booking buildBooking();
	
}



//public abstract class BookingBuilder {
//	protected Person person;
//	protected Ressource car;
//	protected int duration;
//	protected Date startDay;
//
//	public BookingBuilder(Person person, Ressource car, int duration, Date startDay) 
//	{
//		this.person = person; 
//		this.car = car; 
//		this.duration = duration; 
//		this.startDay = startDay; 
//	}
//	
//	public BookingBuilder setPerson(Person person) {
//		this.person = person;
//		return this;
//	}
//	
//	public BookingBuilder setCar(Ressource car) {
//		this.car = car;
//		return this;
//	}
//
//	public BookingBuilder setDuration(int duration) {
//		this.duration = duration;
//		return this;
//	}
//
//	public BookingBuilder setStartDay(Date startDay) {
//		this.startDay = startDay;
//		return this;
//	}
//
//
//
//
//	protected abstract void buildHead();
//	
//	protected abstract void buildBody();
//	
//	protected abstract void buildFooter();
//	
//	protected abstract Booking buildBooking();
//}


