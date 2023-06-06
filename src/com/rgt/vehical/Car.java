package com.rgt.vehical;

public class Car extends Vehicle {
	private String carType;
	private String color;
	private String fuelType;

	private boolean have_truck;
	private int door_count;

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isHave_truck() {
		return have_truck;
	}

	public void setHave_truck(boolean have_truck) {
		this.have_truck = have_truck;
	}

	public int getDoor_count() {
		return door_count;
	}

	public void setDoor_count(int door_count) {
		this.door_count = door_count;
	}
	public Car(String licensePlate, String vehicleType, String make, String model, boolean isAvailable, String carType,
			String color, String fuelType, boolean have_truck, int door_count) {
		super(licensePlate, vehicleType, make, model, isAvailable);
		this.carType = carType;
		this.color = color;
		this.fuelType = fuelType;
		this.have_truck = have_truck;
		this.door_count = door_count;
	}

}
