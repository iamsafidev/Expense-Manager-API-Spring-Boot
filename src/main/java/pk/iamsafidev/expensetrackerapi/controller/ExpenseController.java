package pk.iamsafidev.expensetrackerapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pk.iamsafidev.expensetrackerapi.entity.Expense;
import pk.iamsafidev.expensetrackerapi.service.ExpenseService;

import java.util.List;

@RestController
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/expenses")
    public List<Expense> getAllExpenses() {
        return expenseService.getAllExpenses();
    }

    @GetMapping("/expenses/{id}")
    public String getExpenseById(@PathVariable("id") Long id) {
        return "expenseService.getAllExpenses().get(0);: " + id;
    }

    @DeleteMapping("/expenses")
    public String deleteExpenseById(@RequestParam("id") Long id) {
        return "Delete Expense of Id "+id;
    }
}
