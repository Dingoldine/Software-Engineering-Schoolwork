package Human;

class Man extends Human{
	private String name;
	private String pnr;
 
    Man(String name, String pnr){
    	this.name = name;
    	this.pnr = pnr;

    }
    

    public String toString(){
    	return this.name + " " + this.pnr;
    }	   
}    