package com.khkeipe.poolQuote.services;

import com.khkeipe.poolQuote.dtos.AppUserDto;
import com.khkeipe.poolQuote.dtos.Credentials;
import com.khkeipe.poolQuote.dtos.NewUser;
import com.khkeipe.poolQuote.entities.AppUser;
import com.khkeipe.poolQuote.exceptions.*;
import com.khkeipe.poolQuote.repositories.AppUserRepository;
import com.khkeipe.poolQuote.util.GetList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppUserService {

    private AppUserRepository userRepo;

    @Autowired
    public AppUserService(AppUserRepository repo) {
        this.userRepo = repo;
    }

    @Transactional(readOnly = true)
    public List<AppUserDto> getAllUsers() {
        List<AppUserDto> dtos = new ArrayList<>();
        List<AppUser> users;
        Iterable<AppUser> e;
        try {
            e = userRepo.findAll();
            users = GetList.getListFromIterable(e);
        } catch (Exception exception) {
            throw new ServerErrorException("Internal server error occurred, unable to fetch users");
        }
        if(users.isEmpty()) {
            throw new NotFoundException("No users were found");
        } else {

            for (AppUser user : users) {
                dtos.add(new AppUserDto(user));
            }
        }
        return dtos;
    }

    @Transactional(readOnly = true)
    public AppUserDto getUserById(int id) {
        AppUser user;
        try {
            user = userRepo.findById(id).get();
        } catch (Exception e) {
            throw new ServerErrorException("Internal server error occurred");
        }
        return new AppUserDto(user);
    }

    @Transactional
    public AppUserDto createUser(NewUser newUser) {
        AppUser user;

        AppUser emailCheck = userRepo.findAppUserByEmail(newUser.getEmail());
        if(emailCheck != null) {
            throw new ConflictExecption("User with this email already exists");
        }
        if(!newUser.getPassword().equals(newUser.getPasswordVerification())) {
            throw new ConflictExecption("Passwords do not match");
        }

        try {
            user = new AppUser(newUser);
            userRepo.save(user);
        } catch (Exception e) {
            throw new DataPercistanceExecption("User could not be created");
        }
        return new AppUserDto(user);
    }

    @Transactional
    public AppUserDto authenticate(Credentials creds) {
        AppUser user;
            if(creds.getEmail().trim().equals("") || creds.getPassword().trim().equals("")) {
                throw new BadRequestException("Please enter email and password");
            }
        try {
            user = userRepo.findAppUserByEmailAndPassword(creds.getEmail(), creds.getPassword());
            if(user == null) {
                throw new NotFoundException("No user found with provided email and password");
            }
        } catch (Exception e) {
            throw new NotFoundException("No user found with provided email and password");
        }

        return new AppUserDto(user);
    }

}
