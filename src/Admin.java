import java.util.Map;
import java.util.Scanner;

public class Admin{

	private final int accessCode = 123; //Admin access code
	private static Admin instance; //I'll make sure that there will only be 1 admin instance for all operations
	private static Distributore vendingMachine = Distributore.getInstance();
	private Admin() {
	}
	
	public static Admin getInstance() { //I enforce this rule
		if (instance == null)
			instance = new Admin();
		
		return instance;
	}
	
	
	
	public int getAccessCode() {
		return accessCode;
	}

	public static boolean inStock(Beverages b) {
		for (Map.Entry<Integer, Beverages> entries: vendingMachine.getCatalogue().entrySet())
			if(entries.getValue().getProductName() == b.getProductName()) //if the product already exists, return true
				return true;
		return false;
	}
	
	public void restock (Beverages b, int modifier) throws ArithmeticException { //Restock method for adding/removing beverages
		if(inStock(b)) { //if the product already exists, modify it
		
		if(modifier < 0) // if i'm removing items
			if((b.getQuantity()+modifier) < 0) //if i would go below 0
				throw new ArithmeticException ("Cannot set quantity lower than 0"); //throw exeption
		b.setQuantity(b.getQuantity()+modifier); //otherwise just do the operation
			
		return;
				
			}
		 // if i get here it means that there are no products with matching names
		Integer max = vendingMachine.getCatalogue().lastKey(); //i get the last key in the map
		vendingMachine.getCatalogue().put(max+1, b); // and i put at the next spot the new item
		
	}
	
	public void adjustPrice(Beverages b, double newPrice) throws ArithmeticException { //Method to change the price of a beverage
		if(!inStock(b)) {		//if product is not present
			System.out.println("product not found");
			return;
		}
		if (newPrice < 0)		//if the price is negative
			throw new ArithmeticException ("New price must be positive"); //throw forces early return
		
		b.setProductPrice(newPrice); //setting product price
		
		return;
		
	}
	
	public void productsData() {
		vendingMachine.showProducts();
		}
	
	public void emptyRegister() { //method used to empty the cash register
		if (vendingMachine.getChange()==0) { //checks if the balance is 0
			System.out.println("No credit to retrive"); 
			return; //returns in that case
		}
		System.out.println("There are: " + vendingMachine.getChange() + "U+20AC"); //shows current balance
		System.out.println("Do you want to retrive it? \n Press 1 for yes, or 2 for no"); //ask for confirmation
		
		Scanner scan = new Scanner(System.in); //creating scanner
		
		int selector = scan.nextInt(); //and getting the selection 
		
		switch(selector) { //deciding what action to take
		case 1:
			System.out.println("retrieving....");
			vendingMachine.setChange(0); // sets the balance to 0, imitating getting the change out of the machine
			System.out.println("Done!");
			break;
		case 2:
			System.out.println("Goodbye!"); //returns
			break;
			default:
				System.out.println("Invalid selection"); //standard invalid selection message
		}
	}
	
	public void addMachineCredit(double modifier) { //Adds credit to the vending machine
		vendingMachine.setChange(vendingMachine.getChange()+modifier);
	}
	
	public void quitProgram() {
		System.out.println("Thanks for having us!");
		System.exit(0);
	}

}