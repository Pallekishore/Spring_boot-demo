package com.rgt.vehical;

import java.time.LocalDateTime;

public class Rental {
	private String id;
	  public void setId(String id) {
		this.id = id;
	}
	private Vehicle rentedVehicle;
	    private Customer customer;
	    private LocalDateTime startTime;
	    private LocalDateTime endTime;
		public Vehicle getRentedVehicle() {
			return rentedVehicle;
		}
		public void setRentedVehicle(Vehicle rentedVehicle) {
			this.rentedVehicle = rentedVehicle;
		}
		public Customer getCustomer() {
			return customer;
		}
		public void setCustomer(Customer customer) {
			this.customer = customer;
		}
		public LocalDateTime getStartTime() {
			return startTime;
		}
		public void setStartTime(LocalDateTime startTime) {
			this.startTime = startTime;
		}
		public LocalDateTime getEndTime() {
			return endTime;
		}
		public void setEndTime(LocalDateTime endTime) {
			this.endTime = endTime;
		}
		public Rental(Vehicle rentedVehicle, Customer customer, LocalDateTime startTime, LocalDateTime endTime) {
			super();
			this.rentedVehicle = rentedVehicle;
			this.customer = customer;
			this.startTime = startTime;
			this.endTime = endTime;
		}
		public Object getId() {
			// TODO Auto-generated method stub
			return null;
		}
		
	    //  other methods

}
