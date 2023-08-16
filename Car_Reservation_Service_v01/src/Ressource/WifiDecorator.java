package Ressource;

public class WifiDecorator extends Decorator {
    public WifiDecorator(Ressource decorator) {
        super(decorator);
    }

    @Override
    public String getDescription() {
        return car.getDescription() + ", Wifi Addon";
    }

    @Override
    public Double getCost() {
        return car.getCost() + 5.0;
    }
}

