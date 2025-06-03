package com.v2soft.permissionservice.service;

import com.v2soft.permissionservice.dto.PermissionDTO;
import com.v2soft.permissionservice.entity.Permission;
import com.v2soft.permissionservice.repository.PermissionRepository;
import com.v2soft.permissionservice.service.impl.PermissionServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PermissionServiceTest {

    @InjectMocks
    private PermissionServiceImpl permissionService;

    @Mock
    private PermissionRepository permissionRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreatePermission() {
        PermissionDTO dto = PermissionDTO.builder().name("CREATE_USER").build();
        Permission savedPermission = Permission.builder().id(1L).name("CREATE_USER").build();

        when(permissionRepository.save(any(Permission.class))).thenReturn(savedPermission);

        PermissionDTO result = permissionService.create(dto);

        assertNotNull(result);
        assertEquals("CREATE_USER", result.getName());
        verify(permissionRepository, times(1)).save(any(Permission.class));
    }

    @Test
    void testGetById() {
        Permission permission = Permission.builder().id(1L).name("VIEW_USER").build();
        when(permissionRepository.findById(1L)).thenReturn(Optional.of(permission));

        PermissionDTO result = permissionService.getById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("VIEW_USER", result.getName());
        verify(permissionRepository, times(1)).findById(1L);
    }
}
