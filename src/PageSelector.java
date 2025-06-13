import java.util.Scanner;

public abstract class PageSelector {
	private static Distributore vendingMachine = Distributore.getInstance(); //getting all the needed entities
	private static RegularUser user = new RegularUser();
	private static Scanner scan = new Scanner(System.in);
	private static Admin admin = Admin.getInstance();

	public static void regularUserProcess(int code) { //if the user put a valid product code we execute this
		Beverages b = vendingMachine.getCatalogue().get(code);	//reads the code
		if (b!= null) {	// checks if product exists
			System.out.println("Do you want to pay with credit or cash? \n select 1 for credit or 2 for cash");
			int method = scan.nextInt(); //taking input
			if (method == 1)
				user.payCredit(b); //choosing the correct payment option
			else if (method == 2)
				user.payCash(b);
			else {
				System.out.println("Insert valid option. Retry"); 
				return;
			}
		} else {
			System.out.println("Insert a valid code");
			return;
		}

	}

	public static void adminProcess() { // admin page
		System.out.println("Logged as admin.");
		int choice;
		
		do {
		System.out.println("Choose any of the following:" //simple menu
				+ "\n 1. Restock machine\n 2. Adjust price of a product\n 3. show all products"
				+ "\n 4. empty register \n 5. Add credit \n 6. turn off vending machine");
		choice = scan.nextInt();
		
		switch (choice) {
		case 1:
			try {
			System.out.println("Insert beverage code: "); //tries to get a beverage code
			Beverages b = vendingMachine.getCatalogue().get(scan.nextInt());
			System.out.println("amount to add or remove"); //and a quantity to add or remove if it exists
			admin.restock(b, scan.nextInt());
			} catch(NullPointerException e) { //if it doesn't
				System.out.println("No product exists with inserted code.");
				System.out.println("Adding new product....");
				admin.restockAddHelper(); //add a new product
				System.out.println();
				continue;
			}
			break;
		case 2:
			System.out.println("Insert beverage code: ");
			try {
			Beverages b1 = vendingMachine.getCatalogue().get(scan.nextInt()); //same as before
			System.out.println("Insert new price: ");	//asking for new price
			admin.adjustPrice(b1, scan.nextDouble());	//doing the changes
			} catch(NullPointerException e) {
				System.out.println("No product exists with inserted code."); //same type of exception as case 1
			}
			System.out.println();
			break;
		case 3:
			admin.productsData(); //print data of all inserted products, whether or not it is in stock
			System.out.println();
			break;
		case 4:
			admin.emptyRegister(); //empies cash register
			System.out.println();
			break;
		case 5:
			System.out.println("Insert how much credit to load: "); //loads money in the machine
			admin.addMachineCredit(scan.nextDouble());
			System.out.println();
			break;
		case 6:
			admin.quitProgram(); //quit
			break;
		default:
			
		}
	}while(choice != 6);
		
	}

}