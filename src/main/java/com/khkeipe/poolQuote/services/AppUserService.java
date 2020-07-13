package com.khkeipe.poolQuote.services;

import com.khkeipe.poolQuote.dtos.AppUserDto;
import com.khkeipe.poolQuote.entities.AppUser;
import com.khkeipe.poolQuote.exceptions.NotFoundException;
import com.khkeipe.poolQuote.exceptions.ServerErrorException;
import com.khkeipe.poolQuote.repositories.AppUserRepository;
import com.khkeipe.poolQuote.util.GetList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppUserService {

    private AppUserRepository userRepo;

    @Autowired
    public AppUserService(AppUserRepository repo) {
        this.userRepo = repo;
    }


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

    public AppUserDto getUserById(int id) {
        AppUser user;
        try {
            user = userRepo.findById(id).get();
        } catch (Exception e) {
            throw new ServerErrorException("Internal server error occurred");
        }
        return new AppUserDto(user);
    }

}
