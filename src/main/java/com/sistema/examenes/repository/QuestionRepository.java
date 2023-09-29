package com.sistema.examenes.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.examenes.models.Exam;
import com.sistema.examenes.models.Question;

public interface QuestionRepository extends JpaRepository<Question,Long>{
    
    Set<Question> findByExam(Exam exam);
}
