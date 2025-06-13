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

		Distributore.getInstance().run();
		
	}
}
