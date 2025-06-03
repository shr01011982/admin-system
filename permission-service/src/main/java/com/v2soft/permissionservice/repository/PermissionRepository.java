package com.v2soft.permissionservice.repository;

import com.v2soft.permissionservice.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
}