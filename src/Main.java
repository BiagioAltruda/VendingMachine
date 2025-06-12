import java.util.Map.Entry;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try {
		Distributore.getInstance(); // Initialize vending machine and admin user
		Admin.getInstance();
		RegularUser user = new RegularUser(null,0);
		} catch(Exception e) { //handling special case
			System.out.println("Could not initialize necessary classes");
			e.getMessage();
		}
		System.out.println("Vending Machine ready!");
		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("Insert product code: ");
			String code = scan.next();
			if (code.equals(Admin.getInstance().getAccessCode())) {
				//Initialize management interface
			}
			else {
				for(Entry<Integer, Beverages> item: Distributore.getInstance().getCatalogue().entrySet()) {
					//if (item)
				}
			}
		} while(true);
	}

}
