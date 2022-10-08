package com.carrent.repositories;

import com.carrent.core.Rent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface RentRepository extends CrudRepository<Rent, Long> {

    Rent findById(long id);
}
