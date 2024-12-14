package org.example.helpme.controller.global;


import lombok.RequiredArgsConstructor;
import org.example.helpme.model.dto.QuestionDTO;
import org.example.helpme.service.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/home")
@RequiredArgsConstructor
public class Home {
  private final QuestionService questionService;
  @GetMapping("/category/{name}")
  public ResponseEntity<List<QuestionDTO>> getQuestionsByCategory(
          @PathVariable("name") String categoryName
  ) {
    List<QuestionDTO> questions = questionService.getQuestionsByCategory(categoryName);
    return ResponseEntity.ok(questions);
  }
}
