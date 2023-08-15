package Ressource;

public class SetTopBoxDecorator extends Decorator {
	
	//explicit constructor
	public SetTopBoxDecorator() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int addRessource() {
		ressourcecount++;
		return ressourcecount;
	}

//	private Ressource addSetTopBox() {
//		Ressource SetTopBox = null;
//		// TODO Auto-generated method stub
//		return SetTopBox;
//	}
}
