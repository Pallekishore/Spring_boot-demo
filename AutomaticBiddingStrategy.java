package OnlineBiddingSystem;

public class AutomaticBiddingStrategy implements BiddingStrategy {
	private double maxBidAmount;
	private double incrementValue;

	public AutomaticBiddingStrategy(double maxBidAmount, double incrementValue) {
		this.maxBidAmount = maxBidAmount;
		this.incrementValue = incrementValue;
	}
	@Override
	public double bid(Item item, User user) {
		// Implement automatic bidding strategy
		double currentBid = item.getCurrentHighestBid();
		double newBid = currentBid + incrementValue;
		while (newBid <= maxBidAmount) {
			item.placeBid(user, newBid);
			currentBid = newBid;
			newBid += incrementValue;
		}
		return newBid;
	}

}
