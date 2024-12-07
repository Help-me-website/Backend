package org.example.helpme.services;

import org.example.helpme.domain.Entities.UserEntity;
import org.example.helpme.repositories.UserRepo;

public class UserService {
    private final UserRepo userRepo;
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    public Iterable<UserEntity> getAllUsers() {
        return userRepo.findAll();
    }
    public void addUser(UserEntity userDTO) {
        userRepo.save(userDTO);
    }
    public void removeUser(UserEntity userDTO) {
        userRepo.delete(userDTO);
    }
    public void updateUser(UserEntity userDTO) {
        userRepo.save(userDTO);
    }
}
