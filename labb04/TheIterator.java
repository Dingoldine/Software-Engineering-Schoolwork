import java.util.Iterator;
import java.util.LinkedList;

public class TheIterator implements Iterator<Component>{
	public LinkedList<Component> queue = new LinkedList<Component>();
	
	public TheIterator(Component comp){
		super();
		queue.add(comp);
	}

	@Override
	public boolean hasNext(){
		return !queue.isEmpty();
	}

	public Component next() {

		if (queue.peek() instanceof Composite){
			for (Component elements : ((Composite) queue.peek()).getBag()){
				queue.add(elements);
			}
		}
	
		return queue.remove();
	}
	@Override
	public void remove(){

	}




}
