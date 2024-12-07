package org.example.helpme.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int reputation;
}
