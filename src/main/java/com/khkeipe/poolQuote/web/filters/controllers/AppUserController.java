package com.khkeipe.poolQuote.web.filters.controllers;

import com.khkeipe.poolQuote.dtos.AppUserDto;
import com.khkeipe.poolQuote.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class AppUserController {

    private AppUserService userService;

    @Autowired
    public AppUserController(AppUserService service) {
        this.userService = service;
    }

    @GetMapping("")
    public List<AppUserDto> getAllUsers() {
        return userService.getAllUsers();
    }

}
