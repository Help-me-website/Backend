package org.example.helpme.service;

import org.example.helpme.controller.user.UserUpdate;
import org.example.helpme.model.dto.UserDTO;

import java.util.Optional;

public interface UserService {
    public Iterable<UserDTO> getAllUsers();
    public UserDTO getUserById(Integer id);
    public UserDTO saveUser(UserDTO userDTO);
    public void deleteUser(String username);
    public UserDTO loadUserByEmail(String email);
    public Optional<UserDTO> updateUser(String username, UserDTO updatedUser);
    public Optional<UserDTO> updateUser(String username, UserUpdate updatedUser);
}
