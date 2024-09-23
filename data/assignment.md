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

