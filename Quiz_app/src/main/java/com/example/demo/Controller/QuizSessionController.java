package com.example.demo.Controller;

import com.example.demo.Model.QuestionViewDTO;
import com.example.demo.Service.QuizSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quiz")
public class QuizSessionController {

    @Autowired
    private QuizSessionService quizSessionService;

//        http://localhost:8080/quiz/start
    @PostMapping("/start")
    public int startQuiz(){
        return quizSessionService.startQuiz();
    }

//    http://localhost:8080/quiz/next/?
    @GetMapping("/next/{sessionId}")
    public QuestionViewDTO getNextQue(@PathVariable int sessionId) {
        return quizSessionService.getNextRandomQue(sessionId);
    }
}