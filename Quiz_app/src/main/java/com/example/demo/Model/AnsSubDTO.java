package com.example.demo.Model;

public class AnsSubDTO {
    private int sessionId;
    private String selectedAnswer;

    public AnsSubDTO(){}

    public AnsSubDTO(int sessionId, String selectedAnswer) {
        this.sessionId = sessionId;
        this.selectedAnswer = selectedAnswer;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public String getSelectedAnswer() {
        return selectedAnswer;
    }

    public void setSelectedAnswer(String selectedAnswer) {
        this.selectedAnswer = selectedAnswer;
    }
}
