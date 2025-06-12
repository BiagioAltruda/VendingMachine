
public class Beverages {
	private String productName;
	private int productCode;
	private double productPrice;
	private int quantity;
	public Beverages(String productName, int productCode, double productPrice, int quantity) {
		super();
		this.productName = productName;
		this.productCode = productCode;
		this.productPrice = productPrice;
		this.quantity = quantity;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductCode() {
		return productCode;
	}
	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return productName + ", Code =" + productCode + ", Price = "
				+ productPrice + ", Quantity=" + quantity;
	}
	
	
}
