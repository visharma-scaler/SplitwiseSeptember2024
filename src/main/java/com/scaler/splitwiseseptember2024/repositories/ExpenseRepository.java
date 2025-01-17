package com.scaler.splitwiseseptember2024.repositories;

import com.scaler.splitwiseseptember2024.models.Expense;
import com.scaler.splitwiseseptember2024.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findAllByGroup(Group group);
}
