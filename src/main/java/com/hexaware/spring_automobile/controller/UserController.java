package com.hexaware.spring_automobile.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.hexaware.spring_automobile.config.JwtUtil;
import com.hexaware.spring_automobile.entity.UserEntity;
import com.hexaware.spring_automobile.pojo.User;
import com.hexaware.spring_automobile.service.interfaces.IUserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    // Anyone can register
    @PostMapping("/register")
    public int registerUser(@Valid @RequestBody User user) {
        return userService.registerUser(user);
    }

    // Anyone can login
    @PostMapping("/login")
    public String loginUser(@RequestParam String email,
                            @RequestParam String password) {

        UserEntity user = userService.loginUser(email, password);

        return jwtUtil.generateToken(email, user.getRole().name());
    }

    // USER and OFFICER can view user details
    @PreAuthorize("hasAnyRole('USER','OFFICER')")
    @GetMapping("/{userId}")
    public UserEntity getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    // Only OFFICER can view all users
    @PreAuthorize("hasRole('OFFICER')")
    @GetMapping("/all")
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    // USER and OFFICER can update user
    @PreAuthorize("hasAnyRole('USER','OFFICER')")
    @PutMapping("/update")
    public int updateUser(@Valid @RequestBody User user) {
        return userService.updateUser(user);
    }

    // Only OFFICER can search user by email
    @PreAuthorize("hasRole('OFFICER')")
    @GetMapping("/email/{email}")
    public UserEntity findUserByEmail(@PathVariable String email) {
        return userService.findUserByEmail(email);
    }
}