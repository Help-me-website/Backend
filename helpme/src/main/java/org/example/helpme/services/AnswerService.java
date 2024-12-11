package org.example.helpme.services;

import org.example.helpme.model.entity.AnswerEntity;
import org.example.helpme.repository.AnswerRepository;

import java.util.List;

public class AnswerService {
    private final AnswerRepository answerRepo;

    public AnswerService(AnswerRepository answerRepo) {
        this.answerRepo = answerRepo;
    }

    public List<AnswerEntity> getAllAnswers() {
        return answerRepo.findAll();
    }
    public void addAnswer(AnswerEntity answer) {
        answerRepo.save(answer);
    }
    public void removeAnswer(AnswerEntity answer) {
        answerRepo.delete(answer);
    }
    public void updateAnswer(AnswerEntity answer) {
        answerRepo.save(answer);
    }
}
