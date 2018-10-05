import java.util.ArrayList;
import java.util.Iterator;
//import java.util.ListIterator;


public class Composite extends Component implements Iterable<Component> {
	public ArrayList<Component> content; 
	public Component component;
	
	public Composite(String representation, int vikt) {
		super(representation, vikt);
		content = new ArrayList<Component>();
	}
	
	public void add(Component item){
		content.add(item);
	}
	
	public void remove(Component item){
		content.remove(item);
		}
	
	public ArrayList<Component> getContent(){
		return content;
	}

	public int getWeight(Component comp){
		int vikt=0;
		component = comp;
		Iterator<Component> iter = this.iterator();
		while (iter.hasNext()){
			Component element = iter.next();
			vikt+= element.vikt;
		}
		return vikt;
	}
	
	public String toString(Component comp){
		String bag="";
		component = comp;
		Iterator<Component> iter = this.iterator();
		while (iter.hasNext()){
			Component element = iter.next();
			bag+= element.representation + " ";
		}
		return bag;
	}
	
	public Iterator<Component> iterator() {
		return new Iteratorn(component);
		//return new DFIteratorn(component);
	}
	
	
	
}
