package com.scaler.splitwiseseptember2024.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExpenseUser extends BaseModel {
    private Expense expense;
    private User user;
    private int amount;
    private ExpenseUserType expenseUserType;
}
