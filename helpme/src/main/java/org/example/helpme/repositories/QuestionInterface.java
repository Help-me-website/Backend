package org.example.helpme.repositories;

import org.example.helpme.domain.dto.QuestionDTO;

import java.util.List;

public interface QuestionInterface {
    // anyone
    public List<QuestionDTO> getQuestions();
    // must be a user
    public void addQuestion(QuestionDTO questionDTO);
    // delete and update for the admin or the user himself
    public void removeQuestion(QuestionDTO questionDTO);
    public void updateQuestion(QuestionDTO questionDTO);
}
