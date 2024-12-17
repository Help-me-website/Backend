package org.example.helpme.controller.global.question;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.helpme.model.dto.CategoryDTO;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuestionResponse {
  private int id;
  private String title;
  private String content;
  private CategoryDTO category;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  private int views;
  private String firstName;
  private String lastName;
}
