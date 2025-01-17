package com.scaler.splitwiseseptember2024.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "expense_users")
public class ExpenseUser extends BaseModel {

    @ManyToOne
    private Expense expense;

    @ManyToOne
    private User user;

    private int amount;

    @Enumerated(value = EnumType.STRING)
    private ExpenseUserType expenseUserType;
}
