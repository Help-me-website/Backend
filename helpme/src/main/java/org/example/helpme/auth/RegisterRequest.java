package org.example.helpme.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Component
public class RegisterRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
