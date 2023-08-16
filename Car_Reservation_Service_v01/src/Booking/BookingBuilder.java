package Booking;

import Person.Person;

//public abstract class Builder {
//
//	public void buildHead() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public void buildBody() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public void buildFooter() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	protected abstract Booking buildBooking();
//
//}

public abstract class BookingBuilder 
{
    protected Person person; 
    protected CarConfiguration car;
    protected int duration;
    protected String startDay; 
    public Builder builder; 

    public BookingBuilder(Person person, CarConfiguration car, int duration, String startDay) 
    {
        this.person = person; 
        this.car = car; 
        this.duration = duration; 
        this.startDay = startDay; 
    }

    protected abstract void buildHead();
    protected abstract void buildBody(); 
    protected abstract void buildFooter();
    protected abstract Booking buildBooking();