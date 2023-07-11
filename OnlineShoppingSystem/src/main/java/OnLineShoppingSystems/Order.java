package OnLineShoppingSystems;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static int nextConfirmationNumber = 1;
	private int confirmationNumber;
	private HashMap<Product, Integer> items;
	private double totalPrice;

	public int getConfirmationNumber() {
		return confirmationNumber = nextConfirmationNumber++;
	}

	public void setConfirmationNumber(int confirmationNumber) {
		this.confirmationNumber = confirmationNumber;
	}

	public HashMap<Product, Integer> getItems() {
		return items;
	}

	public void setItems(HashMap<Product, Integer> items) {
		this.items = items;
	}

	public double getTotalPrice() {
		
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Order() {
	}

	public Order(HashMap<Product, Integer> items, double totalPrice) {
		this.items = items;
		this.totalPrice = calculateTotalPrice();
	}

	public Order(HashMap<Product, Integer> items) {
	}
	private double calculateTotalPrice() {
		double totalPrice = 0;
		for (Map.Entry<Product, Integer> entry : items.entrySet()) {
			Product product = entry.getKey();
			int quantity = entry.getValue();
			totalPrice += product.getPrice() * quantity;
		}
		return totalPrice;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order Confirmation =  ").append(confirmationNumber).append("\n");
        sb.append("Order Items = \n");
        for (Product product : items.keySet()) {
            int quantity = items.get(product);
            sb.append("Product: ").append(product.getName()).append("\n");
            sb.append("Quantity: ").append(quantity).append("\n");
        }
			sb.append("Total Price =  $").append(totalPrice);
		return sb.toString();
	}

}
