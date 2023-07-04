package OnlineBiddingSystem;

//Observer Class
public class UserObserver implements Observer {
	private User user;

	public UserObserver(User user) {
		this.user = user;
	}

	public void update(Item item) {
		// Notify user of being out bid
		// Check if the user is the highest bidder
		if (item.getHighestBidder() != null && item.getHighestBidder().equals(user)) {
			System.out.println("You are the highest bidder for " + item.getName() + ".");
		} else {
			System.out.println("You have been outbid on item: " + item.getName());

		}
	}
}