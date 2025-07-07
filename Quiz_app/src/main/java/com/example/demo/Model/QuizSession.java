package com.example.demo.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "quiz_session")
public class QuizSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sessionId;

    private int currentQueIdx = 0;

    private int currQueID;

    public QuizSession(){}

    public QuizSession(int sessionId, int currentQueIdx, int currQueID) {
        this.sessionId = sessionId;
        this.currentQueIdx = currentQueIdx;
        this.currQueID = currQueID;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public int getCurrentQueIdx() {
        return currentQueIdx;
    }

    public void setCurrentQueIdx(int currentQueIdx) {
        this.currentQueIdx = currentQueIdx;
    }

    public int getCurrQueID() {
        return currQueID;
    }

    public void setCurrQueID(int currQueID) {
        this.currQueID = currQueID;
    }
}
