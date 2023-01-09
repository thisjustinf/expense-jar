package com.expensejar.server.expense;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.expensejar.server.expense.dto.ExpenseDTO;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/expense")
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<UUID> createExpense(@RequestBody(required = true) ExpenseDTO expense) {
        try {

        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{uuid}")
    public ResponseEntity<Expense> getExpenseByUUID(@PathVariable(required = true) UUID uuid) {
        try {
            Expense expense = this.expenseService.getExpense(uuid);
            return new ResponseEntity<>(expense, HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/member/{memberUUID}")
    public ResponseEntity<List<Expense>> getExpensesByMemberUUID(@PathVariable(required = true) UUID memberUUID) {
        try {
            // Optional<List<Expense>> expenses = this.expenseService.getMemberExpenses()
        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<Expense> updateExpense() {
        try {

        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Boolean> deleteExpense(@PathVariable(required = true) UUID uuid) {
        try {

        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }
}
