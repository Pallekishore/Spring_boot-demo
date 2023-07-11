package OnLineShoppingSystems;

import java.io.Serializable;
import java.util.Objects;

class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String description;
	private double price;
	private int quantity;

	public Product(String name, double price, int quantity, String description) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	

	@Override
	public String toString() {
		return "Product [name=" + name + ", description=" + description + ", price=" + price + ", quantity=" + quantity
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, name, price, quantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass()||obj == null)
			return false;
		Product other = (Product) obj;
		return Objects.equals(description, other.description) && Objects.equals(name, other.name)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price) && quantity == other.quantity;
	}
}
