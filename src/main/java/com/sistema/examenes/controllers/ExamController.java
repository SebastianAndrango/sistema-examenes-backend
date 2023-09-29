package com.sistema.examenes.controllers;

import java.util.List;

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

import com.sistema.examenes.models.Category;
import com.sistema.examenes.models.Exam;
import com.sistema.examenes.services.ExamService;

@RestController
@RequestMapping("/exam")
@CrossOrigin("*")
public class ExamController {

    @Autowired
    private ExamService examService;

    @PostMapping("/")
    public ResponseEntity<Exam> saveExam(@RequestBody Exam exam){
        return ResponseEntity.ok(examService.addExam(exam));
    }

    @PutMapping("/")
    public ResponseEntity<Exam> updateExam(@RequestBody Exam exam){
        return ResponseEntity.ok(examService.updateExam(exam));
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllExams(){
        return ResponseEntity.ok(examService.getExams());
    }

    @GetMapping("/{examId}")
    public Exam getExamById(@PathVariable("examId")Long examId){
        return examService.getExamById(examId);
    }

    @DeleteMapping("/{examId}")
    public void deleteExamById(@PathVariable("examId")Long examId){
        examService.deleteExam(examId);
    }

    @GetMapping("/category/{categoryId}")
    public List<Exam> getExamsByCategory(@PathVariable("categoryId")Long categoryId){
        Category category = new Category();
        category.setCategoryId(categoryId);
        return examService.getExamsByCategory(category);
    }

    @GetMapping("/active")
    public List<Exam> getExamsActives(){
        return examService.getExamsActives();
    }

    @GetMapping("/category/active/{categoryId}")
    public List<Exam> getExamsActivesByCategory (@PathVariable("categoryId") Long categoryId){
        Category category = new Category();
        category.setCategoryId(categoryId);
        return examService.getExamsActiveByCategory(category); 
    }

    
}
