package Booking;

public class Director {


private Builder builder;

public void setBuilder(Builder builder) 
{
	this.builder = builder; 
}

public Builder getBuilder() {
	return this.builder; 
}


//Buchungsteile (Kopf, Rumpf und Fuß) werden zusammen geführt
public Booking createBooking() // = director
{
	this.builder.buildHead();
	this.builder.buildBody();
	this.builder.buildFooter();
	Booking booking = builder.buildBooking();
	return booking; 
}

}