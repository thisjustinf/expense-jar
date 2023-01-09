package com.expensejar.server.expense;

import java.util.Date;
import java.util.UUID;

import com.expensejar.server.expense.dto.ExpenseDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@Entity
@Table(name = "expense")
public class Expense {
    @Id
    @GeneratedValue(generator = "uuid4", strategy = GenerationType.UUID)
    // @Column(name = "uuid", insertable = false, updatable = false)
    private UUID uuid;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss", timezone = "UTC")
    private Date createdAt;

    @Column(name = "amount", nullable = false)
    private double amount;

    public Expense(String title, String companyName, double amount) {
        this.title = title;
        this.companyName = companyName;
        this.amount = amount;
        this.createdAt = new Date();
    }

    public Expense(ExpenseDTO expenseDTO) {
        this.title = expenseDTO.getTitle();
        this.companyName = expenseDTO.getCompanyName();
        this.amount = expenseDTO.getAmount();
    }

    public UUID getUUID() {
        return uuid;
    }

    public void setUUID(UUID uuid) {
        this.uuid = uuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
