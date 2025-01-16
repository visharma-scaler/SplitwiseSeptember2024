package com.scaler.splitwiseseptember2024.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Expense extends BaseModel {
    private String description;
    private int amount;
    private Group group;
    private User createdBy;
    private ExpenseType expenseType;
}
