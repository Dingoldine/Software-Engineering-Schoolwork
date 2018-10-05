
public class Suitcase {
	
	public static void main(String[] args) {
		Composite bag = new Composite("Bag", 15);
		Composite nes = new Composite("Necessar", 1);
		bag.add(nes);
		Composite smink = new Composite("Smink", 5);
		nes.add(smink);
		Leaf ls = new Leaf("Lappstift", 1);
		smink.add(ls);
		Composite pase = new Composite("Pase", 1);
		bag.add(pase);
		Composite skovaska = new Composite("Skovaska", 2);
		bag.add(skovaska);
		Leaf tb = new Leaf("Tandborste", 1);
		nes.add(tb);
		Leaf skjorta = new Leaf("Skjorta", 1);
		bag.add(skjorta);
		Leaf skor = new Leaf("Skor", 1);
		skovaska.add(skor);
		Leaf tb2 = new Leaf("Parfym", 1);
		nes.add(tb2);
		Leaf tb3 = new Leaf("Rakhyvel", 1);
		nes.add(tb3);
		
		System.out.println(bag.toString(bag));
		System.out.println(bag.getWeight(bag));
		System.out.println("\n");
		
		System.out.println(nes.toString(nes));
		System.out.println(nes.getWeight(nes));
		System.out.println("\n");
		
		bag.remove(nes);
		System.out.println(bag.toString(bag));
		System.out.println(bag.getWeight(bag));
		System.out.println("\n");
		
		skovaska.remove(skor);
		System.out.println(bag.toString(bag));
		System.out.println(bag.getWeight(bag));
		System.out.println("\n");
		
//		skovaska.add(skor);
//		System.out.println(bag.printContent());
//		System.out.println("\n");
		
		
	}
	
}
