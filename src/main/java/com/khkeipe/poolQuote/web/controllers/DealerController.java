package com.khkeipe.poolQuote.web.controllers;

import com.khkeipe.poolQuote.entities.PoolDealer;
import com.khkeipe.poolQuote.services.DealerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dealers")
@CrossOrigin(origins = "http://khkeipe-pool-quote.s3-website-us-east-1.amazonaws.com/")
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

    @GetMapping("/{id}")
    public PoolDealer getDealerById(@PathVariable int id){ return dealerService.getDealerById(id); }

    @PostMapping("")
    public PoolDealer addDealer(@RequestBody PoolDealer newDealer) {
        return dealerService.createDealer(newDealer);
    }
}
