package com.sistema.examenes.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.examenes.models.Exam;
import com.sistema.examenes.models.Question;
import com.sistema.examenes.services.ExamService;
import com.sistema.examenes.services.QuestionService;

@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private ExamService examService;

    @PostMapping("/")
    public ResponseEntity<Question> saveQuestion(@RequestBody Question question){
        Question questionSave = questionService.addQuestion(question);
        return ResponseEntity.ok(questionSave);
    }

    @PutMapping("/")
    public ResponseEntity<Question> updateQuestion(@RequestBody Question question){
        return ResponseEntity.ok(questionService.updateQuestion(question));
    }

    @GetMapping("/exam/{examId}")
    public ResponseEntity<?> getQuestionsByExamId(@PathVariable("examId")Long examId){
        Exam exam = examService.getExamById(examId);
        Set<Question> questions = exam.getQuestions();
        
        List exams = new ArrayList(questions);
        if (exams.size()> Integer.parseInt(exam.getQuestionNumbers())) {
            exams = exams.subList(0, Integer.parseInt(exam.getQuestionNumbers()+1));
        }

        Collections.shuffle(exams);
        return ResponseEntity.ok(exams);

    }

    @GetMapping("/{questionId}")
    public Question getQuestionById(@PathVariable("questionId")Long questionId){
        return questionService.getQuestionById(questionId);
    }

    @DeleteMapping("/{questionId}")
    public void deleteQuestionById(@PathVariable("questionId")Long questionId){
        questionService.deleteQuestion(questionId);
    }

    @GetMapping("exam/all/{examId}")
    public ResponseEntity<?> getQuestionByExamAdmin(@PathVariable("examId")Long examId){
        Exam exam = examService.getExamById(examId);
        Set<Question> questions = questionService.getQuestionsByExam(exam);
        return ResponseEntity.ok(questions);
    }

    @PostMapping("/evalue-exam")
    public ResponseEntity<?> evalueExam(@RequestBody List<Question> questions){
        double maxPoints = 0;
        Integer correctAnswers = 0;
        Integer attempts = 0; 
        for (Question q : questions) {
            Question question = this.questionService.listQuestionById(q.getQuestionId());
            if (question.getAnswer().equals(q.getGivenAnswer())) {
                correctAnswers++;
                double points = Double.parseDouble(questions.get(0).getExam().getMaxPoints())/questions.size();
                maxPoints += points;
            }
            if (q.getGivenAnswer()!=null) {
                attempts++;
            }
        }
        Map<String,Object> answers = new HashMap<>();
        answers.put("collectPoints", maxPoints);
        answers.put("correctAnswers", correctAnswers);
        answers.put("attempts", attempts);

        return ResponseEntity.ok(answers);
    }
    
}
