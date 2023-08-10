package Ressource;

public abstract class Decorator implements Ressource {
	
	private Ressource ressource;
	
	public int ressourcecount = 0;
	
	public Ressource addRessource() {
		ressourcecount++;
		return ressource.addRessource();
	}
	
	public Ressource getRessource() {
		return ressource.getRessource();
	}
	
	public Ressource setRessource() {
		return ressource.setRessource();
	}

}
