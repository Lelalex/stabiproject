package Ressource;


public class GPSDecorator extends Decorator {
    public GPSDecorator(Ressource decorator) {
        super(decorator);
    }

    @Override
    public String getDescription() {
        return car.getDescription() + ", GPS Addon";
    }

    @Override
    public Double getCost() {
        return car.getCost() + 10.0;
    }
}