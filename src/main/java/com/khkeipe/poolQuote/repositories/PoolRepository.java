package com.khkeipe.poolQuote.repositories;

import com.khkeipe.poolQuote.entities.Pool;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoolRepository extends CrudRepository<Pool, Integer> {
}
