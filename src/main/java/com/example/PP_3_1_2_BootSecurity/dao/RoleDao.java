package com.example.PP_3_1_2_BootSecurity.dao;

import com.example.PP_3_1_2_BootSecurity.model.Role;

import java.util.List;

public interface RoleDao {
    List<Role> getAllRoles();

    Role findById(Long id);

    void saveRole(Role role);
}
