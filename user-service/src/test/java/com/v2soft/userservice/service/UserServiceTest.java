package com.v2soft.userservice.service;

import com.v2soft.userservice.client.RoleClient;
import com.v2soft.userservice.dto.UserDTO;
import com.v2soft.userservice.entity.User;
import com.v2soft.userservice.repository.UserRepository;
import com.v2soft.userservice.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private RoleClient roleClient;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateUser() {
        UserDTO dto = UserDTO.builder().username("john").email("john@example.com").roleIds(List.of(1L)).build();
        User saved = User.builder().id(1L).username("john").email("john@example.com").roleIds(List.of(1L)).build();

        when(userRepository.save(any())).thenReturn(saved);

        UserDTO result = userService.create(dto);

        assertNotNull(result);
        assertEquals("john", result.getUsername());
        verify(userRepository, times(1)).save(any());
    }

    @Test
    void testGetById() {
        User user = User.builder().id(1L).username("alice").email("alice@example.com").roleIds(List.of(2L)).build();
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        UserDTO result = userService.getById(1L);

        assertEquals("alice", result.getUsername());
        assertEquals("alice@example.com", result.getEmail());
    }
}
