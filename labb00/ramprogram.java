class ramprogram{
	public static void main(String[] args){
/*		// Del 1 och 2
		Human myHuman = new Human(22, "Philip");
		System.out.println(myHuman.getAge());
		System.out.println(myHuman.getName());
		System.out.println(myHuman.toString());
		//System.out.println(Philip); ger error

		//Del 3
		Human anotherHuman = new Human();
		Human yetAnother = new Human();
		System.out.println(anotherHuman.toString());
		System.out.println(yetAnother.toString());
		
		Human[] array_of_humans = new Human[15];
		for (Human i : array_of_humans){ // for each Human in array_of_humans
			i = new Human();
			System.out.println(i.toString());
		}
		*/
		
		//Del 4
	/*	Student[] array_of_students = new Student[15];
		for (Student i : array_of_students){ // for each Student in array_of_Students
			i = new Student("CINEK");
			System.out.println(i.toString());*/

		Human[] mixed_array = new Human[10];
		for (int i = 0; ( i < mixed_array.length/2); i++){
			Human obj1 = new Human();
			Student obj2 = new Student("CINEK");
			mixed_array[i] = obj1;
			mixed_array[i+5] = obj2;

		}
		for (Human h : mixed_array){ // for each Human in mixed_array
			System.out.println(h.toString());
		}
	}
}