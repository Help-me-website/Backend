package org.example.helpme.controller.user;

import lombok.RequiredArgsConstructor;
import org.example.helpme.config.JwtService;
import org.example.helpme.model.dto.UserDTO;
import org.example.helpme.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class User {
    private final UserService userService;
    private final JwtService jwtService;
    // ======= Group 1: User Profile =======
    @GetMapping("/profile")
    public ResponseEntity<UserDTO> getUserProfile(@RequestHeader("Authorization") String token) {
        String jwt = token.substring(7);
        String username = jwtService.getUsername(jwt);
        UserDTO userDTO = userService.loadUserByEmail(username);
        return ResponseEntity.ok(userDTO);
    }

    @PutMapping("/profile")
    public ResponseEntity<UserDTO> updateUser(
            @RequestHeader("Authorization") String token,
            @RequestBody UserDTO updatedUser)
    {
        String jwt = token.substring(7);
        String username = jwtService.getUsername(jwt);
        UserDTO userDTO = userService.updateUser(username, updatedUser).orElse(null);
      assert userDTO != null;
      return ResponseEntity.ok(userDTO);
    }
    @DeleteMapping("/profile")
    public ResponseEntity<Void> deleteUser(
            @RequestHeader("Authorization") String token
    ) {
        String jwt = token.substring(7);
        String username = jwtService.getUsername(jwt);
        userService.deleteUser(username);
        return ResponseEntity.ok().build();
    }


}
