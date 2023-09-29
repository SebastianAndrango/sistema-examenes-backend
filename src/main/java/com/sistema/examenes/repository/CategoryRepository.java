package com.sistema.examenes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.examenes.models.Category;

public interface CategoryRepository extends JpaRepository<Category,Long>{
    
}
