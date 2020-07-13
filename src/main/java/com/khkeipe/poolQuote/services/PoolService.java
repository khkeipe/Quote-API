package com.khkeipe.poolQuote.services;

import com.khkeipe.poolQuote.repositories.PoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PoolService {

    private PoolRepository poolRepo;

    @Autowired
    public PoolService(PoolRepository repo) {
        this.poolRepo = repo;
    }


}
