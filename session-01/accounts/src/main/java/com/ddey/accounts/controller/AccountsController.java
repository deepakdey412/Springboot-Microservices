package com.ddey.accounts.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/api/accounts")
public class AccountsController {

    @GetMapping("/msg")
    public String msg(){
        return "Welcome to micro-services...Deepak!";
    }

}
