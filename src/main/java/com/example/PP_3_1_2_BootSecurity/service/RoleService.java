package com.example.PP_3_1_2_BootSecurity.service;

import com.example.PP_3_1_2_BootSecurity.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();

    Role findById(Long id);

    void saveRole(Role role);
}
