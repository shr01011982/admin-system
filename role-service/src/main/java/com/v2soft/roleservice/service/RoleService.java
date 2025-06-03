package com.v2soft.roleservice.service;

import com.v2soft.roleservice.dto.RoleDTO;
import java.util.List;

public interface RoleService {
    RoleDTO create(RoleDTO dto);
    RoleDTO update(Long id, RoleDTO dto);
    void delete(Long id);
    RoleDTO getById(Long id);
    List<RoleDTO> getAll();
}
