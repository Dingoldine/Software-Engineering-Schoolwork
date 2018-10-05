/*Kommentar till mönsterbeskrivningen ovan: Man kan välja att i den gemensamma superklassen Component
endast ha de attribut och metoder som är meningsfulla i både Leaf och Composite. Då tas alltså add(), 
remove() och getChild() bort från Component och implementeras bara i Composite där de går att utföra.
Om t.ex. add() finns i Component så finns den också i Leaf p.g.a. arvet men add() är meningslös och t.o.m. otillåten i Leaf!
*/

//toString() för en liten pryl returnerar namnet medan toString() för en behållare ska returnera en String
// med behållarens namn följt av namnen på alla saker som finns i behållaren.
import java.util.*;

public class Composite extends Component implements Iterable<Component>{

	private ArrayList<Component> bag = new ArrayList<>();

	public Composite(int weight, String name){
		super(weight, name);

	}

	public void addComponent(Component c){
		bag.add(c);

	}

	public ArrayList<Component> getBag(){
		return bag;
	}

	@Override
	public String toString(){
		String content = super.toString();
		for (Component c : bag) {
			if (!(c instanceof Composite)){
				content += "\n" + "    " + c.toString();
			}
			else{
				content += "\n" + c.toString() ;
			}
			
		}
		return content;
	}
	
	@Override
	public int getWeight(){
		int totWeight = super.getWeight();
		for (Component c : bag) { 
			totWeight += c.getWeight();
		}
		return totWeight;
	}


	public void removeComponent(String item){
		found: {
		for (int i = 0; i < bag.size(); i++) {
			if (bag.get(i).toString().equals(item)) {
				bag.remove(i);
				break found;
				
			}

		
		}		
		System.out.print("\n" +  "No such item in bag");

		}

	}



	@Override
	public Iterator<Component> iterator(){
		//return new TheIterator(this);
		return new DFIterator(this);

	}

}