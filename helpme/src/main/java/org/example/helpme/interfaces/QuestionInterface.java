package org.example.helpme.interfaces;

import org.example.helpme.models.Question;

import java.util.List;

public interface QuestionInterface {
    // anyone
    public List<Question> getQuestions();
    // must be a user
    public void addQuestion(Question question);
    // delete and update for the admin or the user himself
    public void removeQuestion(Question question);
    public void updateQuestion(Question question);
}
