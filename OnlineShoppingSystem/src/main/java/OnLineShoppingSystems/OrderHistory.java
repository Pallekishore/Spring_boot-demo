package OnLineShoppingSystems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderHistory {
	private ArrayList<Order> orders;

	public OrderHistory() {
		orders = new ArrayList<>();
	}

	public ArrayList<Order> getAllOrders() {
		return orders;
	}

	public void addOrder(Order order) {
		orders.add(order);
	}

	public void saveOrderHistory(String filename) {
		try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
			for (Order order : orders) {
				writer.println(order.getConfirmationNumber() + "," + order.getTotalPrice());
				// writer.println(order.getConfirmationNumber() + "," + order.getItems() + "," +
				// order.getTotalPrice());
			}
			System.out.println("Order history saved successfully!");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error saving order history: " + e.getMessage());

		}
	}

	public void loadOrderHistory(String filename) {
		System.out.println("---------------------------");
		try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
			HashMap<String, String> hashMap = new HashMap<String, String>();

			String line;
			while ((line = reader.readLine()) != null) {
				String[] keyValue = line.split(",");
				if (keyValue.length == 2) {
					String key = keyValue[0].trim();
					String value = keyValue[1].trim();
					hashMap.put(key, value);
					System.out.println("Confirmation Number=" + key + ",  Total Price=" + value);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error loading order history: " + e.getMessage());

		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Order order : orders) {
			sb.append(order.toString()).append("\n");
		}
		return sb.toString();
	}
	
}
