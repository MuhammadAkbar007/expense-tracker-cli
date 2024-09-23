# Expense Tracker CLI

## Description
A simple command-line tool to manage personal expenses 💸,
allowing users to add ✅, update 🔄, delete 🗑, and view expenses 🫣.
It also supports exporting expenses to a CSV file 📄 for external use.
The project is built using Java ☕️ (Maven 🪶).

## Features
* Add, update, and delete expenses with descriptions and amounts.
* View a summary of all expenses or filter by month.
* Export expenses to a CSV file.
* Persistent storage of expenses in a JSON file.

## Installation
1. Clone the Repository:
```bash
git clone https://github.com/MuhammadAkbar007/expense-tracker-cli.git
cd expense-tracker-cli
```
2. Build the Project:
- [x] Make sure you have Maven installed, then run:
```bash
mvn clean package
```
This will create a JAR file in the `target` directory.
3. Run the Application:
```bash
java -jar target/expense-tracker-cli-1.0-SNAPSHOT-jar-with-dependencies.jar
```
## Usage
# Add Expense
```bash
$ expense-tracker add --description "Lunch" --amount 20
```
`Expense added successfully (ID: 1)`

# Update Expense
```bash
$ expense-tracker update --id 1 --description "Dinner" --amount 25
```
`Expense updated successfully (ID: 1)`

# Delete Expense
```bash
$ expense-tracker delete --id 1
```
`Expense deleted successfully`

# View All Expenses
```bash
$ expense-tracker list
```
| ID | Date | Description | Amount |
|---|------------|-------|-----|
| 1 | 2024-08-06 | Lunch | $20 |
| 2 | 2024-08-06 | Dinner | $10 |

# Total Expense Summary for All
```bash
$ expense-tracker summary
```
`Total expenses: $30`

# Total Expense Summary for Month
```bash
$ expense-tracker summary --month 8
```
`Total expenses for August: $20`

# Export Data to CSV File
```bash
$ expense-tracker export
```
`CSV file is exported to /data foler`

## Project structure
* `src/main/java/`: Contains the main application source code.
* `data/`: Contains JSON and CSV files.
* `target/`: Contains the compiled output and the JAR file.

## Project idea
The idea is taken from [Roadmap](https://roadmap.sh/) projects for beginners [task](https://roadmap.sh/projects/expense-tracker)

## Author
Created by [Akbar](https://github.com/MuhammadAkbar007).
