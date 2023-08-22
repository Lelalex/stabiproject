package Ressource;

public class Car implements Ressource{
	
	private Ressource Car;
	private String brand;
	private String license;
	private String colour;
	private Double price;
	private String description;
	

	public Ressource setRessource() {
		return Car;
	}

	@Override
	public Ressource getRessource() {
		// TODO Auto-generated method stub
		return Car;
	}

	public String getBrand() {
		brand = "VW";
		return brand;
	}
	
	public String getLicense() {
		license = "LG XX 45";
		return license;
	}
	
	public String getColour() {
		colour = "white";
		return colour;
	}

	@Override
	// TODO Überprüfe ob Preis angenommen und addiert wird mit Extra-Ressource
	public Double getCost() {
		price = 70.00;
		return price;
	}
	
//	public String printDescription() {
//	System.out.println("You choose the following car configuration: ");
//	System.out.println("Brand: " + brand);
//	System.out.println("License: " + license);
//	System.out.println("Colour: " + colour);
//	}
	
	@Override
	public String getDescription() {
		description = "	You choose the following car configuration: \r\n"
				+ "Brand: " + brand
				+ " License: " + license
				+ " Colour: " + colour;
		return description;
	}

}
