package pk.iamsafidev.expensetrackerapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pk.iamsafidev.expensetrackerapi.entity.Expense;

import java.util.Date;
import java.util.List;

public interface ExpenseService {
    Page<Expense> getAllExpenses(Pageable page);
    Expense getExpenseById(Long id);

    void deleteExpenseById(Long id);

    Expense saveExpenseDetails(Expense expense);

    Expense updateExpenseDetails(Long id, Expense expense);

    List<Expense> readByCategory(String category, Pageable pageable);

    List<Expense> readByName(String name, Pageable pageable);

    List<Expense> readByDate(Date startDate, Date endDate, Pageable pageable);
}
