package org.example.helpme.services;

import org.example.helpme.domain.Entities.AnswerEntity;
import org.example.helpme.repositories.AnswerRepo;

import java.util.List;

public class AnswerService {
    private final AnswerRepo answerRepo;

    public AnswerService(AnswerRepo answerRepo) {
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
