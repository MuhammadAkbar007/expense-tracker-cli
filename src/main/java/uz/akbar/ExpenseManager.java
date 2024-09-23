package uz.akbar;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * ExpenseManager
 */
public class ExpenseManager {

	// TODO: check loading data from file
	private List<Expense> expenses = new ArrayList<>();

	public void addExpense(String description, double amount) {
		if (!areParamsValid(description, amount)) {
			System.out.println("Please provide correct input ⌨️ ");
		} else {
			int id = -1;
			if (expenses.isEmpty()) {
				id = 1;
			} else {
				Expense lastExpense = expenses.get(expenses.size() - 1);
				id = lastExpense.getId() + 1;
			}

			Expense expense = new Expense(id, description, amount);
			expenses.add(expense);
			System.out.println("Expense added successfully ✅ (ID: " + expense.getId() + ")");
		}
	}

	public void updateExpense(int id, String newDescription, double newAmount) {
		if (!areParamsValid(newDescription, newAmount)) {
			System.out.println("Please provide correct input ⌨️ ");
		} else {
			Optional<Expense> optional = findExpenseById(id);
			if (optional.isPresent()) {
				Expense expense = optional.get();
				expenses.remove(expense);
				expenses.add(new Expense(id, newDescription, newAmount));
				System.out.println("Expense updated successfully ☑️  ");
			} else {
				System.out.println("Expense is found 🤷");
			}
		}
	}

	public void deleteExpense(int id) {
		Optional<Expense> optional = findExpenseById(id);
		if (optional.isPresent()) {
			expenses.remove(optional.get());
			System.out.println("Expense deleted successfully ❌");
		} else {
			System.out.println("Expense not found 🤷");
		}
	}

	public void printExpenses() {
		System.out.println("+--+--------------+--------------+---------+");
		System.out.println("| ID | Date       | Description  | Amount  |");
		System.out.println("+--+--------------+--------------+---------+");

		expenses.forEach(expense -> {
			System.out.printf("| %2d | %s | %-12s | $%7.2f |\n",
					expense.getId(), expense.getDate(), expense.getDescription(), expense.getAmount());
		});

		System.out.println("+--+--------------+--------------+---------+");
	}

	public void showSummary() {
		double total = expenses.stream().mapToDouble(Expense::getAmount).sum();
		System.out.printf("Total expenses: $%.2f\n", total);
	}

	public void showSummaryForMonth(int month) {
		if (month < 1 || month > 12) {
			System.out.println("Please, provide a valid month 📆");
		} else {
			double total = expenses.stream()
					.filter(exp -> exp.getDate().getMonthValue() == month)
					.mapToDouble(Expense::getAmount)
					.sum();
			System.out.printf("Total expenses for month %d, $%.2f\n", month, total);
		}
	}

	private Optional<Expense> findExpenseById(int id) {
		return expenses.stream().filter(expense -> expense.getId() == id).findFirst();
	}

	private boolean areParamsValid(String description, double amount) {
		return ((description != null && !description.isBlank()) && amount > 0);
	}
}
