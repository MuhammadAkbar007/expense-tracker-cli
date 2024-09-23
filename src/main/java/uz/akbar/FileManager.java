package uz.akbar;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

/**
 * FileManager
 */
public class FileManager {
	private static final String JSON_PATH = "data/expenses.json";
	private static final String CSV_PATH = "data/expenses.csv";
	private static ObjectMapper mapper = new ObjectMapper();

	static {
		mapper.registerModule(new JavaTimeModule());
	}

	public static List<Expense> loadExpenses() {
		try {
			File file = new File(JSON_PATH);
			if (file.exists()) {
				return mapper.readValue(file,
						mapper.getTypeFactory().constructCollectionType(List.class, Expense.class));
			} else {
				return new ArrayList<>();
			}
		} catch (IOException e) {
			return new ArrayList<>();
		}
	}

	public static boolean saveExpenses(List<Expense> expenses) {
		try {
			mapper.writerWithDefaultPrettyPrinter().writeValue(new File(JSON_PATH), expenses);
			return true;
		} catch (Exception e) {
			System.out.println("Error saving data 🤷");
			e.printStackTrace();
			return false;
		}
	}

	public static void exportToCSV() {
		List<Expense> expenses = loadExpenses();

		if (expenses.isEmpty()) {
			System.out.println("Expenses are not added yet! 🙅");
		} else {
			File csvFile = new File(CSV_PATH);

			try (FileWriter writer = new FileWriter(csvFile)) {
				writer.write("ID,Description,Amount,Date\n");

				for (Expense expense : expenses) {
					writer.write(expense.getId() + "," +
							escapeCSV(expense.getDescription()) + "," +
							expense.getAmount() + "," +
							expense.getDate() + "\n");
				}

				System.out.println("Expenses exported successfully to " + CSV_PATH + " ✅");
			} catch (Exception e) {
				System.out.println("Something went wrong while exporting to csv 🤷");
			}

		}
	}

	private static String escapeCSV(String value) {
		if (value.contains(",") || value.contains("\"")) {
			value = value.replace("\"", "\"\"");
			return "\"" + value + "\"";
		}
		return value;
	}
}
