import java.util.Map;
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

	public static void adminProcess() {
		System.out.println("Logged as admin.");
		int choice;
		
		do {
		System.out.println("Choose any of the following:"
				+ " \n 1. Restock machine \n 2. Remove an item \n 3. Adjust price of a product \n 4. show all products"
				+ " \n 5. empty register \n 6. Add credit \n 7. Return to initial menu \n 8. Exit program");
		choice = scan.nextInt();
		
		switch (choice) {
		case 1:
			try {
			System.out.println("Insert beverage code: ");
			Beverages b = vendingMachine.getCatalogue().get(scan.nextInt());
			System.out.println("amount to add or remove");
			admin.restock(b, scan.nextInt());
			System.out.println();
			} catch(NullPointerException e) {
				System.out.println("No product exists with inserted code.");
				System.out.println("Adding new product....");
				admin.restockAddHelper();
				continue;
			}
			break;
		case 2:
			admin.removeDrink();
			System.out.println("Updated list:");
			admin.productsData();
			System.out.println();
			break;
		case 3:
			System.out.println("Insert beverage code: ");
			Beverages b1 = vendingMachine.getCatalogue().get(scan.nextInt());
			System.out.println("Insert new price: ");
			admin.adjustPrice(b1, scan.nextDouble());
			System.out.println();
			break;
		case 4:
			admin.productsData();
			System.out.println();
			break;
		case 5:
			admin.emptyRegister();
			System.out.println();
			break;
		case 6:
			System.out.println("Insert how much credit to load: ");
			admin.addMachineCredit(scan.nextDouble());
			double temp = Distributore.getInstance().getChange();
			System.out.println("Adesso nel distributore ci sono: " + temp + "\u20AC");
			System.out.println();
			break;
		case 7:
			System.out.println("Ritorno al menu iniziale...");
			Distributore.getInstance().run();
		case 8:
			admin.quitProgram();
			break;
		default:
			
		}
	}while(choice != 8);
		
	}

}