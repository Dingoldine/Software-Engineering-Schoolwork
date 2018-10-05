import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;


public class DFIteratorn implements Iterator<Component> {

	Stack<Component> stack = new Stack<Component>();
	
	public DFIteratorn(Component comp) {
		super();
//		for (Component elements : content){
//			stack.add(elements);
//		}
		stack.add(comp);
	}
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return !stack.empty();
	}

	@Override
	public Component next() {
		Component pop = stack.pop();
		if (pop instanceof Composite){
			for (Component elements : ((Composite) pop).content){
				stack.push(elements);
			}
		}
		return pop;
	}

}
