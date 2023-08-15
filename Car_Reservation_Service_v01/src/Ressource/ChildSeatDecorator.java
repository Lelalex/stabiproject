package Ressource;

public class ChildSeatDecorator extends Decorator {

	private String size;

	//explicit constructor
	public ChildSeatDecorator() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int addRessource() {
		ressourcecount++;
		return ressourcecount;
	}
	
	@Override
	public Double getPrice() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String getSize() {
		size = "baby";
		size = "big";
		return size;
	}

//	private Ressource addChildSeat() {
//		Ressource childSeat = null;
//		// TODO Auto-generated method stub
//		return childSeat;
//	}
}
