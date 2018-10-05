
public abstract class Component {
	String representation;
	int vikt;
	
	public Component(String representation, int vikt){
		this.representation = representation;
		this.vikt = vikt;
	}
	public int getWeight(){
		return vikt;
	}
	public String toString(){
		return representation;
	}
	public String getName(){
		return representation;
	}

}
