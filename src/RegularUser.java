import java.util.*;

public class RegularUser extends User{
	
	private double credit;
	
	public RegularUser(String code, double credit) {
		//super(code);
		this.credit = credit;
	}
	
	// l`user ha un certo credito -> mette credito nel distributore, distributore credito += credito di user 
	void payCash() {
		
	
		
	}
	
	void payCredit() {
		
		
		
	} 
	
	
	void transazione(double creditoInserito) {
		setCredit(getCredit() - creditoInserito); // setto a 0 il credito, in teoria dovrebbe mandarlo al resto di Distributore e poi perdere TempChange
		Distributore.getInstance().setCredit(Distributore.getInstance().getCredit() + creditoInserito); // il distributore sputa fuori il resto
	}
	
	void resto(double tempChange) {
		Distributore.getInstance().setCredit(0);     // setto a 0 il credito, in teoria dovrebbe mandarlo al resto di Distributore e poi perdere TempChange
		setCredit(getCredit() + tempChange);         // il distributore sputa fuori il resto
	}
	
	// double insert credit 
	void insertCredit(Beverages b) {
		
		// variabile per contenere il valore del resto
		double tempChange;
		
		//se il check viene settato a true si esce dal loop
		boolean check = false;

		do {

			double creditoInserito; // quantita inserita dall`utente
			System.out.println("Quanto credito vuoi inserire nel Distributore?");
			Scanner s = new Scanner(System.in);
			creditoInserito = s.nextInt();
			
			transazione(creditoInserito); // i soldi che l`utente ha messo vanno nel distributore

			
			// se i soldi inseriti sono superiore o uguale al prezzo 
			if (creditoInserito >= b.getProductPrice()) {
				
				check = true;
				b.setQuantity(b.getQuantity() - 1); // quantita di quella bevanda -1 
				tempChange = creditoInserito - b.getProductPrice();  // calcolo resto
				
				resto(tempChange);
				// stampo quantità aggiornata del credito
				System.out.println("Credito aggiornato, adesso ti rimangono " + getCredit() + "€)");
			} 
			
			// la condizione per uscire dal loop è che il prodotto sia stato comprato oppure vuoi ritirarti
			if (getCredit() > 0 && !check) {

				do {
					Scanner s1 = new Scanner(System.in);
					System.out.print("Vuoi mettere altri soldi? (0 = no, choice>0 = si) ");
					int choice = s1.nextInt();

					// se non vuole ricaricare sputa fuori il resto.
					if (choice <= 0) {
						check = true;
						System.out.println("Erogazione resto: ");
						tempChange = creditoInserito - b.getProductPrice();
						resto(tempChange);
					}
					if (choice > 0) {
						
						System.out.println("Quanti soldi vuoi mettere?");
						creditoInserito = s.nextInt();
						transazione(creditoInserito);
						
						if (Distributore.getInstance().getCredit() >= b.getProductPrice()) {
							check = true;
							b.setQuantity(b.getQuantity() - 1);
							
							
							tempChange = Distributore.getInstance().getCredit() - b.getProductPrice();
							resto(tempChange);
						}
					}
				} while (!check);

			} else {
				Scanner s1 = new Scanner(System.in);
				System.out.println(	"Eroraccio! Non hai più soldi, vuoi ricaricare? (tanto sul programma è gratis, 0 per no, per x > 0 sium)?");
				int choice = s1.nextInt();
				if (choice <= 0) {
					tempChange = Distributore.getInstance().getCredit() - b.getProductPrice();
					resto(tempChange);
				}
				if(choice > 0)
				{
					System.out.println("mi so abboffat a uallera, tieni 200 euro ( credito ) ");
					setCredit(getCredit() + 200);
				}

			}

		} while (!check);

	}


	public double getCredit() {
		return credit;
	}


	public void setCredit(double credit) {
		this.credit = credit;
	}
	
	
	
	
}
