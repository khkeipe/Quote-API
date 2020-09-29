package com.khkeipe.poolQuote.repositories;

import com.khkeipe.poolQuote.entities.Quote;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuoteRepository extends CrudRepository<Quote, Integer> {
}
