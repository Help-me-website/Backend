package org.example.helpme.services;


import org.example.helpme.domain.Entities.QuestionEntity;
import org.example.helpme.repositories.QuestionRepo;

public class QuestionService {
    private final QuestionRepo questionRepo;
    public QuestionService(QuestionRepo questionRepo) {
        this.questionRepo = questionRepo;
    }
    public Iterable<QuestionEntity> getAllQuestions() {
        return questionRepo.findAll();
    }
    public void addQuestion(QuestionEntity questionDTO) {
        questionRepo.save(questionDTO);
    }
    public void removeQuestion(QuestionEntity questionDTO) {
        questionRepo.delete(questionDTO);
    }
    public void updateQuestion(QuestionEntity questionDTO) {
        questionRepo.save(questionDTO);
    }
}
