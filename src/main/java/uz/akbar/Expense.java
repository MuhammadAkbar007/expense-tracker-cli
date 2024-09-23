package uz.akbar;

import java.time.LocalDate;

/**
 * Expense
 */
public class Expense {

	private int id;
	private String description;
	private double amount;
	private LocalDate date;

	public Expense(int id, String description, double amount, LocalDate date) {
		this.id = id;
		this.description = description;
		this.amount = amount;
		this.date = date;
	}

	public Expense(int id, String description, double amount) {
		this.id = id;
		this.description = description;
		this.amount = amount;
		this.date = LocalDate.now();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return String.format("ID: %d, Description: %s, Amount: $%.2f, Date: %s, ", id, description, amount, date);
	}
}
