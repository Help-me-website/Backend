package org.example.helpme.services;

import org.example.helpme.model.entity.UserEntity;
import org.example.helpme.repository.UserRepository;

public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public Iterable<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }
    public void addUser(UserEntity userDTO) {
        userRepository.save(userDTO);
    }
    public void removeUser(UserEntity userDTO) {
        userRepository.delete(userDTO);
    }
    public void updateUser(UserEntity userDTO) {
        userRepository.save(userDTO);
    }
}
