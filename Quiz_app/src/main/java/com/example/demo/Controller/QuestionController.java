package com.example.demo.Controller;

import com.example.demo.Model.Question;
import com.example.demo.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("questions")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @PostMapping("/upload")
    public String uploadQuestions(@RequestBody List<Question> questions){
        questionService.saveAllQuestions(questions);
        return "questions upload successfully";
    }
}
