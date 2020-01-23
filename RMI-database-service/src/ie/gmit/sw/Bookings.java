package ie.gmit.sw;

import java.io.Serializable;

public class Bookings implements Serializable {

	// Serializable Id
	private static final long serialVersionUID = 1L;

	// Private vars
	private int id;
	private int carID;
	private int customerID;
	private String dateStart;
	private String dateEnd;
	private String first;
	private String second;
	private int number;
	private String reg;
	private int year;
	private String make;
	private Double cost;

	// Null Constructor
	public Bookings() {

	}

	// Constructor
	public Bookings(int id, int carID, int customerID, String dateStart, String dateEnd, String first, String second,
			int number, String reg, int year, String make, Double cost) {
		super();
		this.id = id;
		this.carID = carID;
		this.customerID = customerID;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.first = first;
		this.second = second;
		this.number = number;
		this.reg = reg;
		this.year = year;
		this.make = make;
		this.cost = cost;
	}

	// Getters and setters
	public int getId() {
		return id;
	}

	public int getCarID() {
		return carID;
	}

	public int getCustomerID() {
		return customerID;
	}

	public String getDateStart() {
		return dateStart;
	}

	public String getDateEnd() {
		return dateEnd;
	}

	public String getFirst() {
		return first;
	}

	public String getSecond() {
		return second;
	}

	public int getNumber() {
		return number;
	}

	public String getReg() {
		return reg;
	}

	public int getYear() {
		return year;
	}

	public String getMake() {
		return make;
	}

	public Double getCost() {
		return cost;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCarID(int carID) {
		this.carID = carID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public void setDateStart(String dateStart) {
		this.dateStart = dateStart;
	}

	public void setDateEnd(String dateEnd) {
		this.dateEnd = dateEnd;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public void setSecond(String second) {
		this.second = second;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setReg(String reg) {
		this.reg = reg;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

}