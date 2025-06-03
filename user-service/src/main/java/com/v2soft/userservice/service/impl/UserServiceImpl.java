package com.v2soft.userservice.service.impl;

import com.v2soft.userservice.client.RoleClient;
import com.v2soft.userservice.dto.UserDTO;
import com.v2soft.userservice.entity.User;
import com.v2soft.userservice.repository.UserRepository;
import com.v2soft.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleClient roleClient;

    @Override
    public UserDTO create(UserDTO dto) {
        User user = User.builder()
                .username(dto.getUsername())
                .email(dto.getEmail())
                .roleIds(dto.getRoleIds())
                .build();
        return mapToDTO(userRepository.save(user));
    }

    @Override
    public UserDTO update(Long id, UserDTO dto) {
        User user = userRepository.findById(id).orElseThrow();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setRoleIds(dto.getRoleIds());
        return mapToDTO(userRepository.save(user));
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDTO getById(Long id) {
        return mapToDTO(userRepository.findById(id).orElseThrow());
    }

    @Override
    public List<UserDTO> getAll() {
        return userRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private UserDTO mapToDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .roleIds(user.getRoleIds())
                .build();
    }
}
