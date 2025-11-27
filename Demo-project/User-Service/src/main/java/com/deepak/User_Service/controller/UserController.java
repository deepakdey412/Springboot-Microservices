package com.deepak.User_Service.controller;

import com.deepak.User_Service.entity.Users;
import com.deepak.User_Service.service.IUserService;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/users" , produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/save")
    public Users saveUser(@RequestBody Users user){
        return userService.save(user);
    }

    @GetMapping("/get/{id}")
    public Optional<Users> getUser(@PathVariable Long id){
        return userService.findUser(id);
    }

    @GetMapping("/getAll")
    public List<Users> getAll(){
        return userService.findAll();
    }

    @PutMapping("/update/{id}")
    public Users updateUser(@PathVariable Long id ,@RequestBody Users user){
        return userService.update(id, user);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id){
        return userService.delete(id);
    }

}
