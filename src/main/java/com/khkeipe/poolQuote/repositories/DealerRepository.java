package com.khkeipe.poolQuote.repositories;

import com.khkeipe.poolQuote.entities.PoolDealer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DealerRepository extends CrudRepository<PoolDealer, Integer> {
}
