import java.util.Map;
import java.util.Scanner;

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
	
	public static void restock (Beverages b, int modifier) throws ArithmeticException { //Restock method for adding/removing beverages
		for (Map.Entry<Integer, Beverages> entries: Distributore.getInstance().getCatalogue().entrySet())
			if(entries.getValue().getProductName() == b.getProductName()) { //if the product already exists, modify it
		
		if(modifier < 0) // if i'm removing items
			if((b.getQuantity()+modifier) < 0) //if i would go below 0
				throw new ArithmeticException ("Cannot set quantity lower than 0"); //throw exeption
		b.setQuantity(b.getQuantity()+modifier); //otherwise just do the operation
			
		return;
				
			}
		 // if i get here it means that there are no products with matching names
		Integer max = Distributore.getInstance().getCatalogue().lastKey(); //i get the last key in the map
		Distributore.getInstance().getCatalogue().put(max+1, b); // and i put at the next spot the new item
		
	}
	
	public static Beverages adjustPrice(Beverages b, double modifier) throws ArithmeticException { //Method to change the price of a beverage
		if (modifier < 0)	//basically same logic as before
			if((b.getProductPrice() + modifier)< 0)
				throw new ArithmeticException ("Cannot reduce price below 0");
		b.setProductPrice(b.getProductPrice()+modifier); //changing the price
		
		return b; //giving back the beverage
		
	}
	
	public static void productsData() {
		Distributore.getInstance().showProducts();
		}
	
	public static void emptyRegister() { //method used to empty the cash register
		if (Distributore.getInstance().getChange()==0) { //checks if the balance is 0
			System.out.println("No credit to retrive"); 
			return; //returns in that case
		}
		System.out.println("There are: " + Distributore.getInstance().getChange() + "U+20ACs "); //shows current balance
		System.out.println("Do you want to retrive it? \n Press 1 for yes, or 2 for no"); //ask for confirmation
		
		Scanner scan = new Scanner(System.in); //creating scanner
		
		int selector = scan.nextInt(); //and getting the selection 
		
		switch(selector) { //deciding what action to take
		case 1:
			System.out.println("retrieving....");
			Distributore.getInstance().setChange(0); // sets the balance to 0, imitating getting the change out of the machine
			System.out.println("Done!");
			break;
		case 2:
			System.out.println("Goodbye!"); //returns
			break;
			default:
				System.out.println("Invalid selection"); //standard invalid selection message
		}
	}
	
	public static void addMachineCredit(double modifier) {
		Distributore.getInstance().setChange(Distributore.getInstance().getChange()+modifier);
	}

}