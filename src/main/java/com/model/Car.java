package com.model;

public class Car {
	private String registration;
	private String model;
	private String mark;
	private double price;

	public Car(String registration, String model, String mark, double price) {
		this.registration = registration;
		this.model = model;
		this.mark = mark;
		this.price = price;
	}

	public String toString() {
		return "Car [registration=" + registration + ", model=" + model + ", mark=" + mark + ", price=" + price + "]";
	}
}
