package com.expensejar.server.expense.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ExpenseDTO {
    String title;
    String companyName;
    double amount;
}
