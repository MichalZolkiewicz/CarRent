package com.carrent.repositories;

import com.carrent.core.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface CarRepository extends CrudRepository<Car, Long> {

    Car findById(long id);
}
