import java.util.Iterator;
import java.util.LinkedList;

public class Iteratorn implements Iterator<Component> {

	public LinkedList<Component> queue = new LinkedList<Component>();
	
	@Override
	public boolean hasNext() {
		return !queue.isEmpty();
	}

	public Iteratorn(Component comp) {
		super();
		queue.add(comp);
	}

	@Override
	public Component next() {
		if (queue.peek() instanceof Composite){
			for (Component elements : ((Composite) queue.peek()).content){
				queue.add(elements);
			}
		}
		return queue.remove();
	}
}
