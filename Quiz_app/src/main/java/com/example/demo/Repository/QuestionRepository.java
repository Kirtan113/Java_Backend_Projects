package com.example.demo.Repository;

import com.example.demo.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question , Integer> {

    @Query(value = "SELECT * FROM question ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Question getRandomQuestion();
}

// hve apdne question full object mlse id pn mlse...dto ma return krshu pn logic question obj uper j lakhsu