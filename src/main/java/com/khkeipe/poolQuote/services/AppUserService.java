package com.khkeipe.poolQuote.services;

import com.khkeipe.poolQuote.dtos.AppUserDto;
import com.khkeipe.poolQuote.dtos.Credentials;
import com.khkeipe.poolQuote.dtos.NewUser;
import com.khkeipe.poolQuote.entities.AppUser;
import com.khkeipe.poolQuote.entities.PoolDealer;
import com.khkeipe.poolQuote.entities.UserRole;
import com.khkeipe.poolQuote.exceptions.*;
import com.khkeipe.poolQuote.repositories.AppUserRepository;
import com.khkeipe.poolQuote.repositories.DealerRepository;
import com.khkeipe.poolQuote.util.GetList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppUserService {

    private AppUserRepository userRepo;

    private DealerRepository dealerRepo;

    @Autowired
    public AppUserService(AppUserRepository userRepository, DealerRepository dealerRepository) {
        this.userRepo = userRepository;
        this.dealerRepo = dealerRepository;
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

    //TODO check for unique emails

    @Transactional
    public AppUserDto createUser(NewUser newUser) {

        if(     newUser.getEmail().trim().equals("") ||
                newUser.getPassword().trim().equals("") ||
                newUser.getEmail() == null ||
                newUser.getPassword() == null ||
                newUser.getRole() == null ||
                newUser.getDealerRep() <= 0
        ) {
            throw new BadRequestException("Please enter valid user information");
        }

        AppUser emailCheck = userRepo.findAppUserByEmail(newUser.getEmail());
        if(emailCheck != null) {
            throw new ConflictExecption("User with this email already exists");
        }

        AppUser user;

        try {

            PoolDealer dealer = dealerRepo.findPoolDealerById(newUser.getDealerRep());
            user = new AppUser(newUser.getEmail(), newUser.getPassword(), UserRole.getByName(newUser.getRole()), dealer);
            userRepo.save(user);

        } catch (Exception e) {
            throw new DataPercistanceExecption("User could not be created");
        }
        return new AppUserDto(user);

    }

    @Transactional
    public AppUserDto updateUser(AppUser updatedUser) {

        try {
            AppUser idCheck = userRepo.findById(updatedUser.getId()).get();
        } catch (Exception e) {
            throw new NotFoundException("No user found with id: " + updatedUser.getId());
        }
        AppUser emailCheck = userRepo.findAppUserByEmail(updatedUser.getEmail());
        if(emailCheck != null && updatedUser.getId() != emailCheck.getId()) {
            throw new ConflictExecption("User with this email already exists");
        }

        AppUser user = userRepo.save(updatedUser);

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
