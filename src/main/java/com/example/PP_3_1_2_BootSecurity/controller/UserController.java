package com.example.PP_3_1_2_BootSecurity.controller;

import com.example.PP_3_1_2_BootSecurity.model.User;
import com.example.PP_3_1_2_BootSecurity.service.RoleService;
import com.example.PP_3_1_2_BootSecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import org.springframework.security.core.context.SecurityContextHolder;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/user")
    public String getCurrentUserInfo(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        return "show";
    }

    @GetMapping("/admin/users")
    public String showAllUsers(Model model) {
        model.addAttribute("usersList", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/admin/users/{id}")
    public String showUserById(@PathVariable("id") Long id, Model model) {
        User user = userService.getById(id);
        model.addAttribute("user", user);
        return "show";
    }

    @GetMapping("/admin/users/add")
    public String newUser(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("allRoles", roleService.getAllRoles());
        return "add";
    }

    @PostMapping("/admin/users")
    public String createUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult,
                             @RequestParam(value = "index", required = false) Long[] index) {
        if (bindingResult.hasErrors()) {
            return "add";
        }
        if (index != null) {
            for (Long id : index) {
                user.addRole(roleService.findById(id));
            }
        } else {
            user.addRole(roleService.findById(2L));
        }
        userService.save(user);
        return "redirect:/admin/users";
    }

    @GetMapping("/admin/users/{id}/edit")
    public String editUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("allRoles", roleService.getAllRoles());
        model.addAttribute("user", userService.getById(id));
        return "edit";
    }

    @PatchMapping("/admin/users/{id}")
    public String updateUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult,
                             @RequestParam(value = "index", required = false) Long[] index) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }

        if (index != null) {
            for (Long id : index) {
                user.addRole(roleService.findById(id));
            }
        } else {
            user.addRole(roleService.findById(2L));
        }
        userService.update(user);
        return "redirect:/admin/users";
    }

    @DeleteMapping("/admin/users/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/admin/users";
    }
}
