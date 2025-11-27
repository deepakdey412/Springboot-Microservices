package com.deepak.User_Service.service;

import com.deepak.User_Service.entity.Users;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    Users save(Users users);
    Optional<Users> findUser(Long id);
    List<Users> findAll();
    Users update(Long id , Users users);
    String delete(Long id);
}
