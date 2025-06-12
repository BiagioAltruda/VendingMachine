
public class Admin extends User{

	private final String accessCode = "accessCode"; //Admin access code
	private static Admin instance; //I'll make sure that there will only be 1 admin instance for all operations
	private Admin() {
	}
	
	public static Admin getInstance() { //I enforce this rule
		if (instance == null)
			instance = new Admin();
		
		return instance;
	}
	
	public static Beverages restock (Beverages b, int modifier) throws ArithmeticException { //Restock method for adding/removing beverages
		if(modifier < 0) // if i'm removing items
			if((b.getQuantity()+modifier) < 0) //if i would go below 0
				throw new ArithmeticException ("Cannot set quantity lower than 0"); //throw exeption
		b.setQuantity(b.getQuantity()+modifier); //otherwise just do the operation
			
		return b; //giving back the beverage
				
		
	}
	
	public static Beverages adjustPrice(Beverages b, double modifier) throws ArithmeticException { //Method to change the price of a beverage
		if (modifier < 0)	//basically same logic as before
			if((b.getProductPrice() + modifier)< 0)
				throw new ArithmeticException ("Cannot reduce price below 0");
		b.setProductPrice(b.getProductPrice()+modifier); //changing the price
		
		return b; //giving back the beverage
		
	}
	public static void emptyRegister() {
		
	}
	
}
