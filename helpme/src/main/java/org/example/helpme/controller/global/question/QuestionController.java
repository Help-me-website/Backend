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

  private QuestionResponse mapToQuestionResponse(QuestionDTO question) {
    Integer userId = question.getUserId();
    var user = userService.getUserById(userId); // Assuming a method to fetch user by ID

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
            .numberOfUsers(question.getNumberOfUsers())
            .build();
  }
  @GetMapping("/all")
  public ResponseEntity<Iterable<QuestionResponse>> getAllQuestions() {
    List<QuestionDTO> questionDTOS = questionService.getAllQuestions();

    List<QuestionResponse> responses = questionDTOS.stream()
            .map(this::mapToQuestionResponse)
            .toList();
    return ResponseEntity.ok(responses);
  }
  @GetMapping("/faq")
  public ResponseEntity<Iterable<QuestionResponse>> getFaqQuestions() {
    List<QuestionDTO> questionDTOS = questionService.getFAQ();
    List<QuestionResponse> responses = questionDTOS.stream()
            .map(this::mapToQuestionResponse)
            .toList();
    return ResponseEntity.ok(responses);
  }
  @GetMapping("/by-user/{email}")
  public ResponseEntity<Iterable<QuestionResponse>> getQuestionsByUserEmail(@PathVariable String email) {
    List<QuestionDTO> questionDTOS = questionService.getQuestionsByUserEmail(email);
    List<QuestionResponse> responses = questionDTOS.stream()
            .map(this::mapToQuestionResponse)
            .toList();
    return ResponseEntity.ok(responses);
  }
  @GetMapping("/{id}")
  public ResponseEntity<QuestionResponse> getQuestionById(@PathVariable Integer id) {
    QuestionDTO questionDTO = questionService.getQuestionById(id);
    QuestionResponse response = mapToQuestionResponse(questionDTO);
    return ResponseEntity.ok(response);
  }
  @GetMapping("/category-name/{category}")
  public ResponseEntity<Iterable<QuestionResponse>> getQuestionsByCategory(@PathVariable String category) {
    List<QuestionDTO> questionDTOS = questionService.getQuestionsByCategory(category);
    List<QuestionResponse> responses = questionDTOS.stream()
            .map(this::mapToQuestionResponse)
            .toList();
    return ResponseEntity.ok(responses);
  }
  @GetMapping("/category-id/{categoryId}")
  public ResponseEntity<Iterable<QuestionResponse>> getQuestionsByCategory(@PathVariable Integer categoryId) {
    List<QuestionDTO> questionDTOS = questionService.getQuestionsByCategory(categoryId);
    List<QuestionResponse> responses = questionDTOS.stream()
            .map(this::mapToQuestionResponse)
            .toList();
    return ResponseEntity.ok(responses);
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
