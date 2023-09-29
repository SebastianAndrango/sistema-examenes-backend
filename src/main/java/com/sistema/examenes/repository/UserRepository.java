package com.sistema.examenes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.examenes.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByUsername(String username);
    
}
