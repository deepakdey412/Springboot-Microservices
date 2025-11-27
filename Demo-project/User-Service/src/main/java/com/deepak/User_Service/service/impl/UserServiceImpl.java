package com.deepak.User_Service.service.impl;

import com.deepak.User_Service.entity.Users;
import com.deepak.User_Service.exception.UserAlreadyExists;
import com.deepak.User_Service.exception.UserNotFound;
import com.deepak.User_Service.repository.UserRepository;
import com.deepak.User_Service.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Users save(Users users) {
        Optional<Users> optionalUsers = userRepository.findByUsername(users.getUsername());
        if (optionalUsers.isPresent()) {
            throw new UserAlreadyExists("User already exists");
        }
        return userRepository.save(users);
    }

    @Override
    public Optional<Users> findUser(Long id) {
        Optional<Users> optionalUsers = userRepository.findById(id);
        if (!optionalUsers.isPresent()) {
            throw new UserNotFound("User not found");
        }
        return optionalUsers;
    }

    @Override
    public List<Users> findAll() {
        List<Users> users = userRepository.findAll();
        if (users.isEmpty()) {
            throw new UserNotFound("User not found");
        }
        return users;
    }

    @Override
    public Users update(Long id, Users users) {
        Optional<Users> optionalUsers = userRepository.findById(id);
        if (!optionalUsers.isPresent()) {
            throw new UserNotFound("User not found");
        }
        optionalUsers.get().setUsername(users.getUsername());
        optionalUsers.get().setEmail(users.getEmail());
        optionalUsers.get().setPassword(users.getPassword());
        return userRepository.save(optionalUsers.get());
    }

    @Override
    public String delete(Long id) {
        Optional<Users> optionalUsers = userRepository.findById(id);
        if (!optionalUsers.isPresent()) {
            throw new UserNotFound("User not found");
        }else {
            userRepository.delete(optionalUsers.get());
        }
        return "User has been deleted";
    }
}
