package com.example.demo.Service;

import com.example.demo.Model.Question;
import com.example.demo.Repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    public void saveAllQuestions(List<Question> questions){
        questionRepository.saveAll(questions);
    }
}
