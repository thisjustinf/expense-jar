package com.expensejar.server.expense;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, UUID> {

}
