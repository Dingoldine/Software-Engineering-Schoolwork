
public class Leaf extends Component {
	
	public Leaf(String representation, int vikt) {
		super(representation, vikt);
	}

	public int getWeight(){
		return vikt;
	}
	public String toString(){
		return representation;
	}
}
