package ie.gmit.sw;

import java.io.Serializable;

public class Customer implements Serializable {

	// Serializable Id
	private static final long serialVersionUID = 1L;

	// Private vars
	private int id;
	private String first;
	private String second;
	private int number;

	// Null Constructor
	public Customer() {

	}

	// Constructor
	public Customer(int id, String first, String second, int number) {
		this.id = id;
		this.first = first;
		this.second = second;
		this.number = number;
	}

	// Getters and setters
	public int getId() {
		return id;
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

	public void setId(int id) {
		this.id = id;
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

}