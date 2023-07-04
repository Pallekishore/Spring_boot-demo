package OnlineBiddingSystem;

public class Bid {
	private Item item;
	private User bidder;
	private double amount;
	private boolean winningBid;

	public Bid(User bidder, Item item, double amount) {
		this.bidder = bidder;
		this.item = item;
		this.amount = amount;
		this.winningBid = false;
		bidder.addBid(this); // Add the bid to the user's bidding history
	}

	public Bid(Item item, double amount) {
		this.item = item;
		this.amount = amount;
		System.out.println("test the Bid is calling");
	}

	public Item getItem() {
		return item;
	}

	public double getAmount() {
		return amount;
	}

	public boolean isWinningBid() {
		/*
		 * if (bids.isEmpty()) { return null; }
		 * 
		 * Bid winningBid = bids.get(0); for (int i = 1; i < bids.size(); i++) { if
		 * (bids.get(i).getBidAmount() > winningBid.getBidAmount()) { winningBid =
		 * bids.get(i); } }
		 */
		  
		  return winningBid;
	}

	public void setWinningBid(boolean winningBid) {
		this.winningBid = winningBid;
	}
	
}
