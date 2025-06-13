import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.TreeMap;

public class Distributore {
    
	
	public TreeMap<Integer, Beverages> catalogue; 

	
	
	public void setCatalogue(TreeMap<Integer, Beverages> catalogue) {
		this.catalogue = catalogue;
	}
	

	private double change = 100;
	private double credit; 
	
	public static Distributore instance;
	
    private Distributore() {
    	
    	this.credit = 0;
    	
    	catalogue = new TreeMap<>();
    	
    	catalogue.put(1, new Beverages ("Caffè", 1, 1, 5));
    	catalogue.put(2, new Beverages ("Acqua", 2, 0.5, 2));
    	catalogue.put(3, new Beverages ("Cioccolata Calda", 3, 2, 1));
    	catalogue.put(4, new Beverages ("Decaffeinato", 4, 0.7, 0));
    	catalogue.put(5, new Beverages ("Cappuccino", 5, 1.5, 4));
    	
    }
    
    public static Distributore getInstance() {
    	if( instance == null)
    		instance = new Distributore();
    	return instance;
    }
    
    public TreeMap<Integer, Beverages> getCatalogue() {
    	return catalogue;
    }
    
    public void showProducts() {
    	
    	for(Integer key : catalogue.keySet())
    		System.out.println(catalogue.get(key));
    }
    
	public double getChange() {
		return change;
	}


	public void setChange(double change) {
		this.change = change;
	}


	public double getCredit() {
		return credit;
	}


	public void setCredit(double credit) {
		this.credit = credit;
	}
	
	public void run() throws InputMismatchException, ProductUnavailableException {
		
		Scanner scan = new Scanner(System.in);
		do { // main loop
			Admin.getInstance().productsData();
			System.out.println("Insert product code: ");
			int code = scan.nextInt();		//reading code
			if (code == Admin.getInstance().getAccessCode()) { //accessing to the correct pages
				PageSelector.adminProcess();
			} else
				PageSelector.regularUserProcess(code);
		} while (true);
		
	}
}
