package com.khkeipe.poolQuote.web.controllers;

import com.khkeipe.poolQuote.services.PoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pools")
public class PoolController {

    private PoolService poolService;

    @Autowired
    public PoolController(PoolService service) {
        this.poolService = service;
    }
}
