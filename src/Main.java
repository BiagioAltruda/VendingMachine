import java.util.Map.Entry;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try {
			Distributore.getInstance(); // Initialize vending machine and admin user
			Admin.getInstance();
		} catch (Exception e) { // handling special case
			System.out.println("Could not initialize necessary classes");
			e.getMessage();
		}
		Distributore vendingMachine = Distributore.getInstance();
		RegularUser user = new RegularUser(null, 0);
		System.out.println("Vending Machine ready!"); // initialization done
		Scanner scan = new Scanner(System.in);

		do { // main loop
			System.out.println("Insert product code: ");
			String code = scan.next();
			if (code == Admin.getInstance().getAccessCode()) {
				//ADMIN PAGE
			} else {
				Beverages b = vendingMachine.getCatalogue().get(code);
				if (b != null) {
					System.out.println("Do you want to pay with credit or cash? \n select 1 for credit or 2 for cash");
					int method = scan.nextInt();
					if (method == 1)
						user.payCredit(b);
					else if (method == 2)
						user.payCash(b);
					else {
						System.out.println("Insert valid option. Retry");
						continue;
					}
				} else {
					System.out.println("Insert a valid code");
					continue;
				}
			}
		} while (true);
	}
}
