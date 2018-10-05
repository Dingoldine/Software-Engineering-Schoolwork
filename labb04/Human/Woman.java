package Human;

class Woman extends Human{

	private String name;
	private String pnr;
 
    Woman(String name, String pnr){
    	this.name = name;
    	this.pnr = pnr;
    	
    }


    public String toString(){
    	return this.name + " " + this.pnr;
    }	   
    	
}