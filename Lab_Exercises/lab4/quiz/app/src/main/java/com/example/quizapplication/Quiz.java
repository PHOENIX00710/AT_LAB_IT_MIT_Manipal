package com.example.quizapplication;

public class Quiz {
    String Question;
    boolean answer;

    public Quiz(String question, boolean answer) {
        Question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }
}
