package Ressource;

public class Car implements Ressource{
	
	private Ressource Car;
	private String brand;
	private String license;
	private String colour;
	

	public Ressource setRessource() {
		return Car;
	}

	@Override
	public Ressource getRessource() {
		// TODO Auto-generated method stub
		return Car;
	}

	public String getBrand() {
		return brand;
	}
	
	public String getLicense() {
		return license;
	}
	
	public String getColour() {
		return colour;
	}

	@Override
	public Double getCost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

}
