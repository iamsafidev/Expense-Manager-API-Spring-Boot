package pk.iamsafidev.expensetrackerapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pk.iamsafidev.expensetrackerapi.entity.Expense;
import pk.iamsafidev.expensetrackerapi.repository.ExpenseRepository;
import pk.iamsafidev.expensetrackerapi.service.ExpenseService;

import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepository repository;

    @Override
    public List<Expense> getAllExpenses() {
        return repository.findAll();
    }
}
