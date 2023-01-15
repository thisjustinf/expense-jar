package com.expensejar.server.expense;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.expensejar.server.expense.dto.ExpenseCreateDTO;
import com.expensejar.server.expense.dto.ExpenseDTO;

// @CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/expense")
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ExpenseCreateDTO> createExpense(@RequestBody(required = true) ExpenseDTO expense) {
        try {
            Expense created = this.expenseService.createExpense(expense);
            if (created != null)
                return new ResponseEntity<ExpenseCreateDTO>(new ExpenseCreateDTO(created.getId()), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
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
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/")
    public ResponseEntity<List<Expense>> getExpenses() {
        try {
            List<Expense> expenses = this.expenseService.getExpenses();
            if (expenses.size() == 0)
                return new ResponseEntity<>(expenses, HttpStatus.NO_CONTENT);
            return new ResponseEntity<>(expenses, HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(path = "/{uuid}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Expense> updateExpense(@PathVariable(required = true) UUID uuid,
            @RequestBody(required = true) ExpenseDTO expenseDTO) {
        try {
            Expense updated = this.expenseService.updateExpense(uuid, expenseDTO);
            if (updated != null) {
                return new ResponseEntity<>(updated, HttpStatus.OK);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> deleteExpense(@PathVariable(required = true) UUID uuid) {
        try {
            if (this.expenseService.deleteExpense(uuid))
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return null;
    }
}
