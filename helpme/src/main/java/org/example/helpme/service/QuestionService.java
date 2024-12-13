package org.example.helpme.service;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.helpme.mapper.QuestionMapper;
import org.example.helpme.model.dto.QuestionDTO;
import org.example.helpme.model.entity.QuestionEntity;
import org.example.helpme.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;



@Service
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final QuestionMapper questionMapper;
    public QuestionService(QuestionRepository questionRepository, QuestionMapper questionMapper) {
        this.questionRepository = questionRepository;
        this.questionMapper = questionMapper;
    }
    public Iterable<QuestionDTO> getAllQuestions() {
         List<QuestionEntity> questions = questionRepository.findAll();
         return questions
                 .stream()
                 .map(questionMapper::toDto)
                 .collect(Collectors.toList());
    }
    public void addQuestion(QuestionDTO question) {
        questionRepository.save(questionMapper.toEntity(question));
    }
    public void removeQuestion(QuestionDTO question) {
        questionRepository.delete(questionMapper.toEntity(question));
    }
    public void updateQuestion(QuestionDTO question) {
        questionRepository.save(questionMapper.toEntity(question));
    }
}
