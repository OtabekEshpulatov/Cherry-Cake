package com.cakecafe.backend.repository;

import com.cakecafe.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // You can add custom queries here if needed
}