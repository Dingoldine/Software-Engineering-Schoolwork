import java.util.*;
public class MainApp{
	
	public static void main(String[] args) {

		Composite root = new Composite(1, "Suitcase");

		Leaf leaf2 = new Leaf(1, "Hat");
		Leaf leaf1 = new Leaf(2, "Jeans");
		Leaf leaf3 = new Leaf(3, "Sweater");

		Composite plasticbag = new Composite(1 , "plasticbag");
		Leaf leaf7 = new Leaf(2, "Towel");
		Leaf leaf8 = new Leaf(1, "Shorts");

		Composite toiletbag = new Composite(1, "toiletbag");
		Leaf leaf4 = new Leaf(1, "Toothbrush");
		Leaf leaf5 = new Leaf(1, "Toothpaste");
		Leaf leaf6 = new Leaf(2, "Perfume");

		root.addComponent(leaf1);
		root.addComponent(leaf2);
		root.addComponent(leaf3);

		toiletbag.addComponent(leaf4);
		toiletbag.addComponent(leaf5);
		toiletbag.addComponent(leaf6);

		plasticbag.addComponent(leaf7);
		plasticbag.addComponent(leaf8);
		plasticbag.addComponent(toiletbag);
		
		root.addComponent(plasticbag);
		
		int weight = 0;
		for(Component c : root.getBag()){
			System.out.print(c.name);
			weight += c.weight;
		}
		System.out.print(weight);



		System.out.print("\n");

		int totWeight2 = 0;
		for (Component c : root){
			totWeight2 += c.weight;

		}
		System.out.print(totWeight2);

		
		System.out.print("\n");

		//Itererar genom den. 
		int totWeight = 0;
		Iterator<Component> iter1 = root.iterator();
		while (iter1.hasNext()){
			Component comp = iter1.next();
			totWeight += comp.weight;
		}
		System.out.print(totWeight);

		System.out.print("\n");

		String content = "";
		Iterator<Component> iter = root.iterator();
		while (iter.hasNext()){
			Component comp = iter.next();
			content += comp.name +"\n";
		}

		System.out.print(content);
	}
		
}