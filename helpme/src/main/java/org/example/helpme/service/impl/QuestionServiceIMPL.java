package org.example.helpme.service.impl;
import lombok.RequiredArgsConstructor;
import org.example.helpme.mapper.Mapper;
import org.example.helpme.model.dto.QuestionDTO;
import org.example.helpme.model.entity.QuestionEntity;
import org.example.helpme.model.entity.UserEntity;
import org.example.helpme.repository.QuestionRepository;
import org.example.helpme.service.QuestionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;



@Service
@RequiredArgsConstructor
public class QuestionServiceIMPL implements QuestionService {
    private final QuestionRepository questionRepository;
    private final Mapper<QuestionEntity,QuestionDTO> questionMapper;

    @Override
    public Iterable<QuestionDTO> getAllQuestions() {
        List<QuestionEntity> questions = questionRepository.findAll();
        return questions
                .stream()
                .map(questionMapper::toDto)
                .collect(Collectors.toList());
    }
/*    @Override
    public Iterable<QuestionDTO> getQuestionsByUserId(Integer id) {
        List<QuestionEntity> questions = questionRepository.findByUserUserId(id);
        return questions
                .stream()
                .map(questionMapper::toDto)
                .collect(Collectors.toList());
    }*/
    @Override
    public QuestionDTO getQuestionById(Integer id) {
        QuestionEntity questionEntity = questionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Question not found"));
        return questionMapper.toDto(questionEntity);
    }

    @Override
    public QuestionDTO saveQuestion(QuestionDTO questionDTO) {
        QuestionEntity questionEntity = questionMapper.toEntity(questionDTO);
        questionEntity = questionRepository.save(questionEntity);
        return questionMapper.toDto(questionEntity);
    }

    @Override
    public QuestionDTO updateQuestion(QuestionDTO questionDTO) {
        QuestionEntity questionEntity = questionMapper.toEntity(questionDTO);
        questionEntity = questionRepository.save(questionEntity);
        return questionMapper.toDto(questionEntity);
    }

    @Override
    public Void deleteQuestion(Integer id) {
        questionRepository.deleteById(id);
        return null;
    }

    @Override
    public List<QuestionDTO> getQuestionsByCategory(String categoryName) {
        List<QuestionEntity> questions = questionRepository.findQuestionsByCategoryName(categoryName);
        return questions
                .stream()
                .map(questionMapper::toDto)
                .collect(Collectors.toList());
    }
    public Page<QuestionEntity> getQuestions(String categoryName, String searchKeyword, Pageable pageable) {
        if (categoryName != null && searchKeyword != null) {
            // Filter by category and search
            return questionRepository.findByCategoryAndSearch(categoryName, searchKeyword, pageable);
        } else if (categoryName != null) {
            // Filter by category only
            return questionRepository.findByCategory(categoryName, pageable);
        } else if (searchKeyword != null) {
            // Search only
            return questionRepository.searchByKeyword(searchKeyword, pageable);
        } else {
            // Return all with pagination and sorting
            return questionRepository.findAll(pageable);
        }
    }

    @Override
    public Iterable<QuestionDTO> getQuestionsByUserEmail(String email) {
        List<QuestionEntity> questions = questionRepository.findByUserEmail(email);
        return questions
                .stream()
                .map(questionMapper::toDto)
                .collect(Collectors.toList());
    }

}
