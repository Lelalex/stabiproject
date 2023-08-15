package Ressource;

public interface Ressource {
	
	/*
	 * mit dem Use Case „getSelectedResource“ des „ResourceService“ sowie den
	 * Fachtypen “Resource”, “Car”, „SetTopBox“ und „ChildSeat“. 
	 * Verwenden Sie zur Realisierung das Entwurfsmuster „Decorator“.
	 * 
	 * Credit: https://www.baeldung.com/java-decorator-pattern
	 */
	
	Ressource setRessource();
	Ressource getRessource();
	Double getPrice();
	String getBrand();
	String getLicense();
		
}
