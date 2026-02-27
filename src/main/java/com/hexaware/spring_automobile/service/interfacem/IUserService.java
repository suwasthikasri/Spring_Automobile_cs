package com.hexaware.spring_automobile.service.interfacem;

import java.util.List;


import com.hexaware.spring_automobile.entity.User;
public interface IUserService {
	int registerUser(User user);

    User getUserById(Long userId);

    User getUserByEmail(String email);

    int updateUser(User user);

    int deleteUser(Long userId);

    List<User> getAllUsers();

}
