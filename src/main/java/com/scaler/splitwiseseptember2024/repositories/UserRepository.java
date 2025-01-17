package com.scaler.splitwiseseptember2024.repositories;

import com.scaler.splitwiseseptember2024.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
