package com.sistema.examenes.services;

import java.util.List;
import java.util.Set;

import com.sistema.examenes.models.Category;
import com.sistema.examenes.models.Exam;

public interface ExamService {
    
    Exam addExam(Exam exam);

    Exam updateExam(Exam exam);

    Set<Exam> getExams();

    Exam getExamById(Long examId);

    void deleteExam(Long examId);

    List<Exam> getExamsByCategory(Category category);

    List<Exam> getExamsActives();

    List<Exam> getExamsActiveByCategory(Category category);
}
