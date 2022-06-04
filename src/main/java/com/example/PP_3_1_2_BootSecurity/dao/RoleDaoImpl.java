package com.example.PP_3_1_2_BootSecurity.dao;

import com.example.PP_3_1_2_BootSecurity.model.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Role> getAllRoles() {
        return entityManager.createQuery("from Role", Role.class).getResultList();
    }

    @Override
    public Role findById(Long id) {
        return entityManager.createQuery("SELECT role FROM Role role where role.id=:id", Role.class)
                .setParameter("id", id).getSingleResult();
    }

    @Override
    public void saveRole(Role role) {
        entityManager.persist(role);
    }
}
