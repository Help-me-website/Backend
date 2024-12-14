package org.example.helpme.controller.global;

import lombok.RequiredArgsConstructor;
import org.example.helpme.config.JwtService;
import org.example.helpme.model.dto.QuestionDTO;
import org.example.helpme.repository.UserRepository;
import org.example.helpme.service.QuestionService;
import org.example.helpme.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/home/questions")
@RequiredArgsConstructor
public class Question {
  private final QuestionService questionService;
  private final UserService userService;
  private final UserRepository userRepository;
  private final JwtService jwtService;
  /*@GetMapping
  public Page<QuestionEntity> getQuestions(
          @RequestParam(value = "category", required = false) String categoryName,
          @RequestParam(value = "search", required = false) String searchKeyword,
          @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable
  ) {
    return questionService.getQuestions(categoryName, searchKeyword, pageable);
  }*/
  @GetMapping("/all")
  public ResponseEntity<Iterable<QuestionDTO>> getAllQuestions() {
    Iterable<QuestionDTO> questionDTOS = questionService.getAllQuestions();
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
  @GetMapping("/category/{category}")
  public ResponseEntity<Iterable<QuestionDTO>> getQuestionsByCategory(@PathVariable String category) {
    Iterable<QuestionDTO> questionDTOS = questionService.getQuestionsByCategory(category);
    return ResponseEntity.ok(questionDTOS);
  }
  @PostMapping("/add")
  public ResponseEntity<QuestionDTO> addQuestion(@RequestBody QuestionRequest questionRequest,@RequestHeader("Authorization") String token) {
    String jwt = token.substring(7);
    String username = jwtService.getUsername(jwt);
    Integer userId = Objects.requireNonNull(userRepository.findByEmail(username).orElse(null)).getUserId();
    QuestionDTO question = QuestionDTO.builder()
            .title(questionRequest.getTitle())
            .content(questionRequest.getContent())
            .userId(userId)
            .category(questionRequest.getCategory())
            .build();
    return ResponseEntity.ok(question);
  }
  @PutMapping("/update")
  public ResponseEntity<QuestionDTO> updateQuestion(@RequestBody QuestionDTO questionDTO) {
    QuestionDTO question = questionService.updateQuestion(questionDTO);
    return ResponseEntity.ok(question);
  }

}
