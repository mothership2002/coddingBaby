package java.test7;

public class Shop {
	private Product product;
	private Employee emp;
	
	public Shop(Product p) {
		this.emp = new Employee();
		this.product = p;
	}
}
