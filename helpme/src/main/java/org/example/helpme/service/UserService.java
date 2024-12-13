package org.example.helpme.service;

import org.example.helpme.mapper.UserMapper;
import org.example.helpme.model.dto.UserDTO;
import org.example.helpme.model.entity.UserEntity;
import org.example.helpme.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }
    public Iterable<UserDTO> getAllUsers() {
        List<UserEntity> users = userRepository.findAll();
        return users
                .stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }
    public void addUser(UserDTO user) {
        userRepository.save(userMapper.toEntity(user));
    }
    public void removeUser(UserDTO user) {
        userRepository.delete(userMapper.toEntity(user));
    }
    public void updateUser(UserDTO user) {
        userRepository.save(userMapper.toEntity(user));
    }
}
