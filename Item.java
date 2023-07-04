package OnlineBiddingSystem;

import java.util.ArrayList;
import java.util.List;

public class Item {
	private String name;
	private String description;
	private double currentHighestBid;
	private User highestBidder;
	private List<UserObserver> observers;

	public Item() {

	}

	public Item(String name, String description, double currentHighestBid) {
		super();
		this.name = name;
		this.description = description;
		this.currentHighestBid = currentHighestBid;
		// new add for outbid
		this.highestBidder = null;
		this.observers = new ArrayList<>();
	}

	public void placeBid(User user, double bidAmount) {
		if (bidAmount > currentHighestBid) {
			// Check if there is a previous highest bidder
			if (highestBidder != null) {
				// Notify the previous highest bidder that they have been outbid
				notifyOutbid(highestBidder);
			}

			currentHighestBid = bidAmount;
			highestBidder = user;
			user.addBid(new Bid(this, bidAmount));
			this.observers = new ArrayList<>();
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getCurrentHighestBid() {
		return currentHighestBid;
	}

	public void setCurrentHighestBid(double currentHighestBid) {
		this.currentHighestBid = currentHighestBid;
	}

	public User getHighestBidder() {
		return highestBidder;
	}

	public void setHighestBidder(User highestBidder) {
		this.highestBidder = highestBidder;
	}

	public void addObserver(UserObserver observer) {
		observers.add(observer);
	}

	public void removeObserver(UserObserver observer) {
		observers.remove(observer);
	}

	public void notifyOutbid(User user) {
		for (UserObserver observer : observers) {
			observer.update(this);
		}
	}

}
