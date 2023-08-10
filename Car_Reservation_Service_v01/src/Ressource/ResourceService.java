package Ressource;

public class ResourceService {
	
	public Ressource getSelectedResource() {
		
		Ressource ressource = Decorator.addRessource();
		return ressource;
		
	}

}
