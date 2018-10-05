/*Kommentar till mönsterbeskrivningen ovan: Man kan välja att i den gemensamma superklassen Component
endast ha de attribut och metoder som är meningsfulla i både Leaf och Composite. Då tas alltså add(), 
remove() och getChild() bort från Component och implementeras bara i Composite där de går att utföra.
Om t.ex. add() finns i Component så finns den också i Leaf p.g.a. arvet men add() är meningslös och t.o.m. otillåten i Leaf!
*/

public abstract class Component{

	protected int weight;
	protected String name;


	public Component(int weight, String name){
		this.weight = weight;
		this.name= name;

	}

	public int getWeight(){
		return weight;
	}

	public String toString(){
		return name + "\n";

		}




	

	//public abstract Component getComponent(String item);
 	//public abstract void removeComponent(String item);
	//public abstract int getComponentCount();

}