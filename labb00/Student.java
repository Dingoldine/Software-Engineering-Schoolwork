public class Student extends Human{
	private int year;
	private String program;

	public Student(int yearIn, String programIn, int ageIn,String nameIn){
		super(ageIn, nameIn);
		if ((yearIn < 1934 || yearIn > 2016) || (super.getAge() < 15)){
			throw new IllegalArgumentException("Startår: " + super.getRandomYear() + " ålder: " + super.getAge());
		}
		else {

			year = yearIn;
			program = programIn;
			
		}
	}

	public Student(String programIn){
		this(getRandomYear(), programIn, getRandomAge(), getRandomName());

	}
	
	@Override
	public String toString(){
		return(super.getName() + " is " + super.getAge() + " years old and started " + program + " year " + year);
	}
	public int getYear(){
		return year;
	}

}