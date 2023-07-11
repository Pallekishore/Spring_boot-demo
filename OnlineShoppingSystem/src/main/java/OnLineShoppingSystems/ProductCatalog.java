package OnLineShoppingSystems;

import java.io.*;
import java.util.HashMap;

public class ProductCatalog {

	private HashMap<String, Product> products;

	public ProductCatalog() {
		products = new HashMap<String, Product>();
	}

	public void addProduct(Product product) {
		products.put(product.getName(), product);
	}

	public Product getProduct(String name) {
		return products.get(name);
	}

	public void saveProduct(String filename) {

		try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
			writer.toString();

			for (Product product : products.values()) {
				writer.println(product.getName() + "," + product.getDescription() + "," + product.getPrice() + ","
						+ product.getQuantity());
			}
			System.out.println("Product catalog saved successfully!");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error occure while saving product catalog: " + e.getMessage());
		}
	}

	public void loadProduct(String filename) {
		products.clear();
		try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
			String line;
			Product product = null;
			System.out.println("Product catalog Details");
			System.out.println("-----------------------------------------------------------------");
			while ((line = reader.readLine()) != null) {
				String[] data = line.split(",");
				if (data.length == 4) {
					String name = data[0];
					String description = data[1];
					double price = Double.parseDouble(data[2]);
					int quantity = Integer.parseInt(data[3]);
					product = new Product(name, price, quantity, description);
					addProduct(product);
				}
				if (product != null)
					System.out.println(product.toString());
				else
					System.out.println("Catalog File is Empty!");
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error loading product catalog: " + e.getMessage());

		} catch (NumberFormatException e) {
			System.out.println("Error loading product file: " + e.getMessage());
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Product product : products.values()) {
			sb.append(product.toString()).append("\n");
		}
		return sb.toString();
	}
}
