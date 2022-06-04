package com.example.PP_3_1_2_BootSecurity.dao;

import com.example.PP_3_1_2_BootSecurity.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public User getById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User getByLogin(String email) {
        return entityManager.createQuery("SELECT user FROM User user WHERE user.email=:email", User.class)
                .setParameter("email", email).getSingleResult();
    }

    @Override
    public void update(User updateUser) {
        entityManager.merge(updateUser);
    }

    @Override
    public void save(User user) {
        if (entityManager.contains(user)) {
            entityManager.persist(user);
        } else {
            entityManager.merge(user);
        }
    }

    @Override
    public void delete(Long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }
}
