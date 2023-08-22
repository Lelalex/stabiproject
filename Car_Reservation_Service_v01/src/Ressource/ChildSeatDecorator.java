package Ressource;

public class ChildSeatDecorator extends Decorator {

//	private String size;

	//explicit constructor
	public ChildSeatDecorator(Ressource decorator) {
		super(decorator);
		// TODO Auto-generated constructor stub
	}

	public int addRessource() {
		ressourcecount++;
		return ressourcecount;
	}
	
    @Override
    public String getDescription() {
        return car.getDescription() + " Extra: Child Seat";
    }
    
	@Override
	public Double getCost() {
		return car.getCost() + 10.0;
	}
	
//	public String getSize() {
//		size = "baby";
//		size = "big";
//		return size;
//	}

//	private Ressource addChildSeat() {
//		Ressource childSeat = null;
//		// TODO Auto-generated method stub
//		return childSeat;
//	}
}
