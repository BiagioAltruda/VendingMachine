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
    	
    	// initial credit to 0? 
    	// initial change set to let`s say 100?
    	
    	this.credit = 0;
    	
    	catalogue = new TreeMap<>();
    	
//    	catalogue.put(null, null);
//    	catalogue.put(null, null);
//    	catalogue.put(null, null);
//    	catalogue.put(null, null);
//    	catalogue.put(null, null);
    	
    	
    }
    
    public TreeMap<Integer, Beverages> getCatalogue() {
    	return catalogue;
    }
    
    public void showProducts() {
    	
    	for(Integer key : catalogue.keySet())
    		System.out.println(catalogue.get(key));
    }
    

    public static Distributore getInstance() {
    	if( instance == null)
    		instance = new Distributore();
        return instance;
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
