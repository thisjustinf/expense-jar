package com.expensejar.server.expense;

import java.util.Date;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.expensejar.server.expense.dto.ExpenseDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Entity
@Table(name = "expense")
public class Expense {
    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "uuid", insertable = false, updatable = false)
    private UUID uuid;

    @NotBlank(message = "Title cannot be empty")
    @Column(name = "title", nullable = false)
    private String title;

    @NotBlank(message = "The company name cannot be empty")
    @Column(name = "company_name", nullable = false)
    private String companyName;

    @CreatedDate
    @Column(name = "created_at", nullable = false, insertable = false)
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date createdAt;

    @LastModifiedDate
    @Column(name = "created_at", nullable = false, insertable = false)
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date lastModified;

    @DecimalMin(value = "0.01")
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
        this.createdAt = new Date();
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

    @Temporal(TemporalType.DATE)
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
