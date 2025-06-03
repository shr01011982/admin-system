package com.v2soft.permissionservice.controller;


import com.v2soft.permissionservice.dto.PermissionDTO;
import com.v2soft.permissionservice.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permissions")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @PostMapping
    public PermissionDTO create(@RequestBody PermissionDTO dto) {
        return permissionService.create(dto);
    }

    @PutMapping("/{id}")
    public PermissionDTO update(@PathVariable Long id, @RequestBody PermissionDTO dto) {
        return permissionService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        permissionService.delete(id);
    }

    @GetMapping("/{id}")
    public PermissionDTO getById(@PathVariable Long id) {
        return permissionService.getById(id);
    }

    @GetMapping
    public List<PermissionDTO> getAll() {
        return permissionService.getAll();
    }
}

