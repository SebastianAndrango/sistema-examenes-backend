package com.sistema.examenes.services.impl;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.examenes.models.Category;
import com.sistema.examenes.models.Exam;
import com.sistema.examenes.repository.ExamRepository;
import com.sistema.examenes.services.ExamService;

@Service
public class ExamServiceImpl implements ExamService {


    @Autowired
    private ExamRepository examRepository;

    @Override
    public Exam addExam(Exam exam) {
        return examRepository.save(exam);
    }

    @Override
    public Exam updateExam(Exam exam) {
        return examRepository.save(exam);
    }

    @Override
    public Set<Exam> getExams() {
        return new LinkedHashSet<>(examRepository.findAll());
    }

    @Override
    public Exam getExamById(Long examId) {
        return examRepository.findById(examId).get();
    }

    @Override
    public void deleteExam(Long examId) {
        Exam exam = new Exam();
        exam.setExamId(examId);
        examRepository.delete(exam);
    }

    @Override
    public List<Exam> getExamsByCategory(Category category) {
        return this.examRepository.findByCategory(category);
    }

    @Override
    public List<Exam> getExamsActives() {
        return examRepository.findByActive(true);
    }

    @Override
    public List<Exam> getExamsActiveByCategory(Category category) {
        return examRepository.findByCategoryAndActive(category, true);
    }

    
    
}
