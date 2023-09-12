package de.stabi.ressource.structure;

import java.util.Date;

public class SetTopBoxDecorator extends Decorator {
	
	private int duration;
	
	//explicit constructor
	public SetTopBoxDecorator(Ressource car) {
		super(car);
		// TODO Auto-generated constructor stub
	}
	
    @Override
    public String getDescription() {
        return car.getDescription() + ", Extra: Set Topbox";
    }

    @Override
    public Double getCost() {
        return car.getCost() + 10.0;
    }

	@Override
	public int getDuration() {
		// TODO Auto-generated method stub
		duration = car.getDuration();
		return duration;
	}

	@Override
	public void setDuration(int duration) {
		this.duration = duration;
		
	}

	@Override
	public Double getTotalPrice() {
		// TODO Auto-generated method stub
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

