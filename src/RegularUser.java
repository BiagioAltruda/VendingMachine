import java.util.*;

public class RegularUser {

	private double credit;

	private static Distributore vendingMachine = Distributore.getInstance();

	public RegularUser() {
	}

	// Getters and Setters
	public double getCredit() {
		return credit;
	}

	public void setCredit(double credit) {
		this.credit = credit;
	}

	public boolean quantityHelper(Beverages b) throws ProductUnavailableException {
		try {
		if (b.getQuantity() > 0)
			return true;
		else
			throw new ProductUnavailableException ("Product is not available right now");
		} catch(ProductUnavailableException e) {
			return false;
		}
	}

	// method called when paying with cash
	public void payCash(Beverages b) throws InputMismatchException, ProductUnavailableException {
		Scanner scan = new Scanner(System.in);
		double balance = 0; // initial balance
		do {
			System.out.println("Insert credit");
			balance += scan.nextDouble(); // update balance
			if (balance >= b.getProductPrice()) { // if i get to the target price
				System.out.println("Operation successfull!");
				transaction(b); // delegate the actual transaction
				balance = 0; // this would give the change back to the user
				break; // quit, we're done here
			} else {
				System.out.println("Add more credit? Press 1 for yes, any other number"); // asking for more credit
				try {
					int choice = scan.nextInt(); // read int from console, might throw an exception if it's not an int
					if (choice == 1) // loop back
						continue;
					else {
						System.out.println("Goodbye!"); // quit
						balance = 0; // give back the change
						break;
					}
				} catch (InputMismatchException e) { // handle exception and go to the next iteration
					System.out.println("Press 1 for yes, anything else to quit");
					continue;
				}
			}
		} while (true); // don't need to update this, all cases are covered in the body
	}

	public void payCredit(Beverages b) throws RejectedCreditCardException, ProductUnavailableException { // Imagining user can pay with credit card
		credit = 20; // Hypotetical balance on credit card
		try {
		if (credit > b.getProductPrice()) // if credit card has enough money
			transaction(b); // delegate the transaction
		else {
			throw new RejectedCreditCardException("Transaction denied. Check card balance and retry."); // handling the
																										// case in which
																										// the card does
																										// not have
																										// enough money
		}} catch(RejectedCreditCardException e) {
			System.out.println(e.getMessage());
			return;
		}
	}

	public void transaction(Beverages b) throws ProductUnavailableException { // this method does all the house keeping
		if (quantityHelper(b)) { // check product is in stock
			setCredit(getCredit() - b.getProductPrice()); // if yes, proceed to update the balance, vending machine
															// change and product quantity
			vendingMachine.setChange(vendingMachine.getChange() + b.getProductPrice());
			b.setQuantity(b.getQuantity() - 1);
			System.out.println("Operation Successfull. new balance: " + getCredit());
		} else {
			System.out.println("Product is unavailable"); // case quantity lesser than or equal to 0
		}

	}

}
