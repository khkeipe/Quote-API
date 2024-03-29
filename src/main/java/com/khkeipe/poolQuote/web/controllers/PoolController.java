package com.khkeipe.poolQuote.web.controllers;

import com.khkeipe.poolQuote.entities.Pool;
import com.khkeipe.poolQuote.services.PoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pools")
@CrossOrigin(origins = "http://khkeipe-pool-quote.s3-website-us-east-1.amazonaws.com/")
public class PoolController {

    private PoolService poolService;

    @Autowired
    public PoolController(PoolService service) {
        this.poolService = service;
    }

    @GetMapping("")
    public List<Pool> getAllPools() {
        return poolService.getAllPools();
    }

    @GetMapping("/{id}")
    public Pool getPoolById(@PathVariable int id) {
        return poolService.getPoolById(id);
    }

    @PostMapping("")
    public Pool createPool(Pool newPool) {
        poolService.createPool(newPool);
        return newPool;
    }
}
