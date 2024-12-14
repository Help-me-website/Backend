package org.example.helpme.service;

import org.example.helpme.model.dto.QuestionDTO;
import org.example.helpme.model.entity.QuestionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface QuestionService {
    public Iterable<QuestionDTO> getAllQuestions();
    public QuestionDTO getQuestionById(Integer id);
    public QuestionDTO saveQuestion(QuestionDTO questionDTO);
    public QuestionDTO updateQuestion(QuestionDTO questionDTO);
//    public Iterable<QuestionDTO> getQuestionsByUserId(Integer id);
    public Iterable<QuestionDTO> getQuestionsByUserEmail(String email);
    public Void deleteQuestion(Integer id);
    public List<QuestionDTO> getQuestionsByCategory(String categoryName);
    public Page<QuestionEntity> getQuestions(String categoryName, String searchKeyword, Pageable pageable);
}
