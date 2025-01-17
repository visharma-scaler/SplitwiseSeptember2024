package com.scaler.splitwiseseptember2024.repositories;

import com.scaler.splitwiseseptember2024.models.ExpenseUser;
import com.scaler.splitwiseseptember2024.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseUserRepository extends JpaRepository<ExpenseUser, Long> {
    List<ExpenseUser> findAllByUser(User user);
}
