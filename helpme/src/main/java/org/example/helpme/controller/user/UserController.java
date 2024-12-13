package org.example.helpme.controller.user;

import lombok.RequiredArgsConstructor;
import org.example.helpme.model.dto.UserDTO;
import org.example.helpme.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/profile")
    public ResponseEntity<UserDTO> getUserProfile(@AuthenticationPrincipal UserDTO user) {
        UserDTO profile = userService.getUserProfile(user);
        return ResponseEntity.ok(profile);
    }

    @PutMapping("profile/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Integer id, @RequestBody UserDTO userDTO) {
        Optional<UserDTO> updatedUser = userService.updateUser(id, userDTO);
        return updatedUser.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("profile/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        userService.removeUser(id);
        return ResponseEntity.noContent().build();
    }
}
