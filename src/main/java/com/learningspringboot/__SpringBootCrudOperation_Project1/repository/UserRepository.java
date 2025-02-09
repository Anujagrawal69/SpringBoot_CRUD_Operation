package com.learningspringboot.__SpringBootCrudOperation_Project1.repository;


import com.learningspringboot.__SpringBootCrudOperation_Project1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findUserByEmail(String email);
}

