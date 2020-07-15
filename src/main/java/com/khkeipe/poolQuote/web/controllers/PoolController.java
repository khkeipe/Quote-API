package com.khkeipe.poolQuote.web.controllers;

import com.khkeipe.poolQuote.entities.Pool;
import com.khkeipe.poolQuote.services.PoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pools")
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
}
