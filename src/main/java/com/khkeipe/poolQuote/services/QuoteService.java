package com.khkeipe.poolQuote.services;

import com.khkeipe.poolQuote.entities.Quote;
import com.khkeipe.poolQuote.exceptions.*;
import com.khkeipe.poolQuote.repositories.QuoteRepository;
import com.khkeipe.poolQuote.util.GetList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*

    TODO NEEDS:
        -Get quote by dealer
        -Get quote by user

 */

@Service
public class QuoteService {

    private QuoteRepository quoteRepository;

    @Autowired
    public QuoteService(QuoteRepository quoteRepo){
        this.quoteRepository = quoteRepo;
    }

    @Transactional(readOnly = true)
    public List<Quote> getAllQuotes(){

        List<Quote> quotes;
        Iterable<Quote> e;

        try {
            e = quoteRepository.findAll();
            quotes = GetList.getListFromIterable(e);
        } catch (Exception exception) {
            throw new ServerErrorException("Internal server error occurred, unable to fetch quotes");
        }

        if(quotes.isEmpty()) {
            throw new NotFoundException("No quotes were found");
        }

        return quotes;

    }

    @Transactional(readOnly = true)
    public Quote getQuoteById(int id){

        Quote quote;
        try {
            quote = quoteRepository.findById(id).get();
        } catch (Exception e) {
            throw new ServerErrorException("Internal server error occurred");
        }

        return quote;

    }

    @Transactional
    public Quote createQuote(Quote newQuote){

        if(newQuote.getId() <= 0 ) {
            throw new BadRequestException("Please enter a valid ID");
        }

        if(newQuote.getOrderNumber() <= 0 ) {
            throw new BadRequestException("Please enter a valid order number");
        }

        if(newQuote.getRequestDate() == null || newQuote.getRequestDate().trim().equals("") ) {
            throw new BadRequestException("Please enter a valid request date");
        }

        if(newQuote.getQuoteCustomer() == null){
            throw new BadRequestException("Please use a valid customer");
        }

        if(newQuote.getQuoteDealer() == null){
            throw new BadRequestException("Please use a valid dealer");
        }

        try {
            quoteRepository.save(newQuote);
        } catch (Exception e) {
            throw new DataPercistanceExecption("Quote could not be created");
        }

        return newQuote;

    }

}
