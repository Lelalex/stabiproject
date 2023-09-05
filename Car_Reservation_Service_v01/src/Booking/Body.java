package Booking;

import Ressource.Car;

//public class Body {
//	
//	private Car car;
//	private int duration;
//	private double price;
//	private String startDay;
//	
//	public Body() {
//		// TODO Auto-generated constructor stub
//	}
//	
//	public void setBody(Car car, int duration, String startDay, Double cost) {
//		// TODO addd CarConfig in Ressource
//		
//	}
//	
//}
public class Body {
    
    private Car car;
    private int duration;
    private double price;
    private String startDay;
    
    // Standardkonstruktor: Standardwerte für Instanzvariablen festgelegt
    public Body() {
        car = null;            // Standardwert für car: null (kein Auto zugewiesen)
        duration = 0;          // Standardwert für duration: 0 (keine Dauer festgelegt)
        price = 0.0;           // Standardwert für price: 0.0 (Preis auf 0.0 festgelegt)
        startDay = "N/A";      // Standardwert für startDay: "N/A" (kein Startdatum festgelegt)
    }
    
    public void setBody(Car car, int duration, String startDay, Double cost) {
        this.car = car;
        this.duration = duration;
        this.startDay = startDay;
        
        // Berechnen des Preises basierend auf der Dauer und den Kosten des Autos
        this.price = duration * cost;
    }
}


