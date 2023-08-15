package Ressource;

public abstract class Decorator implements Ressource {
	
	public Ressource car;
	
	public int ressourcecount = 0;
	
	//constructor
	public Decorator() {
		
	}
	
	public int addRessource() {
		return ressourcecount;
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
	public Double getPrice() {
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

}
