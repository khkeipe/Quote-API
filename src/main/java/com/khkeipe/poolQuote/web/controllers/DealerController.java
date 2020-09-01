package com.khkeipe.poolQuote.web.controllers;

import com.khkeipe.poolQuote.entities.PoolDealer;
import com.khkeipe.poolQuote.services.DealerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dealers")
public class DealerController {

    private DealerService dealerService;

    @Autowired
    public DealerController(DealerService service) {
        this.dealerService = service;
    }

    @GetMapping("")
    public List<PoolDealer> getAllDealers() {
        return dealerService.getAllDealers();
    }

    @GetMapping("/id/{id}")
    public PoolDealer getDealerById(@PathVariable int id){return dealerService.getByDealerId(id);}

    @GetMapping("/code/{code}")
    public PoolDealer getDealerByCode(@PathVariable String code){return dealerService.getDealerByCode(code);}

    @PostMapping("")
    public PoolDealer addDealer(PoolDealer newDealer) {
        return dealerService.createDealer(newDealer);
    }
}
