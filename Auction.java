package OnlineBiddingSystem;

import java.util.ArrayList;
import java.util.List;

//Singleton Class
public class Auction {
	private static Auction instance = null;
	private List<Item> items;

	private Auction() {
		items = new ArrayList<>();
	}

	public static Auction getInstance() {
		if (instance == null) {
			instance = new Auction();
		}
		return instance;
	}

	public void addItem(Item item) {
		items.add(item);
	}

//setters and getters
	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public static void setInstance(Auction instance) {
		Auction.instance = instance;
	}

}
