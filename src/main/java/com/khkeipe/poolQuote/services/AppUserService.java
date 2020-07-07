package com.khkeipe.poolQuote.services;

import com.khkeipe.poolQuote.dtos.AppUserDto;
import com.khkeipe.poolQuote.entities.AppUser;
import com.khkeipe.poolQuote.repositories.AppUserRepository;
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
        Iterable<AppUser> e = userRepo.findAll();
        List<AppUser> users = getListFromIterable(e);
        for(AppUser user : users) {
            dtos.add(new AppUserDto(user));
        }
        return dtos;
    }

    public static <T> List<T> getListFromIterable(Iterable<T> e) {
        List<T> list = new ArrayList<>();
        e.forEach(list::add);
        return list;
    }

}
