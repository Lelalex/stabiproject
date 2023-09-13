package Ressource;

import java.util.Date;

public class ChildSeatDecorator extends Decorator {

	private int duration;

	//explicit constructor
	public ChildSeatDecorator(Ressource car) {
		super(car);
	}
	
    @Override
    public String getDescription() {
        return car.getDescription() + ", Extra: Child Seat";
    }
    
    @Override
    public Double getCost() {
        return car.getCost() + 10.0;
    }

	@Override
	public int getDuration() {
		duration = car.getDuration();
		return duration;
	}

	@Override
	public void setDuration(int duration) {
		this.duration = duration;
		
	}

	@Override
	public Double getTotalPrice() {
		return car.getCost() * duration + 10.0 * duration;
	}

	@Override
	public Date getStartDay() {
		return car.getStartDay();
	}

	@Override
	public void setStartDay(Date startDay) {
		car.setStartDay(startDay);		
	}
}

	
//	public String getSize() {
//		size = "baby";
//		size = "big";
//		return size;
//	}

//	private Ressource addChildSeat() {
//		Ressource childSeat = null;
//		// TODO Auto-generated method stub
//		return childSeat;
//	}

