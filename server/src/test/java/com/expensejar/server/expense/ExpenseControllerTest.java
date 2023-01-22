package com.expensejar.server.expense;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class ExpenseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    // @Autowired
    // private ExpenseService expenseService;

    @Test
    public void itShouldCreateAnExpense() throws Exception {
        Expense testExpense = new Expense("Test Expense", "Test Company", 50.00);

        mockMvc.perform(post("/api/v1/expense/create").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(testExpense)))
                .andExpect(status().isCreated())
                .andDo(print());
    }

}
