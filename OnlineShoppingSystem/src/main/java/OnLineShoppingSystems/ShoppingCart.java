package OnLineShoppingSystems;

import java.util.HashMap;
import java.util.Map;

class ShoppingCart {
	private HashMap<Product, Integer> items;

	public ShoppingCart() {
		items = new HashMap<Product, Integer>();
	}

	public void addItem(Product product, int quantity) {
		if (items.containsKey(product)) {
			int existingQuantity = items.get(product);
			items.put(product, existingQuantity + quantity);
		} else {
			items.put(product, quantity);
		}
		// items.put(product, items.getOrDefault(product, 0) + quantity);
	}

	public void removeItem(Product product) {
		items.remove(product);
	}

	public double getTotalPrice() {
		double totalPrice = 0.0;
		for (Product product : items.keySet()) {
			int quantity = items.get(product);
			totalPrice += product.getPrice() * quantity;
		}
//		for (Map.Entry<Product, Integer> entry : getItems().entrySet()) {
//            Product product = entry.getKey();
//            int quantity = entry.getValue();
//			totalPrice += product.getPrice() * quantity;
//		}
		return totalPrice;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<Product, Integer> entry : items.entrySet()) {
			Product product = entry.getKey();
			int quantity = entry.getValue();
			sb.append(product.getName()).append(" x ").append(quantity).append("\n");
		}
		return sb.toString();
	}

	public HashMap<Product, Integer> getItems() {
		return items;
	}

	public void setItems(HashMap<Product, Integer> items) {
		this.items = items;
	}
	public void clearCart() {
		items.clear();
	}

}
