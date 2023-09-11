package Ressource;

import java.util.Date;

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
	Double getCost();
	String getBrand();
	String getLicense();
	String getDescription();
	
	public int getDuration();
	public void setDuration(int duration);

	public Double getTotalPrice();

	public Date getStartDay();
	public void setStartDay(Date startDay);
		
}
