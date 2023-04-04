package pk.iamsafidev.expensetrackerapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public Expense getExpenseById(@PathVariable("id") Long id) {
        return expenseService.getExpenseById(id);
    }

    @DeleteMapping("/expenses")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteExpenseById(@RequestParam("id") Long id) {
        expenseService.deleteExpenseById(id);
    }

    @PostMapping("/expenses")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Expense saveExpenseDetails(@RequestBody Expense expense) {
        return expenseService.saveExpenseDetails(expense);
    }

    @PutMapping("/expenses/{id}")
    public Expense updateExpenseDetails(@RequestBody Expense expense, @PathVariable Long id) {
        return expenseService.updateExpenseDetails(id, expense);
    }
}
