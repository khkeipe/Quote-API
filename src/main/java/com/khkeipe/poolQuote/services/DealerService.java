package com.khkeipe.poolQuote.services;

import com.khkeipe.poolQuote.entities.PoolDealer;
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


}
