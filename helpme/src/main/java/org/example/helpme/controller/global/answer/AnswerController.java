package org.example.helpme.controller.global.answer;

import lombok.RequiredArgsConstructor;
import org.example.helpme.config.JwtService;
import org.example.helpme.controller.global.question.QuestionRequest;
import org.example.helpme.controller.user.User;
import org.example.helpme.model.dto.AnswerDTO;
import org.example.helpme.model.dto.QuestionDTO;
import org.example.helpme.repository.UserRepository;
import org.example.helpme.service.AnswerService;
import org.example.helpme.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/home/answers")
@RequiredArgsConstructor
public class AnswerController {
  private final AnswerService answerService;
  private final UserService userService;
  private final UserRepository userRepository;
  private final JwtService jwtService;

  @GetMapping("/by-question/{questionId}")
  public ResponseEntity<Iterable<AnswerDTO>> getAnswersByQuestionId(@PathVariable Integer questionId) {
    Iterable<AnswerDTO> answerDTOS = answerService.getAnswersByQuestionId(questionId);
    return ResponseEntity.ok(answerDTOS);
  }
  @GetMapping("/{id}")
  public ResponseEntity<AnswerDTO> getAnswerById(@PathVariable Integer id) {
    AnswerDTO answerDTO = answerService.getById(id);
    if(answerDTO == null){
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(answerDTO);
  }

  @PostMapping("/modify/add")
  public ResponseEntity<AnswerDTO> addQuestion(@RequestBody AnswerRequest answerRequest, @RequestHeader("Authorization") String token){
    String jwt = token.substring(7);
    String username = jwtService.getUsername(jwt);
    Integer userId = Objects.requireNonNull(userRepository.findByEmail(username).orElse(null)).getUserId();
    AnswerDTO answer = AnswerDTO.builder()
            .content(answerRequest.getContent())
            .questionId(answerRequest.getQuestionId())
            .userId(userId)
            .build();
    answer = answerService.saveAnswer(answer);
    return ResponseEntity.ok(answer);
  }

  @PutMapping("/modify/update")
  public ResponseEntity<AnswerDTO> updateAnswer(@RequestBody AnswerDTO answerDTO) {
    AnswerDTO answer = answerService.updateAnswer(answerDTO);
    return ResponseEntity.ok(answer);
  }

  @DeleteMapping("/modify/delete/{id}")
  public ResponseEntity<String> deleteAnswer(@PathVariable Integer id) {
    answerService.deleteAnswer(id);
    return ResponseEntity.ok("Answer deleted successfully");
  }

  @PostMapping("/accept/{id}")
  public ResponseEntity<String> acceptAnswer(@PathVariable Integer id,@RequestHeader("Authorization") String token) {
    String jwt = token.substring(7);
    String username = jwtService.getUsername(jwt);
    answerService.acceptAnswer(id, username);
    return ResponseEntity.ok("Answer marked as accepted.");
  }
}
