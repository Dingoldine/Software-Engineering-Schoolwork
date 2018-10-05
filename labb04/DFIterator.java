import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;


public class DFIterator implements Iterator<Component>{
	Stack<Component> stack = new Stack<Component>();
	
	public DFIterator(Component comp){
		super();
		stack.add(comp);
	}

	@Override
	public boolean hasNext(){
		return !stack.isEmpty();
	}

	@Override
	public Component next() {
		Component item = stack.pop();
		if (item instanceof Composite){
			for (Component elements : ((Composite) item).getBag()){
				stack.push(elements);
			}
		}
		return item;
	}

	@Override
	public void remove(){

	}

}