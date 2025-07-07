package com.example.demo.Controller;

import com.example.demo.Model.AnsSubDTO;
import com.example.demo.Model.ResultDTO;
import com.example.demo.Service.QuizAttemptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quiz")
public class QuizAttemptController {

    @Autowired
    private QuizAttemptService quizAttemptService;

    @PostMapping("/submit")
    public String submitAns(@RequestBody AnsSubDTO ansSubDTO){
        return quizAttemptService.submitAnswer(ansSubDTO);
    }

    @GetMapping("/result/{sessionId}")
    public ResultDTO getResult(@PathVariable int sessionId){
        return quizAttemptService.getResult(sessionId);
    }

}
