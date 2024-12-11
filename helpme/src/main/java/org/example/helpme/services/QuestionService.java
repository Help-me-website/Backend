package org.example.helpme.services;


import org.example.helpme.model.entity.QuestionEntity;
import org.example.helpme.repository.QuestionRepository;

public class QuestionService {
    private final QuestionRepository questionRepository;
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }
    public Iterable<QuestionEntity> getAllQuestions() {
        return questionRepository.findAll();
    }
    public void addQuestion(QuestionEntity questionDTO) {
        questionRepository.save(questionDTO);
    }
    public void removeQuestion(QuestionEntity questionDTO) {
        questionRepository.delete(questionDTO);
    }
    public void updateQuestion(QuestionEntity questionDTO) {
        questionRepository.save(questionDTO);
    }
}
