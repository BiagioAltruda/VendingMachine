
public class Main {

	public static void main(String[] args) {
		
		Distributore.getInstance(); // Initialize vending machine and admin user
		Admin.getInstance();

		Distributore.getInstance().showProducts();
	}

}
