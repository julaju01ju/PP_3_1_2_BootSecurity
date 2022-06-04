package com.example.PP_3_1_2_BootSecurity.util;

import com.example.PP_3_1_2_BootSecurity.model.Role;
import com.example.PP_3_1_2_BootSecurity.model.User;
import com.example.PP_3_1_2_BootSecurity.service.RoleService;
import com.example.PP_3_1_2_BootSecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

@Component
public class DataInit {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @PostConstruct
    private void init() {
        Role role1 = new Role("ADMIN");
        Role role2 = new Role("USER");
        roleService.saveRole(role1);
        roleService.saveRole(role2);

        User user0 = new User();
        user0.setEmail("admin@mail.com");
        user0.setPassword("admin");
        user0.setName("Admin");
        user0.setAge((byte) 24);
        user0.addRole(role1);

        User user1 = new User();
        user1.setEmail("user@mail.com");
        user1.setPassword("user");
        user1.setName("User");
        user1.setAge((byte) 24);
        user1.addRole(role2);

        User user2 = new User();
        user2.setEmail("moderator@mail.com");
        user2.setPassword("moderator");
        user2.setName("Moderator");
        user2.setAge((byte) 24);
        user2.addRole(role1);
        user2.addRole(role2);

        userService.save(user0);
        userService.save(user1);
        userService.save(user2);
    }
}