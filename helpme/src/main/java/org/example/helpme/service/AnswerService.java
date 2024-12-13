package org.example.helpme.service;

import org.example.helpme.mapper.AnswerMapper;
import org.example.helpme.model.dto.AnswerDTO;
import org.example.helpme.model.entity.AnswerEntity;
import org.example.helpme.repository.AnswerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class AnswerService {
    private final AnswerRepository answerRepo;
    private final AnswerMapper answerMapper;

    public AnswerService(AnswerRepository answerRepo, AnswerMapper answerMapper) {
        this.answerRepo = answerRepo;
        this.answerMapper = answerMapper;
    }

    public List<AnswerDTO> getAllAnswers() {
        List<AnswerEntity> answers = answerRepo.findAll();
        return answers
                .stream()
                .map(answerMapper::toDto)
                .collect(Collectors.toList());
    }
    public void addAnswer(AnswerDTO answer) {
        answerRepo.save(answerMapper.toEntity(answer));
    }
    public void removeAnswer(AnswerDTO answer) {
        answerRepo.delete(answerMapper.toEntity(answer));
    }
    public void updateAnswer(AnswerDTO answer) {
        answerRepo.save(answerMapper.toEntity(answer));
    }
}
