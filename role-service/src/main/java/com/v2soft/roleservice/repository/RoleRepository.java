package com.v2soft.roleservice.repository;

import com.v2soft.roleservice.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
