package com.v2soft.roleservice.service.impl;

import com.v2soft.roleservice.client.PermissionClient;
import com.v2soft.roleservice.dto.RoleDTO;
import com.v2soft.roleservice.entity.Role;
import com.v2soft.roleservice.repository.RoleRepository;
import com.v2soft.roleservice.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PermissionClient permissionClient;

    @Override
    public RoleDTO create(RoleDTO dto) {
        Role role = Role.builder()
                .name(dto.getName())
                .permissionIds(dto.getPermissionIds())
                .build();
        return mapToDTO(roleRepository.save(role));
    }

    @Override
    public RoleDTO update(Long id, RoleDTO dto) {
        Role role = roleRepository.findById(id).orElseThrow();
        role.setName(dto.getName());
        role.setPermissionIds(dto.getPermissionIds());
        return mapToDTO(roleRepository.save(role));
    }

    @Override
    public void delete(Long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public RoleDTO getById(Long id) {
        return mapToDTO(roleRepository.findById(id).orElseThrow());
    }

    @Override
    public List<RoleDTO> getAll() {
        return roleRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    private RoleDTO mapToDTO(Role role) {
        return RoleDTO.builder()
                .id(role.getId())
                .name(role.getName())
                .permissionIds(role.getPermissionIds())
                .build();
    }
}
