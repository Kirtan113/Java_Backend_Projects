package com.example.demo.Service;

import com.example.demo.Model.Question;
import com.example.demo.Model.QuestionViewDTO;
import com.example.demo.Model.QuizSession;
import com.example.demo.Repository.QuestionRepository;
import com.example.demo.Repository.QuizSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizSessionService {

    @Autowired
    private QuizSessionRepository quizSessionRepository;

    @Autowired
    private QuestionRepository questionRepo;

//    quiz start kre etle navo object bnse...ema currQueIdx = 0..db ma save...return new sessionId
    public int startQuiz() {
        QuizSession quizSession = new QuizSession();
        quizSessionRepository.save(quizSession);
        return quizSession.getSessionId();
    }


//    session id thi session object kadhyo db mathi... jo session nahi mle to null
    public QuestionViewDTO getNextRandomQue(int sessionId) {
        QuizSession session = quizSessionRepository.findById(sessionId).orElse(null);

//        quiz over
        if (session == null || session.getCurrentQueIdx() >= 5){
            throw new RuntimeException("Quiz over");
        }

//        random que fetch from db
        Question question = questionRepo.getRandomQuestion(); // full question object

//        e que ni id session ma store kri
        session.setCurrQueID(question.getId()); // store queId for ans checking

//        hve ek que avi gyo to +1 & session update
        session.setCurrentQueIdx(session.getCurrentQueIdx() + 1);
        quizSessionRepository.save(session);

//        custom dto manually return(interface remove)
        return new QuestionViewDTO(question.getQuestionText() , question.getOptionA() , question.getOptionB() , question.getOptionC() , question.getOptionD());
    }
}
