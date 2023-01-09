package com.expensejar.server.expense;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expensejar.server.expense.dto.ExpenseDTO;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public Expense getExpense(UUID uuid) {
        Optional<Expense> expense = this.expenseRepository.findById(uuid);
        if (expense.isPresent()) {
            return expense.get();
        }
        return null;
    }

    public List<Expense> getMemberExpenses() {
        try {
            // Optional<List<Expense>> expenses = this.expenseRepository.find
        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }

    public Expense createExpense(ExpenseDTO expenseDTO) {
        try {
            Expense expense = new Expense(expenseDTO.getTitle(), expenseDTO.getCompanyName(), expenseDTO.getAmount());
            return this.expenseRepository.save(expense);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }

    public Expense updateExpense(UUID uuid, ExpenseDTO expenseDTO) {
        try {
            if (expenseDTO == null)
                return null;
            Optional<Expense> e = this.expenseRepository.findById(uuid);
            if (!e.isPresent())
                return null;
            Expense expense = e.get();
            expense.setAmount(expenseDTO.getAmount());
            expense.setCompanyName(expenseDTO.getCompanyName());
            expense.setTitle(expenseDTO.getTitle());
            Expense updated = this.expenseRepository.save(expense);
            return updated;
        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }
    }

    public boolean deleteExpense(UUID uuid) {
        try {
            this.expenseRepository.deleteById(uuid);
            return true;
        } catch (IllegalArgumentException e) {
            // TODO: handle exception
            return false;
        }
    }

}
