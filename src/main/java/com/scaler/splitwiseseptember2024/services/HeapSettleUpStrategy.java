package com.scaler.splitwiseseptember2024.services;

import com.scaler.splitwiseseptember2024.dto.Transaction;
import com.scaler.splitwiseseptember2024.models.Expense;
import com.scaler.splitwiseseptember2024.strategies.SettleUpStrategy;
import org.springframework.stereotype.Component;

import java.util.List;

// Homework
@Component
public class HeapSettleUpStrategy implements SettleUpStrategy {

    @Override
    public List<Transaction> settleUp(List<Expense> expenses) {
        return null;
    }
}

// Break till 08:30 AM IST
