package com.expensejar.server.expense;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(value = ExpenseController.class)
public class ExpenseServiceTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ExpenseService expenseService;
}
