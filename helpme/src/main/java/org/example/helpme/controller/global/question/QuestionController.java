package org.example.helpme.controller.global.question;

import lombok.RequiredArgsConstructor;
import org.example.helpme.config.JwtService;
import org.example.helpme.model.dto.CategoryDTO;
import org.example.helpme.model.dto.QuestionDTO;
import org.example.helpme.repository.UserRepository;
import org.example.helpme.service.CategoryService;
import org.example.helpme.service.QuestionService;
import org.example.helpme.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/home/questions")
@CrossOrigin("*")
@RequiredArgsConstructor
public class QuestionController {
  private final QuestionService questionService;
  private final UserService userService;
  private final UserRepository userRepository;
  private final CategoryService categoryService;
  private final JwtService jwtService;
  @GetMapping("/all")
  public ResponseEntity<Iterable<QuestionResponse>> getAllQuestions() {
    List<QuestionDTO> questionDTOS = questionService.getAllQuestions();

    List<QuestionResponse> responses = questionDTOS.stream()
            .map(question -> {
              // Fetch user details
              Integer userId = question.getUserId();
              var user = userService.getUserById(userId); // Assuming a method to fetch user by ID

              // Map to QuestionResponse
              return QuestionResponse.builder()
                      .id(question.getId())
                      .title(question.getTitle())
                      .content(question.getContent())
                      .category(question.getCategory())
                      .createdAt(question.getCreatedAt())
                      .updatedAt(question.getUpdatedAt())
                      .views(question.getViews())
                      .firstName(user.getFirstName())
                      .lastName(user.getLastName())
                      .build();
            })
            .toList();
    return ResponseEntity.ok(responses);
  }
  @GetMapping("/faq")
  public ResponseEntity<Iterable<QuestionDTO>> getFaqQuestions() {
    Iterable<QuestionDTO> questionDTOS = questionService.getFAQ();
    return ResponseEntity.ok(questionDTOS);
  }

  @GetMapping("/by-user/{email}")
  public ResponseEntity<Iterable<QuestionDTO>> getQuestionsByUserEmail(@PathVariable String email) {
    Iterable<QuestionDTO> questionDTOS = questionService.getQuestionsByUserEmail(email);
    return ResponseEntity.ok(questionDTOS);
  }
  @GetMapping("/{id}")
  public ResponseEntity<QuestionDTO> getQuestionById(@PathVariable Integer id) {
    QuestionDTO questionDTO = questionService.getQuestionById(id);
    return ResponseEntity.ok(questionDTO);
  }
  @GetMapping("/category-name/{category}")
  public ResponseEntity<Iterable<QuestionDTO>> getQuestionsByCategory(@PathVariable String category) {
    Iterable<QuestionDTO> questionDTOS = questionService.getQuestionsByCategory(category);
    return ResponseEntity.ok(questionDTOS);
  }
  @GetMapping("/category-id/{categoryId}")
  public ResponseEntity<Iterable<QuestionDTO>> getQuestionsByCategory(@PathVariable Integer categoryId) {
    Iterable<QuestionDTO> questionDTOS = questionService.getQuestionsByCategory(categoryId);
    return ResponseEntity.ok(questionDTOS);
  }
  @PostMapping("/modify/add")
  public ResponseEntity<QuestionDTO> addQuestion(@RequestBody QuestionRequest questionRequest,@RequestHeader("Authorization") String token) {
    String jwt = token.substring(7);
    String username = jwtService.getUsername(jwt);
    Integer userId = Objects.requireNonNull(userRepository.findByEmail(username).orElse(null)).getUserId();

    CategoryDTO category = categoryService.getCategoryById(questionRequest.getCategory().id);
    QuestionDTO question = QuestionDTO.builder()
            .title(questionRequest.getTitle())
            .content(questionRequest.getContent())
            .userId(userId)
            .category(category)
            .build();
    question = questionService.saveQuestion(question);
    return ResponseEntity.ok(question);
  }
  @PutMapping("/modify/update")
  public ResponseEntity<QuestionDTO> updateQuestion(@RequestBody QuestionDTO questionDTO) {
    QuestionDTO question = questionService.updateQuestion(questionDTO);
    return ResponseEntity.ok(question);
  }
  @DeleteMapping("/modify/delete/{id}")
  public ResponseEntity<Void> deleteQuestion(@PathVariable Integer id) {
    questionService.deleteQuestion(id);
    return ResponseEntity.ok().build();
  }

}
