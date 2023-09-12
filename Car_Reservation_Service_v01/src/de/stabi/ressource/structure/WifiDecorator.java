package de.stabi.ressource.structure;

import java.util.Date;

public class WifiDecorator extends Decorator {
	
	private int duration; 
	
    public WifiDecorator(Ressource car) {
        super(car);
//        this.duration = duration;
//        this.setStartDay(startDay);
    }

    @Override
    public String getDescription() {
        return car.getDescription() + ", Extra: Wifi Addon";
    }

    @Override
    public Double getCost() {
        return car.getCost() + 5.0;
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
		return car.getCost() * duration + 5.0 * duration;
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

