package org.example.helpme.repositories;

import org.example.helpme.domain.dto.UserDTO;

public interface UserInterface {
    public void addUser(UserDTO userDTO);
    public void removeUser(UserDTO userDTO);
    public void updateUser(UserDTO userDTO);
}
