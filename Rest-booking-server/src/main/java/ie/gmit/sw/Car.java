package ie.gmit.sw;

import java.io.Serializable;

public class Car implements Serializable {

	// Serializable Id
	private static final long serialVersionUID = 1L;

	// Private vars
	private int id;
	private String reg;
	private int Year;
	private String Make;
	private Double cost;

	// Null Constructor
	public Car() {

	}

	// Constructor
	public Car(int id, String reg, int year, String make, Double cost) {
		this.id = id;
		this.reg = reg;
		this.Year = year;
		this.Make = make;
		this.cost = cost;
	}

	// Getters and setters
	public int getId() {
		return id;
	}

	public String getReg() {
		return reg;
	}

	public int getYear() {
		return Year;
	}

	public String getMake() {
		return Make;
	}

	public Double getCost() {
		return cost;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setReg(String reg) {
		this.reg = reg;
	}

	public void setYear(int year) {
		Year = year;
	}

	public void setMake(String make) {
		Make = make;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

}