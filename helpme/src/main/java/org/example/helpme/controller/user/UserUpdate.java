package org.example.helpme.controller.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserUpdate {
  String firstname;
  String lastname;
}
