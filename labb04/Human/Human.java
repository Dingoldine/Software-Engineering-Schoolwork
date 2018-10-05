package Human;

public abstract class Human{
	Human(){};

	public static Human create(String name, String pnr){

		int gender_decider = Character.getNumericValue(pnr.charAt(11));


		if (gender_decider % 2 == 0){
			Woman lady = new Woman(name, pnr);
			return lady;
		}
		else {
			Man sir = new Man(name, pnr);
			return sir;
		}
        
    }

 }
