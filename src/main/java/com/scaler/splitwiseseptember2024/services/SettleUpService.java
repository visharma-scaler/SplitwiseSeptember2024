package com.scaler.splitwiseseptember2024.services;

import com.scaler.splitwiseseptember2024.dto.Transaction;
import com.scaler.splitwiseseptember2024.models.Expense;
import com.scaler.splitwiseseptember2024.models.ExpenseUser;
import com.scaler.splitwiseseptember2024.models.Group;
import com.scaler.splitwiseseptember2024.models.User;
import com.scaler.splitwiseseptember2024.repositories.ExpenseRepository;
import com.scaler.splitwiseseptember2024.repositories.ExpenseUserRepository;
import com.scaler.splitwiseseptember2024.repositories.GroupRepository;
import com.scaler.splitwiseseptember2024.repositories.UserRepository;
import com.scaler.splitwiseseptember2024.strategies.SettleUpStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SettleUpService {

    private final GroupRepository groupRepository;
    private final UserRepository userRepository;
    private final ExpenseRepository expenseRepository;
    private final ExpenseUserRepository expenseUserRepository;
    private final SettleUpStrategy settleUpStrategy;

    @Autowired
    public SettleUpService(GroupRepository groupRepository,
                           UserRepository userRepository,
                           ExpenseRepository expenseRepository,
                           ExpenseUserRepository expenseUserRepository,
                           SettleUpStrategy settleUpStrategy) {
        this.groupRepository = groupRepository;
        this.userRepository = userRepository;
        this.expenseRepository = expenseRepository;
        this.expenseUserRepository = expenseUserRepository;
        this.settleUpStrategy = settleUpStrategy;
    }

    public List<Transaction> settleUpUser(Long userId) {

        /*

            1. Get all the expenses which user is part of.
            2. Iterate through all the expenses,
                find out the people who paid and who owes and how much
            3. Min-Heap and Max-Heap algorithm to find the minimum transactions
            4. Return all the transactions for that user

        */

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found!"));

        List<ExpenseUser> expenseUsers = expenseUserRepository.findAllByUser(user);
        List<Expense> expenses = expenseUsers.stream()
                .map(ExpenseUser::getExpense)
                .collect(Collectors.toList());

        List<Transaction> transactions = settleUpStrategy.settleUp(expenses);
        // filtering bases on user
        return transactions;
    }

    public List<Transaction> settleUpGroup(Long groupId) {

        /*

            1. Get all the expenses for that group.
            2. Iterate through all the expenses,
                find out the people who paid and who owes and how much
            3. Min-Heap and Max-Heap algorithm to find the minimum transactions
            4. Return all the transactions

        */


        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new RuntimeException("Group not found!"));

        List<Expense> expenses = expenseRepository.findAllByGroup(group);
        List<Transaction> transactions = settleUpStrategy.settleUp(expenses);
        return transactions;
    }
}
