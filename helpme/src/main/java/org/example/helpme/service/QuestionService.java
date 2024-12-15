package org.example.helpme.service;

import org.example.helpme.model.dto.QuestionDTO;
import org.example.helpme.model.entity.QuestionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;

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
    public List<QuestionDTO> getQuestionsByCategory(Integer categoryId);
}
