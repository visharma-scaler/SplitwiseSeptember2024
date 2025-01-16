package com.scaler.splitwiseseptember2024.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Group extends BaseModel {
    private String name;
    private List<User> members;
    private List<Expense> expenses;
    private User createdBy;
}
