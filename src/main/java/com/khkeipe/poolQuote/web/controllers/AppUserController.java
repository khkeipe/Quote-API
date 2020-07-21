package com.khkeipe.poolQuote.web.controllers;

import com.khkeipe.poolQuote.dtos.AppUserDto;
import com.khkeipe.poolQuote.dtos.NewUser;
import com.khkeipe.poolQuote.entities.AppUser;
import com.khkeipe.poolQuote.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public AppUserDto getUserById(@PathVariable("id") int id) {
        return userService.getUserById(id);
    }

    @PostMapping("")
    public AppUserDto createUser(@RequestBody NewUser newUser) {
        return userService.createUser(newUser);
    }

    @PutMapping("")
    public AppUserDto updateUser(@RequestBody AppUser updatedUser) {
        return userService.updateUser(updatedUser);
    }

}
