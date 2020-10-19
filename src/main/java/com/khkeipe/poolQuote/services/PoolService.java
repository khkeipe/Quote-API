package com.khkeipe.poolQuote.services;

import com.khkeipe.poolQuote.entities.Pool;
import com.khkeipe.poolQuote.exceptions.BadRequestException;
import com.khkeipe.poolQuote.exceptions.DataPercistanceExecption;
import com.khkeipe.poolQuote.exceptions.NotFoundException;
import com.khkeipe.poolQuote.exceptions.ServerErrorException;
import com.khkeipe.poolQuote.repositories.PoolRepository;
import com.khkeipe.poolQuote.util.GetList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PoolService {

    private PoolRepository poolRepo;

    @Autowired
    public PoolService(PoolRepository repo) {
        this.poolRepo = repo;
    }

    @Transactional(readOnly = true)
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

    @Transactional(readOnly=true)
    public Pool getPoolById(int id) {
        Pool pool = new Pool();
        try {
            pool = poolRepo.findById(id).get();
        } catch (Exception e) {
            throw new ServerErrorException();
        }
        return pool;
    }

    @Transactional
    public Pool createPool(Pool newPool){

        if (
                newPool.getId() <= 0 ||
                newPool.getPoolType().trim().equals("") || newPool.getPoolType() == null ||
                newPool.getPoolCode().trim().equals("") || newPool.getPoolCode() == null ||
                newPool.getLength() <= 0 ||
                newPool.getWidth() <= 0 ||
                newPool.getHeight() <= 0 ||
                newPool.getHopperSize() <= 0
        ){
            throw new BadRequestException("Please give a valid Pool");
        }

        Pool pool;

        try{
            pool = poolRepo.save(newPool);
        } catch (Exception e) {
            throw new DataPercistanceExecption("New pool was not saved");
        }
        return pool;
    }

    public Pool updatePool(Pool updatedPool){

        if (
                updatedPool.getId() <= 0 ||
                updatedPool.getPoolType().trim().equals("") || updatedPool.getPoolType() == null ||
                updatedPool.getPoolCode().trim().equals("") || updatedPool.getPoolCode() == null ||
                updatedPool.getLength() <= 0 ||
                updatedPool.getWidth() <= 0 ||
                updatedPool.getHeight() <= 0 ||
                updatedPool.getHopperSize() <= 0
        ){
            throw new BadRequestException("Please give a valid Pool");
        }

        try{
            poolRepo.findById(updatedPool.getId()).get();
        } catch(Exception e){
            throw new NotFoundException("No Pool found with that ID");
        }

        poolRepo.save(updatedPool);

        return updatedPool;

    }

}
