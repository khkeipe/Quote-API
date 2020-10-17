package com.khkeipe.poolQuote.services;

import com.khkeipe.poolQuote.entities.Pool;
import com.khkeipe.poolQuote.exceptions.NotFoundException;
import com.khkeipe.poolQuote.exceptions.ServerErrorException;
import com.khkeipe.poolQuote.repositories.PoolRepository;
import com.khkeipe.poolQuote.util.GetList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//TODO crud

@Service
public class PoolService {

    private PoolRepository poolRepo;

    @Autowired
    public PoolService(PoolRepository repo) {
        this.poolRepo = repo;
    }

    public List<Pool> getAllPools() {
        Iterable<Pool> e;
        List<Pool> pools;
        try {
            e = poolRepo.findAll();
            pools = GetList.getListFromIterable(e);
        } catch (Exception exception) {
            throw new ServerErrorException();
        }
        if(pools.isEmpty()) {
            throw new NotFoundException("No pools were found");
        }
        return pools;
    }

    public Pool getPoolById(int id) {
        Pool pool = new Pool();
        try {
            pool = poolRepo.findById(id).get();
        } catch (Exception e) {
            throw new ServerErrorException();
        }
        return pool;
    }

    public Pool createPool(Pool newPool){
        try{
            poolRepo.save(newPool);
        } catch (Exception e) {
            throw new ServerErrorException("Pool was not saved");
        }
        return newPool;
    }

}
