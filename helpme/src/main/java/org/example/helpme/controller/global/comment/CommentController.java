package org.example.helpme.controller.global.comment;

import lombok.RequiredArgsConstructor;
import org.example.helpme.config.JwtService;
import org.example.helpme.model.dto.CommentDTO;
import org.example.helpme.repository.UserRepository;
import org.example.helpme.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;


@RequiredArgsConstructor
@RestController
@RequestMapping("/home/comments")
public class CommentController {
  private final CommentService commentService;
  private final UserRepository userRepository;
  private final JwtService jwtService;

  @GetMapping("/by-answer/{answerId}")
  public ResponseEntity<Iterable<CommentDTO>> getCommentsByAnswerId(@PathVariable Integer answerId) {
    Iterable<CommentDTO> commentDTOS = commentService.getCommentsByAnswerId(answerId);
    return ResponseEntity.ok(commentDTOS);
  }

  @GetMapping("/{id}")
  public ResponseEntity<CommentDTO> getCommentById(@PathVariable Integer id) {
    CommentDTO commentDTO = commentService.getCommentById(id);
    return ResponseEntity.ok(commentDTO);
  }

  @PostMapping("/modify/add")
  public ResponseEntity<CommentDTO> addComment(@RequestBody CommentRequest commentRequest, @RequestHeader("Authorization") String token) {
    String jwt = token.substring(7);
    String username = jwtService.getUsername(jwt);
    Integer userId = Objects.requireNonNull(userRepository.findByEmail(username).orElse(null)).getUserId();
    CommentDTO commentDTO = CommentDTO.builder()
            .content(commentRequest.getContent())
            .answerId(commentRequest.getAnswerId())
            .userId(userId)
            .build();
    commentDTO = commentService.createComment(commentDTO);
    return ResponseEntity.ok(commentDTO);
  }

  @PutMapping("/modify/update")
  public ResponseEntity<CommentDTO> updateComment(@RequestBody CommentDTO commentDTO) {
    CommentDTO comment = commentService.updateComment(commentDTO);
    return ResponseEntity.ok(comment);
  }

  @DeleteMapping("/modify/delete/{id}")
  public ResponseEntity<Void> deleteComment(@PathVariable Integer id) {
    commentService.deleteComment(id);
    return ResponseEntity.ok().build();
  }

}
