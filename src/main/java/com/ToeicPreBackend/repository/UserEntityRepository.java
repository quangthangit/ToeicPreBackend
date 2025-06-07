package com.ToeicPreBackend.repository;

import com.ToeicPreBackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserEntityRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}