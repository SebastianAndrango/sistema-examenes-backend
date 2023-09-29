package com.sistema.examenes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.examenes.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
    
}
