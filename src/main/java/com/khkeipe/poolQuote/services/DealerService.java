package com.khkeipe.poolQuote.services;

import com.khkeipe.poolQuote.entities.PoolDealer;
import com.khkeipe.poolQuote.exceptions.BadRequestException;
import com.khkeipe.poolQuote.exceptions.DataPercistanceExecption;
import com.khkeipe.poolQuote.exceptions.NotFoundException;
import com.khkeipe.poolQuote.repositories.DealerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.khkeipe.poolQuote.util.GetList.getListFromIterable;

@Service
public class DealerService {

    private DealerRepository dealerRepo;

    @Autowired
    public DealerService(DealerRepository repo) {
        this.dealerRepo = repo;
    }

    @Transactional(readOnly = true)
    public List<PoolDealer> getAllDealers() {
        List<PoolDealer> dealers = new ArrayList<>();
        dealers = getListFromIterable(dealerRepo.findAll());

        if(dealers.isEmpty()){
            throw new NotFoundException("No Dealers found in the database.");
        }

        return dealers;
    }

    @Transactional(readOnly = true)
    public PoolDealer getDealerById(int id){
        if(id <= 0){
            throw new BadRequestException("Please enter a valid ID");
        }

        PoolDealer foundDealer = dealerRepo.findPoolDealerById(id);

        if(foundDealer == null){
            throw new NotFoundException("No Dealer found with given ID");
        }

        return foundDealer;
    }

    @Transactional
    public PoolDealer createDealer(PoolDealer newDealer) {
        PoolDealer dealer;

        if(newDealer.getDealerName().trim().equals("") || newDealer.getDealerCode().trim().equals("")) {
            throw new BadRequestException("Please enter dealer name and code");
        }

        try {
            dealer = dealerRepo.save(newDealer);
        } catch (Exception e) {
            throw new DataPercistanceExecption("New dealer was not saved");
        }

        return dealer;
    }


}
