import java.util.*;

public class RegularUser extends User {

	private double credit;

	public RegularUser(String code, double credit) { // Constructor
		// super(code);
		this.credit = credit;
	}

	// Getters and Setters
	public double getCredit() {
		return credit;
	}

	public void setCredit(double credit) {
		this.credit = credit;
	}

	public boolean quantityHelper(Beverages b) {
		if (b.getQuantity() > 0)
			return true;
		else
			return false;
	}

	// method called when paying with cash
	public void payCash(Beverages b) throws InputMismatchException {
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
						balance = 0; //give back the change
						break;
					}
				} catch (InputMismatchException e) { // handle exception and go to the next iteration
					System.out.println("Press 1 for yes, anything else to quit");
					continue;
				}
			}
		} while (true); // don't need to update this, all cases are covered in the body
	}

	public void payCredit(Beverages b) throws ArithmeticException { // Imagining user can pay with credit card
		credit = 20; // Hypotetical balance on credit card

		try {
			if (credit > b.getProductPrice()) // if credit card has enough money
				transaction(b); // delegate the transaction
		} catch (ArithmeticException e) { // handling the case in which the card does not have enough money
			System.out.println("Transaction denied. Check card balance and retry.");
		}
	}

	public void transaction(Beverages b) { // this method does all the house keeping
		if (quantityHelper(b)) { //check product is in stock
			setCredit(getCredit() - b.getProductPrice()); //if yes, proced to update the balance, vending machine change and product quantity
			Distributore.getInstance().setChange(Distributore.getInstance().getChange() + b.getProductPrice());
			b.setQuantity(b.getQuantity() - 1);
			System.out.println("Operation Successfull. new balance: " + getCredit());
		} else {
			System.out.println("Product is anavailable"); // case quantity lesser than or equal to 0
		}

	}

	public void transazione(double creditoInserito) {
		setCredit(getCredit() - creditoInserito); // setto a 0 il credito, in teoria dovrebbe mandarlo al resto di
													// Distributore e poi perdere TempChange
		Distributore.getInstance().setCredit(Distributore.getInstance().getCredit() + creditoInserito); // il
																										// distributore
																										// sputa fuori
																										// il resto
	}

	void resto(double tempChange) {
		Distributore.getInstance().setCredit(0); // setto a 0 il credito, in teoria dovrebbe mandarlo al resto di
													// Distributore e poi perdere TempChange
		setCredit(getCredit() + tempChange); // il distributore sputa fuori il resto
	}

}

/*
 * void insertCredit(Beverages b) {
 * 
 * // variabile per contenere il valore del resto double tempChange;
 * 
 * //se il check viene settato a true si esce dal loop boolean check = false;
 * 
 * do {
 * 
 * double creditoInserito; // quantita inserita dall`utente
 * System.out.println("Quanto credito vuoi inserire nel Distributore?"); Scanner
 * s = new Scanner(System.in); creditoInserito = s.nextInt();
 * 
 * transazione(creditoInserito); // i soldi che l`utente ha messo vanno nel
 * distributore
 * 
 * 
 * // se i soldi inseriti sono superiore o uguale al prezzo if (creditoInserito
 * >= b.getProductPrice()) {
 * 
 * check = true; b.setQuantity(b.getQuantity() - 1); // quantita di quella
 * bevanda -1 tempChange = creditoInserito - b.getProductPrice(); // calcolo
 * resto
 * 
 * resto(tempChange); // stampo quantità aggiornata del credito
 * System.out.println("Credito aggiornato, adesso ti rimangono " + getCredit() +
 * "€)"); }
 * 
 * // la condizione per uscire dal loop è che il prodotto sia stato comprato
 * oppure vuoi ritirarti if (getCredit() > 0 && !check) {
 * 
 * do { Scanner s1 = new Scanner(System.in);
 * System.out.print("Vuoi mettere altri soldi? (0 = no, choice>0 = si) "); int
 * choice = s1.nextInt();
 * 
 * // se non vuole ricaricare sputa fuori il resto. if (choice <= 0) { check =
 * true; System.out.println("Erogazione resto: "); tempChange = creditoInserito
 * - b.getProductPrice(); resto(tempChange); } if (choice > 0) {
 * 
 * System.out.println("Quanti soldi vuoi mettere?"); creditoInserito =
 * s.nextInt(); transazione(creditoInserito);
 * 
 * if (Distributore.getInstance().getCredit() >= b.getProductPrice()) { check =
 * true; b.setQuantity(b.getQuantity() - 1);
 * 
 * 
 * tempChange = Distributore.getInstance().getCredit() - b.getProductPrice();
 * resto(tempChange); } } } while (!check);
 * 
 * } else { Scanner s1 = new Scanner(System.in); System.out.println(
 * "Eroraccio! Non hai più soldi, vuoi ricaricare? (tanto sul programma è gratis, 0 per no, per x > 0 sium)?"
 * ); int choice = s1.nextInt(); if (choice <= 0) { tempChange =
 * Distributore.getInstance().getCredit() - b.getProductPrice();
 * resto(tempChange); } if(choice > 0) {
 * System.out.println("mi so abboffat a uallera, tieni 200 euro ( credito ) ");
 * setCredit(getCredit() + 200); }
 * 
 * }
 * 
 * } while (!check);
 * 
 * }
 */