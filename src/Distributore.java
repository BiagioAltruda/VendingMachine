import java.util.TreeMap;

public class Distributore {
    
	
	public TreeMap<Integer, Beverages> catalogue; 
	private double change;
	private double credit; 
	
	private static Distributore instance;
	
	public static Distributore getInstance () {
		if (instance == null)
			instance = new Distributore();
		return instance;
	}
	
    private Distributore() {
    	catalogue = new TreeMap<>();
    	
//    	catalogue.put(null, null);
//    	catalogue.put(null, null);
//    	catalogue.put(null, null);
//    	catalogue.put(null, null);
//    	catalogue.put(null, null);
    	
    }
    
    
    public void showProducts() {
    	
    	for(Integer key : catalogue.keySet())
    		System.out.println(catalogue.get(key));
    }
    
    


	public TreeMap<Integer, Beverages> getCatalogue() {
		return catalogue;
	}

	public void setCatalogue(TreeMap<Integer, Beverages> catalogue) {
		this.catalogue = catalogue;
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

    
    
}
