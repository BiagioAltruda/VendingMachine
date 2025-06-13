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
		
		RegularUser user = new RegularUser();
		System.out.println("Vending Machine ready!"); // initialization done
		Scanner scan = new Scanner(System.in);

		do { // main loop
			System.out.println("Insert product code: ");
			int code = scan.nextInt();		//reading code
			if (code == Admin.getInstance().getAccessCode()) { //accessing to the correct pages
				PageSelector.adminProcess();
			} else
				PageSelector.regularUserProcess(code);
		} while (true);
	}
}
