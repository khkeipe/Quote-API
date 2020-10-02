package com.khkeipe.poolQuote.web.controllers;

import com.khkeipe.poolQuote.dtos.AppUserDto;
import com.khkeipe.poolQuote.dtos.Credentials;
import com.khkeipe.poolQuote.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://khkeipe-pool-quote.s3-website-us-east-1.amazonaws.com/")
public class AuthController {

    private AppUserService userService;

    @Autowired
    public AuthController(AppUserService service)  {
        this.userService = service;
    }

    @PostMapping("")
    public AppUserDto authenticate(@RequestBody Credentials creds) {
        return userService.authenticate(creds);
    }
}
