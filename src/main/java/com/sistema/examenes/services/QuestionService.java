package com.sistema.examenes.services;

import java.util.Set;

import com.sistema.examenes.models.Exam;
import com.sistema.examenes.models.Question;

public interface QuestionService {
    
    Question addQuestion(Question question);

    Question updateQuestion(Question question);

    Set<Question> getQuestions();

    Question getQuestionById(Long questionId);

    Set<Question> getQuestionsByExam(Exam exam);

    void deleteQuestion(Long questionId);

    Question listQuestionById(Long questionId);
}
