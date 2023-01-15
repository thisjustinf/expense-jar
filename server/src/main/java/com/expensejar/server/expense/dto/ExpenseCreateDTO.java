package com.expensejar.server.expense.dto;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseCreateDTO {

    @NotNull
    @JsonAlias({ "expense_id" })
    @JsonProperty("expense_id")
    private UUID expenseId;
}
