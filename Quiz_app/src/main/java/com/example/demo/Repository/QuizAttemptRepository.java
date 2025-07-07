package com.example.demo.Repository;

import com.example.demo.Model.QuizAttempt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizAttemptRepository extends JpaRepository<QuizAttempt , Integer> {
    List<QuizAttempt> findBySessionId(int sessionId);
}
