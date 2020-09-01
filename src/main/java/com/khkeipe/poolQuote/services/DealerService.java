package com.khkeipe.poolQuote.services;

import com.khkeipe.poolQuote.entities.Pool;
import com.khkeipe.poolQuote.entities.PoolDealer;
import com.khkeipe.poolQuote.exceptions.BadRequestException;
import com.khkeipe.poolQuote.exceptions.DataPercistanceExecption;
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
        return dealers;
    }

    @Transactional(readOnly = true)
    public PoolDealer getByDealerId(int id){
        if(id <= 0){
            throw new BadRequestException("Please enter a valid ID");
        }
        PoolDealer retrievedDealer = dealerRepo.findPoolDealerById(id);
        if(retrievedDealer == null){
            throw new DataPercistanceExecption("No dealer with that ID was found");
        }
        return retrievedDealer;
    }

    @Transactional(readOnly = true)
    public PoolDealer getDealerByCode(String code){
        if(code.trim().equals("")){
            throw new BadRequestException("Please enter a valid dealer code");
        }
        PoolDealer retrievedDealer = dealerRepo.findPoolDealerByDealerCode(code);
        if(retrievedDealer == null){
            throw new DataPercistanceExecption("No dealer with that code was found");
        }
        return retrievedDealer;
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
