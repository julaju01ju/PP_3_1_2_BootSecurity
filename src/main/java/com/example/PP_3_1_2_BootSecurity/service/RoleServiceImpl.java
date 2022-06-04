package com.example.PP_3_1_2_BootSecurity.service;

import com.example.PP_3_1_2_BootSecurity.dao.RoleDao;
import com.example.PP_3_1_2_BootSecurity.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleDao roleDao;

    @Override
    @Transactional
    public List<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }

    @Override
    @Transactional
    public Role findById(Long id) {
        return roleDao.findById(id);
    }

    @Override
    public void saveRole(Role role) {
        roleDao.saveRole(role);
    }
}
