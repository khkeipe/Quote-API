package com.khkeipe.poolQuote.services;

import com.khkeipe.poolQuote.repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserService {

    private AppUserRepository userRepo;

    @Autowired
    public AppUserService(AppUserRepository repo) {
        this.userRepo = repo;
    }



}
