package org.example.helpme.interfaces;

import org.example.helpme.models.Answer;

import java.util.List;

public interface AnswerInterface {
    // anyone
    public List<Answer> getAnswers();
    // must be a user
    public void addAnswer(Answer answer);
    public void removeAnswer(Answer answer);
    public void updateAnswer(Answer answer);
}
