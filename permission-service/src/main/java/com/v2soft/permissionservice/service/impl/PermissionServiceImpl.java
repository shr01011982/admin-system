package com.v2soft.permissionservice.service.impl;

import com.v2soft.permissionservice.dto.PermissionDTO;
import com.v2soft.permissionservice.entity.Permission;
import com.v2soft.permissionservice.repository.PermissionRepository;
import com.v2soft.permissionservice.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public PermissionDTO create(PermissionDTO dto) {
        Permission permission = Permission.builder()
                .name(dto.getName())
                .build();
        Permission saved = permissionRepository.save(permission);
        return mapToDTO(saved);
    }

    @Override
    public PermissionDTO update(Long id, PermissionDTO dto) {
        Permission permission = permissionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Permission not found"));
        permission.setName(dto.getName());
        return mapToDTO(permissionRepository.save(permission));
    }

    @Override
    public void delete(Long id) {
        permissionRepository.deleteById(id);
    }

    @Override
    public PermissionDTO getById(Long id) {
        Permission permission = permissionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Permission not found"));
        return mapToDTO(permission);
    }

    @Override
    public List<PermissionDTO> getAll() {
        return permissionRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private PermissionDTO mapToDTO(Permission permission) {
        return PermissionDTO.builder()
                .id(permission.getId())
                .name(permission.getName())
                .build();
    }
}
