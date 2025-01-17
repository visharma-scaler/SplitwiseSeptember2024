package com.scaler.splitwiseseptember2024.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "expenses")
public class Expense extends BaseModel {
    private String description;
    private int amount;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @ManyToOne
    private User createdBy;

    @Enumerated(value = EnumType.STRING)
    private ExpenseType expenseType;
}
