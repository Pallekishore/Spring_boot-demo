package OnLineShoppingSystems;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class OnlineShopping {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ShoppingCart cart = new ShoppingCart();
		ProductCatalog productCatalog = new ProductCatalog();
		OrderHistory orderHistory = new OrderHistory();
		System.out.println("Welcome to Online System");
		System.out.println("---------------------------------------------------------------");
		while (true) {
			System.out.print("Do you want to load an existing product file (Y/N)? ");
			String loadOption = scanner.nextLine().trim().toUpperCase();
			if (loadOption.equals("N")) {
				// Create a new product file
				System.out.print("Enter the file name to save the product catalog to: ");
				String filename = scanner.nextLine().trim();
				productCatalog.saveProduct(filename);

			} else {
				String fileName = "";
				// Load an existing product file
				System.out.print("Enter the file name to load the product catalog from: ");
				fileName = scanner.nextLine().trim();
				productCatalog.loadProduct(fileName);
				while (true) {
					System.out.println("\nMenu:");
					System.out.println("1. Add product");
					System.out.println("2. Add a product to the cart");
					System.out.println("3. Remove a product from the cart");
					System.out.println("4. View cart items");
					System.out.println("5. Place an order");
					System.out.println("6. View Order History");
					System.out.println("7. Save order history");
					System.out.println("8. Load order history");
					System.out.println("0. Exit");
					System.out.print("Enter your choice: ");
					int choice = scanner.nextInt();
					scanner.nextLine();
					switch (choice) {
					case 1:
						addProduct(scanner, productCatalog);
						productCatalog.saveProduct(fileName);
						break;
					case 2:
						addProductToCart(scanner, cart, productCatalog);
						break;
					case 3:
						removeProductToCart(scanner, cart, productCatalog);
						break;
					case 4:
						viewCart(cart);
						break;
					case 5:
						placeOrder(productCatalog, cart, orderHistory);
						break;
					case 6:
						viewOrderHistory(orderHistory);
						break;
					case 7:
						saveOrderHistory(scanner, orderHistory);
						break;
					case 8:
						loadOrderHistory(scanner, orderHistory);
						break;
					case 0:
						System.out.println("Exit");
						return;
					case 11:
						System.out.println("Thank you for using the Online Shopping System. Goodbye!");
						System.exit(0);
					default:
						System.out.println("Invalid choice. Please try again.");
					}
				}
			}
		}
	}

	private static void addProduct(Scanner scanner, ProductCatalog productCatalog) {
		System.out.println("Enter Product Name");
		String name = scanner.next();
		System.out.println("Enter Description");
		String description = scanner.next();
		System.out.println("Enter Price");
		double price = scanner.nextDouble();
		System.out.println("Enter Quantity");
		int quantity = scanner.nextInt();
		try {
			Product product = new Product(name, price, quantity, description);
			productCatalog.addProduct(product);
			System.out.println("Product added successfully");
		} catch (Exception e) {
			System.out.println("Error occure While adding Product");
		}

	}

	private static void addProductToCart(Scanner scanner, ShoppingCart cart, ProductCatalog productCatalog) {
		System.out.print("Enter the Product Name to add: ");
		String productName = scanner.nextLine();
		Product product = productCatalog.getProduct(productName);
		if (product != null) {
			System.out.print("Enter Quantity: ");
			int quantity = scanner.nextInt();
			if (quantity > 0 && quantity <= product.getQuantity()) {
				cart.addItem(product, quantity);
				System.out.println("Product Name=" + product.getName() + "   Quantity=" + quantity);
				System.out.println("Product added to the shopping cart.");
			} else {
				System.out.println("Insufficient quantity available for product: " + product.getName());
			}
		} else {
			System.out.println("Product not found.");
		}
	}

	private static void removeProductToCart(Scanner scanner, ShoppingCart cart, ProductCatalog productCatalog) {
		HashMap<Product, Integer> items = cart.getItems();
		if (items.isEmpty()) {
			System.out.println("The Shopping Cart is empty.");
			return;
		}
		System.out.print("\nEnter the Product Name to remove form Cart: ");
		String productName = scanner.nextLine();
		Product product = productCatalog.getProduct(productName);
		if (product != null) {
			cart.removeItem(product);
			System.out.println("Product removed from the shopping cart!");
		} else {
			System.out.println("Product not found in the shopping cart!");
		}
	}

	private static void viewCart(ShoppingCart shoppingCart) {
		HashMap<Product, Integer> items = shoppingCart.getItems();
		if (items.isEmpty()) {
			System.out.println("The cart is empty.");
		} else {
			System.out.println("Shopping Cart Items:");
			for (Map.Entry<Product, Integer> entry : items.entrySet()) {
				Product product = entry.getKey();
				int quantity = entry.getValue();
				System.out.println(product.getName() + " (Quantity = " + quantity + ")");
			}
			System.out.println("Total Price: $" + shoppingCart.getTotalPrice());
		}
	}

	private static void placeOrder(ProductCatalog productCatalog, ShoppingCart shoppingCart,
			OrderHistory orderHistory) {
		HashMap<Product, Integer> items = shoppingCart.getItems();
		if (items.isEmpty()) {
			System.out.println("The cart is empty. Please add products to the cart before placing an order.");
			return;
		} else {
			System.out.println("Placing Order...");
			double price = 0.0;
			String name = "";
			for (Map.Entry<Product, Integer> entry : items.entrySet()) {
				Product product = entry.getKey();
				int quantity = entry.getValue();
				price += product.getPrice();
				name = entry.toString();
				product.setQuantity(product.getQuantity() - quantity);
			}
			Order order = new Order();
			order.setItems(items);
			order.setTotalPrice(price);
			orderHistory.addOrder(order);
			shoppingCart.getItems();
			System.out.println("Order placed successfully!");
			System.out.println("Confirmation Number: " + order.getConfirmationNumber());
			System.out.println("Total Price: $" + order.getTotalPrice());
			shoppingCart.clearCart();
		}

	}

	private static void viewOrderHistory(OrderHistory orderHistory) {
		System.out.println("---------------------------");
             List<Order> ordersList=orderHistory.getAllOrders();
		if (ordersList.isEmpty()) {
			System.out.println("Order details is empty");
		} else {
			System.out.println("Order history:");
			for (Order orders : ordersList) {
				System.out.println(orders);
				System.out.println("------------------------------------------------------------");
			}
		}

	}

	private static void saveOrderHistory(Scanner scanner, OrderHistory orderHistory) {
		System.out.println("Enter a file name to save the order history: ");
		String fileName = scanner.nextLine();
		orderHistory.saveOrderHistory(fileName);

	}

	private static void loadOrderHistory(Scanner scanner, OrderHistory orderHistory) {
		System.out.print("\nEnter a file name to load the order history: ");
		String fileName = scanner.nextLine();
		orderHistory.loadOrderHistory(fileName);
	}
}
