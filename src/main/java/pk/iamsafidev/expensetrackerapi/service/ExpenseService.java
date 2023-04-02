package pk.iamsafidev.expensetrackerapi.service;

import pk.iamsafidev.expensetrackerapi.entity.Expense;

import java.util.List;

public interface ExpenseService {
    List<Expense> getAllExpenses();
}
