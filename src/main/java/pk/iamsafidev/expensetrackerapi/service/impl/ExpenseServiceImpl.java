package pk.iamsafidev.expensetrackerapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pk.iamsafidev.expensetrackerapi.entity.Expense;
import pk.iamsafidev.expensetrackerapi.exceptions.ResourceNotFoundException;
import pk.iamsafidev.expensetrackerapi.repository.ExpenseRepository;
import pk.iamsafidev.expensetrackerapi.service.ExpenseService;
import pk.iamsafidev.expensetrackerapi.service.UserService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private UserService userService;
    @Override
    public Page<Expense> getAllExpenses(Pageable page) {
        // For Pagination
        //expenses?size=2&page=2

        //    For Sorting
        //expenses?sort=amount,desc
        return expenseRepository.findByUserId(userService.getLoggedInUser().getId(),page);
    }

    @Override
    public Expense getExpenseById(Long id) {
        Optional<Expense> expense = expenseRepository.findByUserIdAndId(userService.getLoggedInUser().getId(),id);
        if (expense.isPresent()) {
            return expense.get();
        }
        throw new ResourceNotFoundException("Expense is not found for id " + id);
    }

    @Override
    public void deleteExpenseById(Long id) {
        Expense expense = getExpenseById(id);
        expenseRepository.delete(expense);
    }

    @Override
    public Expense saveExpenseDetails(Expense expense) {
        expense.setUser(userService.getLoggedInUser());
        return expenseRepository.save(expense);
    }

    @Override
    public Expense updateExpenseDetails(Long id, Expense expense) {
        Expense existingExpense = getExpenseById(id);
        existingExpense.setName(expense.getName() != null ? expense.getName() : existingExpense.getName());
        existingExpense.setDescription(expense.getDescription() != null ? expense.getDescription() : existingExpense.getDescription());
        existingExpense.setCategory(expense.getCategory() != null ? expense.getCategory() : existingExpense.getCategory());
        existingExpense.setAmount(expense.getAmount() != null ? expense.getAmount() : existingExpense.getAmount());
        existingExpense.setDate(expense.getDate() != null ? expense.getDate() : existingExpense.getDate());
        return expenseRepository.save(existingExpense);
    }

    @Override
    public List<Expense> readByCategory(String category, Pageable pageable) {
        return expenseRepository.findByUserIdAndCategory(userService.getLoggedInUser().getId(),category, pageable).toList();
    }

    @Override
    public List<Expense> readByName(String name, Pageable pageable) {
        return expenseRepository.findByUserIdAndNameContaining(userService.getLoggedInUser().getId(),name, pageable).toList();
    }

    @Override
    public List<Expense> readByDate(Date startDate, Date endDate, Pageable pageable) {
        if (startDate == null)
            startDate = new Date(0);
        if (endDate == null)
            endDate = new Date(System.currentTimeMillis());
        return expenseRepository.findByUserIdAndDateBetween(userService.getLoggedInUser().getId(),startDate, endDate, pageable).toList();
    }
}
