package com.v2soft.userservice.service;

import com.v2soft.userservice.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO create(UserDTO dto);
    UserDTO update(Long id, UserDTO dto);
    void delete(Long id);
    UserDTO getById(Long id);
    List<UserDTO> getAll();
}
