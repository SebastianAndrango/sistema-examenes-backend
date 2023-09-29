package com.sistema.examenes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.examenes.models.Category;
import com.sistema.examenes.models.Exam;

public interface ExamRepository extends JpaRepository<Exam,Long>{
    
    List<Exam> findByCategory(Category category);

    List<Exam> findByActive(Boolean active);

    List<Exam> findByCategoryAndActive(Category category, Boolean active);
}
