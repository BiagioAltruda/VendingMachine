import java.util.TreeMap;

public class Distributore {
    
	
	TreeMap<Integer, Beverages> catalogue; 
	private double change;
	private double credit; 
	
	
    private Distributore(double credit, double change) {
    	
    	// initial credit to 0? 
    	// initial change set to let`s say 100?
    	
    	this.credit = 0;
    	this.change = change;
    	
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
    
    
    
    private static class DistributoreA {
        private static final Distributore INSTANCE = new Distributore(100.0, 0.0);
    }

    public static Distributore getInstance() {
        return DistributoreA.INSTANCE;
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
