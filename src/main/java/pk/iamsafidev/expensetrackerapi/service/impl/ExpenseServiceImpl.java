package pk.iamsafidev.expensetrackerapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pk.iamsafidev.expensetrackerapi.entity.Expense;
import pk.iamsafidev.expensetrackerapi.repository.ExpenseRepository;
import pk.iamsafidev.expensetrackerapi.service.ExpenseService;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepository repository;

    @Override
    public List<Expense> getAllExpenses() {
        return repository.findAll();
    }

    @Override
    public Expense getExpenseById(Long id) {
        Optional<Expense> expense = repository.findById(id);
        if (expense.isPresent()) {
            return expense.get();
        }
        throw new RuntimeException("Expense is not found for id " + id);
    }

    @Override
    public void deleteExpenseById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Expense saveExpenseDetails(Expense expense) {
        return repository.save(expense);
    }
}
