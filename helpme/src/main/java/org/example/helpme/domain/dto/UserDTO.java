package org.example.helpme.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int reputation;
}