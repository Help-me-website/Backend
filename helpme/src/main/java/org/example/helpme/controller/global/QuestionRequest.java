package org.example.helpme.controller.global;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuestionRequest {
    private String title;
    private String content;
    private String username;
    private String category;

}
