package com.khkeipe.poolQuote.controllers;

import com.khkeipe.poolQuote.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class AppUserController {

    private AppUserService userService;

    @Autowired
    public AppUserController(AppUserService service) {
        this.userService = service;
    }

}