package com.sistema.examenes.services.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.examenes.models.Exam;
import com.sistema.examenes.models.Question;
import com.sistema.examenes.repository.QuestionRepository;
import com.sistema.examenes.services.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService{

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Question addQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Set<Question> getQuestions() {
        return new LinkedHashSet<>(questionRepository.findAll());
    }

    @Override
    public Question getQuestionById(Long questionId) {
        return questionRepository.findById(questionId).get();
    }

    @Override
    public Set<Question> getQuestionsByExam(Exam exam) {
        return questionRepository.findByExam(exam);
    }

    @Override
    public void deleteQuestion(Long questionId) {
        Question question = new Question();
        question.setQuestionId(questionId);
        questionRepository.delete(question);
    }

    @Override
    public Question listQuestionById(Long questionId) {
        return this.questionRepository.getOne(questionId);
    }
    
}
