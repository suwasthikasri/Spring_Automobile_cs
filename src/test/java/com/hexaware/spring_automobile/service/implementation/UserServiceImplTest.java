package com.hexaware.spring_automobile.service.implementation;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Optional;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.hexaware.spring_automobile.entity.UserEntity;
import com.hexaware.spring_automobile.pojo.User;
import com.hexaware.spring_automobile.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void testRegisterUser() {

        User user = new User();
        user.setUsername("john");
        user.setEmail("john@gmail.com");
        user.setPasswordHash("12345");
        user.setFullName("John Doe");
        user.setAddress("Chennai");
        user.setPhoneNumber("9876543210");

        int result = userService.registerUser(user);

        assertEquals(1, result);

        verify(userRepository, times(1))
                .save(any(UserEntity.class));
    }

    @Test
    void testLoginUserSuccess() {

        UserEntity entity = new UserEntity();
        entity.setEmail("john@gmail.com");
        entity.setPasswordHash("12345");

        when(userRepository.findByEmail("john@gmail.com")).thenReturn(entity);

        UserEntity result = userService.loginUser("john@gmail.com", "12345");

        assertEquals("john@gmail.com", result.getEmail());
    }

    @Test
    void testGetUserById() {

        UserEntity user = new UserEntity();
        user.setUserId(1L);

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        UserEntity result = userService.getUserById(1L);

        assertEquals(1L, result.getUserId());
    }

    @Test
    void testGetAllUsers() {

        UserEntity u1 = new UserEntity();
        UserEntity u2 = new UserEntity();

        when(userRepository.findAll()).thenReturn(Arrays.asList(u1, u2));

        List<UserEntity> result = userService.getAllUsers();

        assertEquals(2, result.size());
    }

    @Test
    void testUpdateUser() {

        User user = new User();
        user.setUserId(1L);
        user.setFullName("Updated Name");
        user.setAddress("New Address");
        user.setPhoneNumber("9999999999");

        UserEntity entity = new UserEntity();
        entity.setUserId(1L);

        when(userRepository.findById(1L)).thenReturn(Optional.of(entity));

        int result = userService.updateUser(user);

        assertEquals(1, result);

        verify(userRepository, times(1)).save(entity);
    }

}