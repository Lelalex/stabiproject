package Ressource;

public abstract class Decorator implements Ressource {
	
	protected Ressource car;
	
	
	//constructor
	public Decorator(Ressource car) {
		this.car = car;	
	}
	
	
	
	@Override
	public Ressource setRessource() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ressource getRessource() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double getCost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBrand() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLicense() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

}
