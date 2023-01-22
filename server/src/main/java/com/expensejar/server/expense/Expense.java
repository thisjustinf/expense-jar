package com.expensejar.server.expense;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.expensejar.server.expense.dto.ExpenseDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Data
@AllArgsConstructor
@Builder
@Table(name = "expense")
@EntityListeners(AuditingEntityListener.class)
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID, generator = "uuid")
    @Column(name = "id", insertable = false, updatable = false)
    private UUID id;

    @NotBlank(message = "Title cannot be empty")
    @Column(name = "title", nullable = false)
    private String title;

    @NotBlank(message = "The company name cannot be empty")
    @Column(name = "company_name", nullable = false)
    private String companyName;

    @CreatedDate
    @Column(name = "created_at", nullable = false, insertable = false, updatable = false, columnDefinition = "timestamp not null default current_timestamp")
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date createdAt;

    @LastModifiedDate
    @Column(name = "last_modified", nullable = false, insertable = false, columnDefinition = "timestamp not null default current_timestamp")
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

}
