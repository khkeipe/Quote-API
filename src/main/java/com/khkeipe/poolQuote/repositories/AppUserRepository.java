package com.khkeipe.poolQuote.repositories;

import com.khkeipe.poolQuote.entities.AppUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends CrudRepository<AppUser, Integer> {

    AppUser findAppUserByEmailAndPassword(String email, String password);

    AppUser findAppUserByEmail(String email);
}
