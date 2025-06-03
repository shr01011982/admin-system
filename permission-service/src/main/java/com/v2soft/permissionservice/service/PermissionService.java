package com.v2soft.permissionservice.service;

import com.v2soft.permissionservice.dto.PermissionDTO;
import java.util.List;

public interface PermissionService {
    PermissionDTO create(PermissionDTO dto);
    PermissionDTO update(Long id, PermissionDTO dto);
    void delete(Long id);
    PermissionDTO getById(Long id);
    List<PermissionDTO> getAll();
}