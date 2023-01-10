package com.expensejar.server.expense.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ExpenseDTO {
    @NotBlank
    String title;

    @NotBlank
    String companyName;

    @DecimalMin("0.01")
    double amount;
}
