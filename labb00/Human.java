import java.util.Random;

public class Human{
	private int age;
	private String name;

	public Human(int ageIn, String nameIn){
		age = ageIn;
		name = nameIn;
	}

	public Human(){
		this(getRandomAge(), getRandomName());
	}

	public static int getRandomAge() {
		int age;
		Random rn = new Random();
		age = rn.nextInt(100);
		return age;
	}

	
	public static int getRandomYear() {
		int year;
		Random rn = new Random();
		year = rn.nextInt(2020 - 1930) + 1930;
		return year;
	}
	public static String getRandomName() {
		String[] name_list = {"Joel", "Samuel", "Kanye", "Wockaflockafluflä", "Mexican Jesus", "Jidell", "Brazil Guy", "Nami", "Bitch Nami", "Fetto", "Fet Nami"};

		Random rn = new Random();
		return name_list[rn.nextInt(name_list.length)];
	}
	
	public String getName(){
		return name;
	}
	public int getAge(){
		return age;
	}
	public String toString(){
		return(name + " is " + age + " years old" );
	}	

}