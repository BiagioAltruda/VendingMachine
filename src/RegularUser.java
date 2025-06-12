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
	
	
	
	// double insert credit 
	void insertCredit(Beverages b, Distributore d) {
		
		// se ci sono abbastanza soldi, scala il costo del prodotto dal credito dell`user, altrimenti stampa messaggio else case.
		
		if(getCredit() >= b.getProductPrice()) {
				
		setCredit(getCredit() - b.getProductPrice());
		d.setCredit(d.getCredit() + b.getProductPrice());
		
		System.out.println("Credito aggiornato, adesso ti rimangono " + getCredit() + "€)");
		}
		
		else {
			
			Scanner s = new Scanner(System.in);
			System.out.print("Vuoi ricaricare il tuo credito? (0 = no, choice > 0 = si) ");
			int choice = s.nextInt();
			 		
			if(choice > 0)
			{	
				System.out.println("Quanto credito vuoi ricaricare? ");
				int modifier = s.nextInt();
				setCredit(getCredit() + modifier);
				System.out.println("Credito aggiornato: " + getCredit());
			}
			
			
			
		}
		
		// if credito inferiore al costo 
		// vuoi ricaricare il tuo credito?
		
		// setCredito(getCredito + numero) modifier
		// 
		
			
		
		
		// credito del user - costo prodotto = credito aggiornato dell user 
		// se poi non basta metti am essaggio non tieni soldi 
		
	}


	public double getCredit() {
		return credit;
	}


	public void setCredit(double credit) {
		this.credit = credit;
	}
	
	
	
	
}
