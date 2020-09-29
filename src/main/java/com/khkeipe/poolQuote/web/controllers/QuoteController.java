package com.khkeipe.poolQuote.web.controllers;

import com.khkeipe.poolQuote.entities.Quote;
import com.khkeipe.poolQuote.services.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quotes")
public class QuoteController {

    private QuoteService quoteService;

    @Autowired
    public QuoteController(QuoteService quoteService){
        this.quoteService = quoteService;
    }

    @GetMapping("")
    public List<Quote> getAllQuotes(){
        return quoteService.getAllQuotes();
    }

    @GetMapping("/{id}")
    public Quote getQuoteById(@PathVariable("id") int id){
        return quoteService.getQuoteById(id);
    }

    @PostMapping("")
    public Quote createQuote(@RequestBody Quote newQuote){
        return quoteService.createQuote(newQuote);
    }

}
