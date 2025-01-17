package com.scaler.splitwiseseptember2024.strategies;

import com.scaler.splitwiseseptember2024.dto.Transaction;
import com.scaler.splitwiseseptember2024.models.Expense;

import java.util.List;

public interface SettleUpStrategy {
    List<Transaction> settleUp(List<Expense> expenses);
}
