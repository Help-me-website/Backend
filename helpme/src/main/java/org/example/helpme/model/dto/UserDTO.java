package org.example.helpme.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO implements Serializable {
    private Integer userId;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDateTime createdAt;
    private Boolean isActive;
    private String role;
    private String bio;
    private String profilePicture;
}
