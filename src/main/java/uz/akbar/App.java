package uz.akbar;

/**
 * Hello world!
 *
 */
public class App {
	static ExpenseManager manager = new ExpenseManager();

	public static void main(String[] args) {
		if (args.length <= 0) {
			System.out.println("Please provide correct command 🤌");
			return;
		}

		String command = args[0].toLowerCase();
		switch (command) {
			case "add":
				handleAddCommand(args);
				break;

			case "update":
				handleUpdateCommand(args);
				break;
			case "list":
				handleListCommand();
				break;

			case "delete":
				handleDeleteCommand(args);
				break;

			case "summary":
				handleSummaryCommand(args);
				break;

			case "export":
				handleExport();
				break;

			default:
				System.out.println("Unknown command: " + command + " 🤷");
				break;
		}
	}

	private static void handleAddCommand(String[] args) {
		String description = null;
		double amount = 0;

		try {
			for (int i = 0; i < args.length; i++) {
				if ("--description".equals(args[i])) {
					description = args[i + 1];
				} else if ("--amount".equals(args[i])) {
					amount = Double.parseDouble(args[i + 1]);
				}
			}
		} catch (Exception e) {
			System.out.println("Wrong input! 🙅");
		}

		if (amount <= 0 || description == null) {
			System.out.println("Incorrect amount 💸");
		} else {
			manager.addExpense(description, amount);
		}
	}

	private static void handleUpdateCommand(String[] args) {
		try {
			int id = 0;
			String description = null;
			double amount = 0;

			if (args.length >= 5) {

				for (int i = 0; i < args.length; i++) {
					if ("--id".equals(args[i])) {
						id = Integer.parseInt(args[i + 1]);
					} else if ("--description".equals(args[i])) {
						description = args[i + 1];
					} else if ("--amount".equals(args[i])) {
						amount = Double.parseDouble(args[i + 1]);
					}
				}

				if (id == 0 || amount == 0 || description == null) {
					System.out.println("Please provide full information ℹ️");
				} else {
					manager.updateExpense(id, description, amount);
				}

			} else {
				System.out.println("Please provide full information to update ℹ️");
			}
		} catch (Exception e) {
			System.out.println("Wrong input! 🙅");
		}
	}

	private static void handleListCommand() {
		manager.printExpenses();
	}

	private static void handleDeleteCommand(String[] args) {
		if (args.length >= 3 && "--id".equals(args[1])) {
			try {
				int id = Integer.parseInt(args[2]);
				manager.deleteExpense(id);
			} catch (Exception e) {
				System.out.println("Wrong ID 🆔: " + args[2]);
			}
		} else {
			System.out.println("Please provide a valid ID 🆔");
		}
	}

	private static void handleSummaryCommand(String[] args) {
		if (args.length == 1) {
			manager.showSummary();
		} else if (args.length >= 2 && "--month".equals(args[1])) {
			int month = Integer.parseInt(args[2]);
			manager.showSummaryForMonth(month);
		}
	}

	private static void handleExport() {
		FileManager.exportToCSV();
	}

}
