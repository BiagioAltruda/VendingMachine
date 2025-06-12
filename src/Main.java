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
		Distributore vendingMachine = Distributore.getInstance(); // working name variable for the instance
		RegularUser user = new RegularUser(null, 0);
		System.out.println("Vending Machine ready!"); // initialization done
		Scanner scan = new Scanner(System.in);

		do { // main loop
			System.out.println("Insert product code: ");
			String code = scan.next();
			if (code == Admin.getInstance().getAccessCode()) {
				PageSelector.adminProcess();
			} else
				PageSelector.regularUserProcess(Integer.parseInt(code));
		} while (true);
	}
}
