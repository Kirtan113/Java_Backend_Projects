package com.example.demo.Model;

import java.util.List;

public class ResultDTO {
    private int totalQuestions;
    private int correctAnswers;
    private int incorrectAnswers;
//    private List<QuizAttempt> attempts;

    public ResultDTO(){}

    public ResultDTO(int totalQuestions, int correctAnswers, int incorrectAnswers) {
        this.totalQuestions = totalQuestions;
        this.correctAnswers = correctAnswers;
        this.incorrectAnswers = incorrectAnswers;
//        this.attempts = attempts;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(int correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public int getIncorrectAnswers() {
        return incorrectAnswers;
    }

    public void setIncorrectAnswers(int incorrectAnswers) {
        this.incorrectAnswers = incorrectAnswers;
    }

//    public List<QuizAttempt> getAttempts() {
//        return attempts;
//    }
//
//    public void setAttempts(List<QuizAttempt> attempts) {
//        this.attempts = attempts;
//    }
}
