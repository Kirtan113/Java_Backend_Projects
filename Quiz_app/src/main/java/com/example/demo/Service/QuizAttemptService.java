package com.example.demo.Service;

import com.example.demo.Model.*;
import com.example.demo.Repository.QuestionRepository;
import com.example.demo.Repository.QuizAttemptRepository;
import com.example.demo.Repository.QuizSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class QuizAttemptService {

//    attempt save krva
    @Autowired
    QuizAttemptRepository quizAttemptRepository;

//    que verify krva
    @Autowired
    QuestionRepository questionRepository;

//    session mathi queId kadhva mate
    @Autowired
    QuizSessionRepository quizSessionRepository;


    public String submitAnswer(AnsSubDTO ansSubDTO){
//        get session
        QuizSession quizSession = quizSessionRepository.findById(ansSubDTO.getSessionId()).orElse(null);

        if (quizSession == null){
            return "invalid session id";
        }

//        currQueID use krine teno object fetch krshu db mathi
        int queId = quizSession.getCurrQueID(); //id of last ask que
        Question question = questionRepository.findById(queId).orElse(null); // db mathi akho que obj kadhyo

        if (question == null){
            return "que not found";
        }

        boolean isCorrect = ansSubDTO.getSelectedAnswer().equalsIgnoreCase(question.getCorrectAnswer());

//        attempt save
        QuizAttempt attempt = new QuizAttempt();
        attempt.setSessionId(ansSubDTO.getSessionId());
        attempt.setQuestionId(queId);
        attempt.setSelectedAnswer(ansSubDTO.getSelectedAnswer());
        attempt.setIsCorrect(isCorrect);
        quizAttemptRepository.save(attempt);

//        msg return
        if (isCorrect){
            return "correct answer";
        }else {
            return "wrong answer";
        }
    }
    //hve user khali sessionid and answer send krse json ma , internally sys ma currect que get thay jase


    public ResultDTO getResult(int sessionId) {
        List<QuizAttempt> attempts = quizAttemptRepository.findBySessionId(sessionId);

        int correct = 0;
        int incorrect = 0;

        for (int i = 0; i < attempts.size(); i++) {
            if (attempts.get(i).isCorrect()) {
                correct++;
            } else {
                incorrect++;
            }
        }

        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setTotalQuestions(attempts.size());
        resultDTO.setCorrectAnswers(correct);
        resultDTO.setIncorrectAnswers(incorrect);
//        resultDTO.setAttempts(attempts);

        return resultDTO;
    }
}