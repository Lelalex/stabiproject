package Ressource;

public class SetTopBoxDecorator extends Decorator {
	
	//explicit constructor
	public SetTopBoxDecorator(Ressource decorator) {
		super(decorator);
		// TODO Auto-generated constructor stub
	}

	public int addRessource() {
		ressourcecount++;
		return ressourcecount;
	}
	
    @Override
    public String getDescription() {
        return car.getDescription() + " Extra: Set Topbox";
    }

    @Override
    public Double getCost() {
        return car.getCost() + 10.0;
    }

//	private Ressource addSetTopBox() {
//		Ressource SetTopBox = null;
//		// TODO Auto-generated method stub
//		return SetTopBox;
//	}
}
