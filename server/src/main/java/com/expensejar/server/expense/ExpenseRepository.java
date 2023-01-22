package com.expensejar.server.expense;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, UUID> {

    List<Expense> findByCompanyName(String companyName);

    List<Expense> findByTitleContaining(String title);

}
