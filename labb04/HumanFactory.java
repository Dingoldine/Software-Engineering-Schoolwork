import Human.*;

public class HumanFactory{

	public static void main(String[] args) {
		Human philip = Human.create("Philip", "19931201-3676");
		System.out.print(philip);
		//if (philip instanceof Man){
		//	System.out.print("Success");
		//}

		System.out.print("\n");

		Human sara = Human.create("Sara", "19931201-3686");
		System.out.print(sara);
		System.out.print("\n");

	
		//if (sara instanceof Woman){
		//	System.out.print("Success Again!");
		//}

		
	}

}